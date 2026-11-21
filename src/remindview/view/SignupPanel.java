package remindview.view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SignupPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JPasswordField passwordField;
	private JTextField nicknameField;
	private JButton backToLoginButton;
	
	/**
	 * Create the panel.
	 */
	public SignupPanel() {
		setLayout(null);
		
		JLabel titleLabel = new JLabel("회원가입");
		titleLabel.setFont(new Font("굴림", Font.BOLD, 28));
		titleLabel.setBounds(170, 40, 360, 40);
		add(titleLabel);
		
		JLabel partTitleLabel = new JLabel("YouTube 노트를 공유하고, 함께 기억해요.");
		partTitleLabel.setFont(new Font("굴림", Font.PLAIN, 14));
		partTitleLabel.setBounds(170, 87, 360, 24);
		add(partTitleLabel);
		
		JLabel idLabel = new JLabel("아이디");
		idLabel.setFont(new Font("굴림", Font.BOLD, 14));
		idLabel.setBounds(170, 130, 360, 22);
		add(idLabel);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(170, 158, 360, 38);
		add(textField);
		
		JLabel passwordLabel = new JLabel("비밀번호");
		passwordLabel.setFont(new Font("굴림", Font.BOLD, 14));
		passwordLabel.setBounds(170, 211, 360, 22);
		add(passwordLabel);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(170, 239, 360, 38);
		add(passwordField);
		
		JButton registerButton = new JButton("가입하기");
		registerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		registerButton.setOpaque(true);
		registerButton.setForeground(Color.WHITE);
		registerButton.setFocusPainted(false);
		registerButton.setContentAreaFilled(true);
		registerButton.setBorderPainted(false);
		registerButton.setBackground(Color.BLACK);
		registerButton.setBounds(170, 395, 170, 42);
		add(registerButton);
		
		backToLoginButton = new JButton("로그인으로 돌아가기");
		backToLoginButton.setBackground(SystemColor.control);
		backToLoginButton.setBounds(360, 395, 170, 42);
		add(backToLoginButton);
		
		JLabel nicknameLabel = new JLabel("닉네임");
		nicknameLabel.setFont(new Font("굴림", Font.BOLD, 14));
		nicknameLabel.setBounds(170, 292, 360, 22);
		add(nicknameLabel);
		
		nicknameField = new JTextField();
		nicknameField.setBounds(170, 320, 360, 38);
		add(nicknameField);
		nicknameField.setColumns(10);

	}
	
	public JButton getBackToLoginButton() {
	    return backToLoginButton;
	}
}
