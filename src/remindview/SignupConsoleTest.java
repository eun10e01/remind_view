package remindview;

import java.util.Arrays;
import java.util.Scanner;

import remindview.view.SignupConsoleView;

public class SignupConsoleTest {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SignupConsoleView view = new SignupConsoleView(scanner);

        // 실제 가입 대신 연결 확인용 동작 등록
        view.setSignupAction(() -> {
            view.showMessage("입력받은 아이디: " + view.getLoginId());
            view.showMessage("입력받은 닉네임: " + view.getNickname());

            char[] password = view.getPassword();
            try {
                // 비밀번호 자체는 출력하지 않음
                view.showMessage("비밀번호 입력 글자 수: " + password.length);
            } finally {
                Arrays.fill(password, '\0');
            }

            view.showMessage(
                "가입 동작 연결 확인 완료 — 서버 요청은 아직 보내지 않았습니다."
            );
        });

        try {
            view.start();
        } finally {
            view.clearPassword();
        }
    }
}