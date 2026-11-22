package remindview;
import java.util.Scanner;
import remindview.view.LoginConsoleView;

public class LoginConsoleTest {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LoginConsoleView view = new LoginConsoleView(scanner);

        // 지금은 실제 로그인 대신 연결 확인용 동작을 등록
        view.setLoginAction(() -> {
            view.showMessage(
                "입력받은 아이디: " + view.getLoginId()
            );
            view.showMessage(
                "로그인 동작 연결 확인 완료 — 서버 요청은 아직 보내지 않았습니다."
            );
        });

        try {
            view.start();
        } finally {
            view.clearPassword();
        }
    }
}