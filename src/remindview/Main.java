package remindview;

import java.io.IOException;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.concurrent.Executor;
import java.util.function.Consumer;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import remindview.client.NetworkClient;
import remindview.controller.AuthApi;
import remindview.controller.AuthController;
import remindview.controller.LoginController;
import remindview.controller.NetworkAuthApi;
import remindview.controller.SignupController;
import remindview.protocol.Response;
import remindview.view.MainFrame;

public class Main {

    public static void main(String[] args) {
        // 서버 연결은 Swing 화면 스레드 밖에서 시도
        Thread connectThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    final NetworkClient client =
                            new NetworkClient("127.0.0.1", 9999);

                    // 창 생성과 버튼 연결은 Swing 화면 스레드에서 실행
                    SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            createAndShowGui(client);
                        }
                    });
                } catch (IOException e) {
                    SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            JOptionPane.showMessageDialog(
                                    null,
                                    "서버에 연결할 수 없습니다. 서버 실행 상태를 확인해 주세요.",
                                    "연결 오류",
                                    JOptionPane.ERROR_MESSAGE
                            );
                        }
                    });
                }
            }
        }, "server-connect");

        connectThread.start();
    }

    private static void createAndShowGui(final NetworkClient client) {
        final MainFrame mainFrame = new MainFrame();
        AuthApi authApi = new NetworkAuthApi(client);

        // 서버 요청은 화면을 멈추지 않도록 다른 스레드에서 실행
        Executor networkExecutor = new Executor() {
            @Override
            public void execute(Runnable task) {
                Thread thread = new Thread(task, "auth-request");
                thread.start();
            }
        };

        // 서버 응답에 따른 팝업·화면 변경은 Swing 스레드에서 실행
        Executor guiExecutor = new Executor() {
            @Override
            public void execute(Runnable task) {
                SwingUtilities.invokeLater(task);
            }
        };

        // 기존 AuthController에는 두 화면 전환만 남겨둠
        new AuthController(mainFrame);

        // 로그인 버튼 → 로그인 요청
        new LoginController(
                mainFrame.getLoginPanel(),
                authApi,
                networkExecutor,
                guiExecutor,
                new Consumer<Response>() {
                    @Override
                    public void accept(Response response) {
                        // 로그인 성공 시 실행됨.
                        // UI-03과 응답 data 형식이 정해지면
                        // 회원 정보 저장 및 UI-03 이동 코드를 추가
                    }
                }
        );

        // 가입하기 버튼 → 회원가입 요청
        new SignupController(
                mainFrame.getSignupPanel(),
                authApi,
                networkExecutor,
                guiExecutor,
                new Runnable() {
                    @Override
                    public void run() {
                        mainFrame.showLogin();
                    }
                }
        );

        // 창을 닫을 때 서버 연결 종료
        mainFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                try {
                    client.close();
                } catch (IOException ex) {
                    System.err.println("서버 연결 종료 중 오류가 발생했습니다.");
                }
            }
        });

        mainFrame.setVisible(true);
    }
}