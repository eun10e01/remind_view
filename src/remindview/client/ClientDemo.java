package remindview.client;

import remindview.protocol.Request;
import remindview.protocol.Response;

import java.io.IOException;

/**
 * 화면(Swing) 없이 서버 통신이 잘 되는지 확인하는 테스트용 클라이언트.
 * ServerMain을 먼저 실행한 뒤 이 파일을 실행한다.
 *
 * 1) PING 요청 → PONG 응답
 * 2) 모르는 명령 → 실패 응답
 * 3) 클라이언트 5명이 동시에 접속해 각자 PING을 3번씩 보냄 (멀티스레드 확인)
 *
 * 인자(선택): [서버주소]   예) 127.0.0.1
 */
public class ClientDemo {

    private static final int PORT = 9999;

    public static void main(String[] args) throws Exception {
        String host = args.length > 0 ? args[0] : "127.0.0.1";

        try (NetworkClient client = new NetworkClient(host, PORT)) {
            show("1. PING", client.send(new Request("PING")));
            show("2. 모르는 명령", client.send(new Request("HELLO")));
        }

        System.out.println("3. 동시 접속 테스트 (클라이언트 5명)");
        Thread[] threads = new Thread[5];
        for (int i = 0; i < threads.length; i++) {
            final int no = i + 1;
            threads[i] = new Thread(() -> {
                try (NetworkClient c = new NetworkClient(host, PORT)) {
                    for (int n = 1; n <= 3; n++) {
                        Response r = c.send(new Request("PING"));
                        System.out.println("    클라이언트" + no + " - " + n + "번째 → " + r.getMessage());
                    }
                } catch (IOException e) {
                    System.out.println("    클라이언트" + no + " 오류: " + e.getMessage());
                }
            });
            threads[i].start();
        }
        for (Thread t : threads) {
            t.join();
        }
        System.out.println("테스트 끝");
    }

    private static void show(String title, Response response) {
        System.out.println(title + "\n    → " + response);
    }
}
