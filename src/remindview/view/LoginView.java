package remindview.view;

public interface LoginView {

    // 입력받은 아이디 제공
    String getLoginId();

    // 입력받은 비밀번호 제공
    char[] getPassword();

    // 로그인 실행 시 수행할 동작 연결
    void setLoginAction(Runnable action);

    // 안내 메시지 표시
    void showMessage(String message);

    // 오류 메시지 표시
    void showError(String message);
}