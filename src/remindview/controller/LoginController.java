package remindview.controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.concurrent.Executor;
import java.util.function.Consumer;

import remindview.protocol.Response;
import remindview.view.LoginView;

public class LoginController {

    private final LoginView view;
    private final AuthApi authApi;
    private final Executor networkExecutor;
    private final Executor viewExecutor;
    private final Consumer<Response> onLoginSuccess;

    public LoginController(
            LoginView view,
            AuthApi authApi,
            Executor networkExecutor,
            Executor viewExecutor,
            Consumer<Response> onLoginSuccess) {

        this.view = view;
        this.authApi = authApi;
        this.networkExecutor = networkExecutor;
        this.viewExecutor = viewExecutor;
        this.onLoginSuccess = onLoginSuccess;

        // 로그인 버튼을 눌렀을 때 실행할 동작 등록
        view.setLoginAction(new Runnable() {
            @Override
            public void run() {
                handleLogin();
            }
        });
    }

    private void handleLogin() {
        final String loginId = view.getLoginId();
        char[] password = view.getPassword();

        try {
            if (loginId == null || loginId.trim().isEmpty()
                    || password.length == 0) {
                view.showError("아이디와 비밀번호를 입력해 주세요.");
                return;
            }

            // 서버의 Request.getString("password")로 읽을 수 있도록 변환
            final String passwordText = new String(password);

            // 서버 응답을 기다리는 작업 실행
            networkExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        final Response response =
                                authApi.login(loginId, passwordText);

                        // 받은 응답을 View에 반영
                        viewExecutor.execute(new Runnable() {
                            @Override
                            public void run() {
                                if (response.isSuccess()) {
                                    view.showMessage(response.getMessage());
                                    onLoginSuccess.accept(response);
                                } else {
                                    view.showError(response.getMessage());
                                }
                            }
                        });
                    } catch (IOException e) {
                        viewExecutor.execute(new Runnable() {
                            @Override
                            public void run() {
                                view.showError("서버와 통신할 수 없습니다.");
                            }
                        });
                    }
                }
            });
        } finally {
            Arrays.fill(password, '\0');
        }
    }
}