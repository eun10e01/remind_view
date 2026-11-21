package remindview.client;

import remindview.protocol.Request;
import remindview.protocol.Response;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * 서버와 소켓으로 연결하고 Request를 보내 Response를 받는 클래스.
 * 프로그램 전체에서 하나만 만들어 쓴다. (Controller가 이 객체를 받아서 사용)
 *
 * 사용 예:
 *   NetworkClient client = new NetworkClient("127.0.0.1", 9999);
 *   Response res = client.send(new Request(Command.LOGIN).put("loginId", "a").put("password", "1234"));
 *   client.close();
 */
public class NetworkClient implements AutoCloseable {

    private final Socket socket;
    private final ObjectOutputStream out;
    private final ObjectInputStream in;

    public NetworkClient(String host, int port) throws IOException {
        this.socket = new Socket(host, port);
        // 서버와 같은 순서: 출력 스트림 먼저 만들고 flush, 그 다음 입력 스트림
        this.out = new ObjectOutputStream(socket.getOutputStream());
        this.out.flush();
        this.in = new ObjectInputStream(socket.getInputStream());
    }

    /**
     * 요청을 보내고 응답이 올 때까지 기다린다.
     * 여러 곳에서 동시에 부르더라도 요청-응답 짝이 섞이지 않도록 synchronized.
     */
    public synchronized Response send(Request request) throws IOException {
        out.writeObject(request);
        out.flush();
        out.reset();
        try {
            return (Response) in.readObject();
        } catch (ClassNotFoundException e) {
            throw new IOException("서버 응답을 해석할 수 없습니다.", e);
        }
    }

    @Override
    public void close() throws IOException {
        socket.close();
    }
}
