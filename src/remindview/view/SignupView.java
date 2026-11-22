package remindview.view;

public interface SignupView {

    String getLoginId();

    char[] getPassword();

    String getNickname();

    // 가입 실행 시 수행할 동작 연결
    void setSignupAction(Runnable action);

    void showMessage(String message);

    void showError(String message);
}