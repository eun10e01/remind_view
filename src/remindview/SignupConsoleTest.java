package remindview;

import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.Executor;

import remindview.client.NetworkClient;
import remindview.controller.AuthApi;
import remindview.controller.NetworkAuthApi;
import remindview.controller.SignupController;
import remindview.view.SignupConsoleView;

public class SignupConsoleTest {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SignupConsoleView view = new SignupConsoleView(scanner);

        try (NetworkClient client = new NetworkClient("127.0.0.1", 9999)) {
            AuthApi authApi = new NetworkAuthApi(client);

            Executor directExecutor = new Executor() {
                @Override
                public void execute(Runnable task) {
                    task.run();
                }
            };

            // Controller를 만들면 회원가입 동작이 콘솔뷰에 연결됨
            new SignupController(
                    view,
                    authApi,
                    directExecutor,
                    directExecutor,
                    new Runnable() {
                        @Override
                        public void run() {
                            // 콘솔에는 이동할 로그인 화면이 없으므로 추가 동작 없음.
                            // 가입 성공 메시지는 SignupController가 이미 출력함.
                        }
                    }
            );

            // 아이디·비밀번호·닉네임 입력 → 실제 서버에 REGISTER 요청
            view.start();

        } catch (IOException e) {
            view.showError("서버에 연결할 수 없거나 통신 중 오류가 발생했습니다.");
        } finally {
            view.clearPassword();
        }
    }
}