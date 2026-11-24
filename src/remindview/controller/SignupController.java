package remindview.controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.concurrent.Executor;

import remindview.protocol.Response;
import remindview.view.SignupView;

public class SignupController {

    private final SignupView view;
    private final AuthApi authApi;
    private final Executor networkExecutor;
    private final Executor viewExecutor;
    private final Runnable onSignupSuccess;

    public SignupController(
            SignupView view,
            AuthApi authApi,
            Executor networkExecutor,
            Executor viewExecutor,
            Runnable onSignupSuccess) {

        this.view = view;
        this.authApi = authApi;
        this.networkExecutor = networkExecutor;
        this.viewExecutor = viewExecutor;
        this.onSignupSuccess = onSignupSuccess;

        // 가입하기 버튼을 눌렀을 때 실행할 동작 등록
        view.setSignupAction(new Runnable() {
            @Override
            public void run() {
                handleSignup();
            }
        });
    }

    private void handleSignup() {
        final String loginId = view.getLoginId();
        char[] password = view.getPassword();
        final String nickname = view.getNickname();

        try {
            if (loginId == null || loginId.trim().isEmpty()
                    || password.length == 0
                    || nickname == null || nickname.trim().isEmpty()) {
                view.showError("아이디, 비밀번호, 닉네임을 모두 입력해 주세요.");
                return;
            }

            final String passwordText = new String(password);

            networkExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        final Response response = authApi.register(
                                loginId, passwordText, nickname);

                        viewExecutor.execute(new Runnable() {
                            @Override
                            public void run() {
                                if (response.isSuccess()) {
                                    view.showMessage(response.getMessage());
                                    onSignupSuccess.run();
                                } else {
                                    // 아이디/닉네임 중복 사유를 서버 문구대로 표시
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