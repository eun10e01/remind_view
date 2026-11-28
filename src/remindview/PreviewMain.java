package remindview;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import remindview.view.MainFrame;

public class PreviewMain {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                String[] screens = {
                    "UI-01 로그인",
                    "UI-02 회원가입",
                    "UI-03 메인",
                    "UI-04 기록 작성·수정",
                    "UI-05 기록 상세",
                    "UI-06 마이페이지",
                    "UI-07 다른 사용자 프로필",
                    "UI-08 알림"
                };

                String selected = (String) JOptionPane.showInputDialog(
                    null,
                    "확인할 화면을 선택하세요.",
                    "리마인드 뷰 화면 미리보기",
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    screens,
                    screens[2]
                );

                // 선택 창에서 취소를 누른 경우 종료
                if (selected == null) {
                    return;
                }

                MainFrame mainFrame = new MainFrame();

                switch (selected) {
                    case "UI-01 로그인":
                        mainFrame.showLogin();
                        break;
                    case "UI-02 회원가입":
                        mainFrame.showSignup();
                        break;
                    case "UI-03 메인":
                        mainFrame.showMain();
                        break;
                    case "UI-04 기록 작성·수정":
                        mainFrame.showRecordForm();
                        break;
                    case "UI-05 기록 상세":
                        mainFrame.showRecordDetail();
                        break;
                    case "UI-06 마이페이지":
                        mainFrame.showMyPage();
                        break;
                    case "UI-07 다른 사용자 프로필":
                        mainFrame.showUserProfile();
                        break;
                    case "UI-08 알림":
                        mainFrame.showNotification();
                        break;
                    default:
                        return;
                }

                mainFrame.setVisible(true);
            }
        });
    }
}