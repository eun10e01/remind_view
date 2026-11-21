package remindview.view;

import java.awt.CardLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainFrame extends JFrame {

    private static final long serialVersionUID = 1L;

    private CardLayout cardLayout;
    private JPanel screenPanel;

    private LoginPanel loginPanel;
    private SignupPanel signupPanel;

    public MainFrame() {
        // 1. 바깥 창 설정
        setTitle("리마인드 뷰");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 2. 두 화면을 담을 공간 만들기
        cardLayout = new CardLayout();
        screenPanel = new JPanel(cardLayout);

        // 네가 보내준 컴포넌트 배치를 담을 수 있는 크기
        screenPanel.setPreferredSize(new Dimension(700,550));

        // 3. 이미 디자인한 패널 생성
        loginPanel = new LoginPanel();
        signupPanel = new SignupPanel();

        // 4. 화면에 이름을 붙여 등록
        screenPanel.add(loginPanel, "LOGIN");
        screenPanel.add(signupPanel, "SIGNUP");

        // 5. 패널들을 담은 공간을 창의 내용으로 설정
        setContentPane(screenPanel);

        pack();                      // 내용의 권장 크기에 맞춰 창 크기 설정
        setResizable(false);         // 창 크기 변경 막기
        setLocationRelativeTo(null); // 모니터 가운데 배치

        // 6. 처음에는 로그인 화면 표시
        showLogin();
    }

    // 로그인 화면 표시
    public void showLogin() {
        cardLayout.show(screenPanel, "LOGIN");
    }

    // 회원가입 화면 표시
    public void showSignup() {
        cardLayout.show(screenPanel, "SIGNUP");
    }

    // Controller가 각 패널에 접근할 수 있도록 제공
    public LoginPanel getLoginPanel() {
        return loginPanel;
    }

    public SignupPanel getSignupPanel() {
        return signupPanel;
    }
}