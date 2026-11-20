package remindview.server;

import remindview.protocol.Request;
import remindview.protocol.Response;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.SocketException;

/**
 * 클라이언트 1명만 전담하는 스레드.
 * 요청 받기 → RequestRouter로 처리 → 응답 보내기를 연결이 끊길 때까지 반복한다.
 */
public class ClientHandler implements Runnable {

    private final Socket socket;
    private final RequestRouter router;

    public ClientHandler(Socket socket, RequestRouter router) {
        this.socket = socket;
        this.router = router;
    }

    @Override
    public void run() {
        String who = socket.getRemoteSocketAddress().toString();
        System.out.println("[접속] " + who + " (" + Thread.currentThread().getName() + ")");

        try (Socket s = socket) {
            // 주의: 출력 스트림을 먼저 만들고 flush한 뒤 입력 스트림을 만든다. (클라이언트도 같은 순서)
            ObjectOutputStream out = new ObjectOutputStream(s.getOutputStream());
            out.flush();
            ObjectInputStream in = new ObjectInputStream(s.getInputStream());

            while (true) {
                Object received = in.readObject();
                Response response;
                if (received instanceof Request) {
                    Request request = (Request) received;
                    System.out.println("[요청] " + who + " " + request);
                    response = router.route(request);
                } else {
                    response = Response.fail("잘못된 요청 형식입니다.");
                }
                out.writeObject(response);
                out.flush();
                out.reset(); // 같은 객체를 다시 보내도 최신 내용이 전달되도록 캐시를 비운다
            }
        } catch (EOFException | SocketException e) {
            // 클라이언트가 정상적으로 연결을 끊은 경우
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("[통신 오류] " + who + " : " + e.getMessage());
        } finally {
            System.out.println("[종료] " + who);
        }
    }
}
