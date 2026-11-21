package remindview.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 서버 시작점. ServerSocket으로 접속을 기다리다가(accept),
 * 클라이언트가 접속할 때마다 ClientHandler 스레드를 하나 만들어 시작한다.
 */
public class ServerMain {

    public static final int PORT = 9999;

    public static void main(String[] args) throws IOException {
        RequestRouter router = new RequestRouter();

        int count = 0;
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("[서버 시작] 포트 " + PORT + "에서 접속을 기다립니다.");
            while (true) {
                Socket socket = serverSocket.accept(); // 접속이 올 때까지 여기서 멈춰 있다
                Thread thread = new Thread(new ClientHandler(socket, router), "client-" + (++count));
                thread.start();
            }
        }
    }
}
