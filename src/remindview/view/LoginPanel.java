package remindview.view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.SystemColor;

public class LoginPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField idField;
	private JPasswordField passwordField;
	private JButton openSignupButton;
	/**
	 * Create the panel.
	 */
	public LoginPanel() {
		setLayout(null);
		
		JLabel titleLabel = new JLabel("리마인드 뷰");
		titleLabel.setFont(new Font("굴림", Font.BOLD, 16));
		titleLabel.setBounds(27, 10, 106, 28);
		add(titleLabel);
		
		JLabel partTitleLabel = new JLabel("YouTube 노트를 공유하고, 함께 기억해요.");
		partTitleLabel.setFont(new Font("굴림", Font.PLAIN, 12));
		partTitleLabel.setBounds(27, 40, 233, 14);
		add(partTitleLabel);
		
		JLabel idLabel = new JLabel("아이디");
		idLabel.setFont(new Font("굴림", Font.BOLD, 12));
		idLabel.setBounds(27, 71, 52, 14);
		add(idLabel);
		
		idField = new JTextField();
		idField.setBounds(27, 95, 233, 20);
		add(idField);
		idField.setColumns(10);
		
		JLabel passwordLabel = new JLabel("비밀번호");
		passwordLabel.setFont(new Font("굴림", Font.BOLD, 12));
		passwordLabel.setBounds(27, 129, 52, 14);
		add(passwordLabel);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(27, 153, 233, 20);
		add(passwordField);
		
		JButton loginButton = new JButton("로그인");
		// 기본 테마 대신 단순한 버튼 모양을 사용
		loginButton.setUI(new javax.swing.plaf.basic.BasicButtonUI());

		loginButton.setContentAreaFilled(true);
		loginButton.setOpaque(true);

		loginButton.setBackground(java.awt.Color.BLACK);
		loginButton.setForeground(java.awt.Color.WHITE);

		loginButton.setBorderPainted(false);
		loginButton.setFocusPainted(false);
		loginButton.setBounds(27, 200, 94, 22);
		add(loginButton);
		
		openSignupButton = new JButton("회원가입");
		openSignupButton.setBackground(SystemColor.control);
		openSignupButton.setBounds(138, 200, 94, 22);
		add(openSignupButton);

	}
	
	public JButton getOpenSignupButton() {
	    return openSignupButton;
	}
}
