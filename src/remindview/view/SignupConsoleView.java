package remindview.view;

import java.util.Arrays;
import java.util.Scanner;

public class SignupConsoleView implements SignupView {

    private final Scanner scanner;

    private String loginId = "";
    private char[] password = new char[0];
    private String nickname = "";

    // Controller에서 전달받은 가입 동작
    private Runnable signupAction;

    public SignupConsoleView(Scanner scanner) {
        this.scanner = scanner;
    }

    // 콘솔에서 가입 정보를 입력받고 가입 동작 실행
    public void start() {
        if (signupAction == null) {
            throw new IllegalStateException(
                "가입 동작을 연결한 후 start()를 호출해주세요."
            );
        }

        System.out.println("\n=== 리마인드뷰 회원가입 ===");

        System.out.print("아이디: ");
        loginId = scanner.nextLine();

        // 이전에 입력받은 비밀번호 지우기
        Arrays.fill(password, '\0');

        System.out.print("비밀번호: ");
        password = scanner.nextLine().toCharArray();

        System.out.print("닉네임: ");
        nickname = scanner.nextLine();

        // Controller에서 연결한 동작 실행
        signupAction.run();
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
    public String getNickname() {
        return nickname;
    }

    @Override
    public void setSignupAction(Runnable action) {
        this.signupAction = action;
    }

    @Override
    public void showMessage(String message) {
        System.out.println("[안내] " + message);
    }

    @Override
    public void showError(String message) {
        System.out.println("[오류] " + message);
    }

    public void clearPassword() {
        Arrays.fill(password, '\0');
        password = new char[0];
    }
}