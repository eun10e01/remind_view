package remindview.view;

import javax.swing.JPanel;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.SystemColor;

public class LoginPanel extends JPanel implements LoginView {

	private static final long serialVersionUID = 1L;
	private JTextField idField;
	private JPasswordField passwordField;
	private JButton openSignupButton;
	private JButton loginButton;
	/**
	 * Create the panel.
	 */
	public LoginPanel() {
		setLayout(null);
		setBackground(Color.WHITE);
		
		JLabel titleLabel = new JLabel("리마인드 뷰");
		titleLabel.setFont(new Font("굴림", Font.BOLD, 28));
		titleLabel.setBounds(170, 65, 360, 40);
		add(titleLabel);
		
		JLabel partTitleLabel = new JLabel("YouTube 노트를 공유하고, 함께 기억해요.");
		partTitleLabel.setFont(new Font("굴림", Font.PLAIN, 14));
		partTitleLabel.setBounds(170, 112, 360, 24);
		add(partTitleLabel);
		
		JLabel idLabel = new JLabel("아이디");
		idLabel.setFont(new Font("굴림", Font.BOLD, 14));
		idLabel.setBounds(170, 165, 360, 22);
		add(idLabel);
		
		idField = new JTextField();
		idField.setBounds(170, 193, 360, 38);
		add(idField);
		idField.setColumns(10);
		
		JLabel passwordLabel = new JLabel("비밀번호");
		passwordLabel.setFont(new Font("굴림", Font.BOLD, 14));
		passwordLabel.setBounds(170, 251, 360, 22);
		add(passwordLabel);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(170, 279, 360, 38);
		add(passwordField);
		
		loginButton = new JButton("로그인");
		// 기본 테마 대신 단순한 버튼 모양을 사용
		loginButton.setUI(new javax.swing.plaf.basic.BasicButtonUI());

		loginButton.setContentAreaFilled(true);
		loginButton.setOpaque(true);

		loginButton.setBackground(java.awt.Color.BLACK);
		loginButton.setForeground(java.awt.Color.WHITE);

		loginButton.setBorderPainted(false);
		loginButton.setFocusPainted(false);
		loginButton.setBounds(170, 350, 170, 42);
		add(loginButton);
		
		openSignupButton = new JButton("회원가입");
		openSignupButton.setBackground(SystemColor.control);
		openSignupButton.setBounds(360, 350, 170, 42);
		add(openSignupButton);

	}
	
	public JButton getOpenSignupButton() {
	    return openSignupButton;
	}

	@Override
	public String getLoginId() {
	    return idField.getText();
	}

	@Override
	public char[] getPassword() {
	    return passwordField.getPassword();
	}

	@Override
	public void setLoginAction(Runnable action) {
	    loginButton.addActionListener(e -> action.run());
	}

	@Override
	public void showMessage(String message) {
	    JOptionPane.showMessageDialog(
	        this,
	        message,
	        "안내",
	        JOptionPane.INFORMATION_MESSAGE
	    );
	}

	@Override
	public void showError(String message) {
	    JOptionPane.showMessageDialog(
	        this,
	        message,
	        "오류",
	        JOptionPane.ERROR_MESSAGE
	    );
	}
}
