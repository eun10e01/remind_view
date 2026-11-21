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
		titleLabel.setFont(new Font("굴림", Font.BOLD, 16));
		titleLabel.setBounds(28, 10, 106, 28);
		add(titleLabel);
		
		JLabel partTitleLabel = new JLabel("YouTube 노트를 공유하고, 함께 기억해요.");
		partTitleLabel.setFont(new Font("굴림", Font.PLAIN, 12));
		partTitleLabel.setBounds(28, 40, 233, 14);
		add(partTitleLabel);
		
		JLabel idLabel = new JLabel("아이디");
		idLabel.setFont(new Font("굴림", Font.BOLD, 12));
		idLabel.setBounds(28, 71, 52, 14);
		add(idLabel);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(28, 95, 233, 20);
		add(textField);
		
		JLabel passwordLabel = new JLabel("비밀번호");
		passwordLabel.setFont(new Font("굴림", Font.BOLD, 12));
		passwordLabel.setBounds(28, 125, 52, 14);
		add(passwordLabel);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(28, 149, 233, 20);
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
		registerButton.setBounds(28, 240, 94, 22);
		add(registerButton);
		
		backToLoginButton = new JButton("로그인으로 돌아가기");
		backToLoginButton.setBackground(SystemColor.control);
		backToLoginButton.setBounds(139, 240, 145, 22);
		add(backToLoginButton);
		
		JLabel nicknameLabel = new JLabel("닉네임");
		nicknameLabel.setFont(new Font("굴림", Font.BOLD, 12));
		nicknameLabel.setBounds(28, 178, 52, 14);
		add(nicknameLabel);
		
		nicknameField = new JTextField();
		nicknameField.setBounds(28, 199, 106, 20);
		add(nicknameField);
		nicknameField.setColumns(10);

	}
	
	public JButton getBackToLoginButton() {
	    return backToLoginButton;
	}
}
