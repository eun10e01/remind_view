package remindview.view;

import java.util.Arrays;
import java.util.Scanner;

public class LoginConsoleView implements LoginView {

    private final Scanner scanner;

    private String loginId = "";
    private char[] password = new char[0];

    // Controller에서 전달받은 로그인 동작
    private Runnable loginAction;

    public LoginConsoleView(Scanner scanner) {
        this.scanner = scanner;
    }

    // 콘솔에서 로그인 정보를 입력받고 로그인 동작 실행
    public void start() {
        if (loginAction == null) {
            throw new IllegalStateException(
                "로그인 동작을 연결한 후 start()를 호출해주세요."
            );
        }

        System.out.println("\n=== 리마인드뷰 로그인 ===");

        System.out.print("아이디: ");
        loginId = scanner.nextLine();

        // 이전에 입력받은 비밀번호 지우기
        Arrays.fill(password, '\0');

        System.out.print("비밀번호: ");
        password = scanner.nextLine().toCharArray();

        // Controller에서 연결한 동작 실행
        loginAction.run();
    }

    @Override
    public String getLoginId() {
        return loginId;
    }

    @Override
    public char[] getPassword() {
        return password.clone();
    }

    @Override
    public void setLoginAction(Runnable action) {
        this.loginAction = action;
    }

    @Override
    public void showMessage(String message) {
        System.out.println("[안내] " + message);
    }

    @Override
    public void showError(String message) {
        System.out.println("[오류] " + message);
    }

    // 테스트 종료 시 보관한 비밀번호 지우기
    public void clearPassword() {
        Arrays.fill(password, '\0');
        password = new char[0];
    }
}