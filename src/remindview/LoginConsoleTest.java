package remindview;

import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.Executor;
import java.util.function.Consumer;

import remindview.client.NetworkClient;
import remindview.controller.AuthApi;
import remindview.controller.LoginController;
import remindview.controller.NetworkAuthApi;
import remindview.protocol.Response;
import remindview.view.LoginConsoleView;

public class LoginConsoleTest {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LoginConsoleView view = new LoginConsoleView(scanner);

        try (NetworkClient client = new NetworkClient("127.0.0.1", 9999)) {
            AuthApi authApi = new NetworkAuthApi(client);

            // 콘솔 테스트에서는 작업을 전달받은 자리에서 바로 실행
            Executor directExecutor = new Executor() {
                @Override
                public void execute(Runnable task) {
                    task.run();
                }
            };

            // Controller를 만들면 로그인 동작이 콘솔뷰에 연결됨
            new LoginController(
                    view,
                    authApi,
                    directExecutor,
                    directExecutor,
                    new Consumer<Response>() {
                        @Override
                        public void accept(Response response) {
                            // 로그인 성공 후 실행할 추가 동작.
                            // 성공 메시지는 LoginController가 이미 출력함.
                        }
                    }
            );

            // 아이디·비밀번호 입력 → 실제 서버에 LOGIN 요청
            view.start();

        } catch (IOException e) {
            view.showError("서버에 연결할 수 없거나 통신 중 오류가 발생했습니다.");
        } finally {
            view.clearPassword();
        }
    }
}