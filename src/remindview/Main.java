package remindview;

import javax.swing.SwingUtilities;

import remindview.controller.AuthController;
import remindview.view.MainFrame;

public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // 창과 그 안의 두 패널 생성
            MainFrame mainFrame = new MainFrame();

            // 그 창의 버튼에 동작 연결
            new AuthController(mainFrame);

            // 창 표시
            mainFrame.setVisible(true);
        });
    }
}