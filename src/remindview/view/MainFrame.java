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
    private MainRecordPanel mainRecordPanel;
    private RecordFormPanel recordFormPanel;
    private RecordDetailPanel recordDetailPanel;
    private MyPagePanel myPagePanel;
    private NotificationPanel notificationPanel;
    private UserProfilePanel userProfilePanel;
    
    public MainFrame() {
        // 1. 바깥 창 설정
        setTitle("리마인드 뷰");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 2. 두 화면을 담을 공간 만들기
        cardLayout = new CardLayout();
        screenPanel = new JPanel(cardLayout);

        screenPanel.setPreferredSize(new Dimension(700,550));

        // 3. 이미 디자인한 패널 생성
        loginPanel = new LoginPanel();
        signupPanel = new SignupPanel();
        mainRecordPanel = new MainRecordPanel();
        recordFormPanel = new RecordFormPanel();
        recordDetailPanel = new RecordDetailPanel();
        myPagePanel = new MyPagePanel();
        userProfilePanel = new UserProfilePanel();
        notificationPanel = new NotificationPanel();

        // 4. 화면에 이름을 붙여 등록
        screenPanel.add(loginPanel, "LOGIN");
        screenPanel.add(signupPanel, "SIGNUP");
        screenPanel.add(mainRecordPanel, "MAIN_RECORD");
        screenPanel.add(recordFormPanel, "RECORD_FORM");
        screenPanel.add(recordDetailPanel, "RECORD_DETAIL");
        screenPanel.add(myPagePanel, "MYPAGE");
        screenPanel.add(userProfilePanel, "USER_PROFILE");
        screenPanel.add(notificationPanel, "NOTIFICATION");

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
    
   public void showMain() {
	   cardLayout.show(screenPanel, "MAIN_RECORD");
   }

   public void showRecordForm() {
	   cardLayout.show(screenPanel, "RECORD_FORM");
   }

   public void showRecordDetail() {
	   cardLayout.show(screenPanel, "RECORD_DETAIL");
   }

   public void showMyPage() {
	   cardLayout.show(screenPanel, "MYPAGE");
   }

   public void showUserProfile() {
	   cardLayout.show(screenPanel, "USER_PROFILE");
   }

   public void showNotification() {
	   cardLayout.show(screenPanel, "NOTIFICATION");
   }

    // Controller가 각 패널에 접근할 수 있도록 제공
    public LoginPanel getLoginPanel() {
        return loginPanel;
    }

    public SignupPanel getSignupPanel() {
        return signupPanel;
    }
    
    
}