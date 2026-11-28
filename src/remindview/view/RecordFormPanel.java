package remindview.view;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;

public class RecordFormPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField youtubeUrlField;
	private JTextField recordTitleField;

	/**
	 * Create the panel.
	 */
	public RecordFormPanel() {
	    setLayout(null);
	    setBackground(Color.WHITE);

	    JLabel titleLabel = new JLabel("기록 작성 · 수정");
	    titleLabel.setFont(new Font("Dialog", Font.BOLD, 23));
	    titleLabel.setBounds(32, 27, 300, 38);
	    add(titleLabel);

	    JLabel urlLabel = new JLabel("YouTube URL");
	    urlLabel.setFont(new Font("Dialog", Font.BOLD, 13));
	    urlLabel.setBounds(32, 78, 150, 20);
	    add(urlLabel);

	    youtubeUrlField = new JTextField();
	    youtubeUrlField.setBounds(32, 103, 634, 34);
	    add(youtubeUrlField);

	    JLabel recordTitleLabel = new JLabel("제목");
	    recordTitleLabel.setFont(new Font("Dialog", Font.BOLD, 13));
	    recordTitleLabel.setBounds(32, 151, 150, 20);
	    add(recordTitleLabel);

	    recordTitleField = new JTextField();
	    recordTitleField.setBounds(32, 176, 634, 34);
	    add(recordTitleField);

	    JLabel recordFormLabel = new JLabel("내용");
	    recordFormLabel.setFont(new Font("Dialog", Font.BOLD, 13));
	    recordFormLabel.setBounds(32, 224, 150, 20);
	    add(recordFormLabel);

	    JScrollPane scrollPane = new JScrollPane();
	    scrollPane.setBounds(32, 249, 634, 166);
	    add(scrollPane);

	    JTextArea recordFormTextArea = new JTextArea();
	    recordFormTextArea.setLineWrap(true);
	    recordFormTextArea.setWrapStyleWord(true);
	    recordFormTextArea.setMargin(new java.awt.Insets(10, 10, 10, 10));
	    scrollPane.setViewportView(recordFormTextArea);

	    JLabel visibilityLabel = new JLabel("공개 설정");
	    visibilityLabel.setFont(new Font("Dialog", Font.BOLD, 13));
	    visibilityLabel.setBounds(32, 428, 150, 20);
	    add(visibilityLabel);

	    JRadioButton publicRadioButton = new JRadioButton("공개");
	    publicRadioButton.setBackground(Color.WHITE);
	    publicRadioButton.setBounds(28, 451, 80, 26);
	    add(publicRadioButton);

	    JRadioButton privateRadioButton = new JRadioButton("비공개");
	    privateRadioButton.setBackground(Color.WHITE);
	    privateRadioButton.setBounds(110, 451, 90, 26);
	    add(privateRadioButton);

	    ButtonGroup visibilityGroup = new ButtonGroup();
	    visibilityGroup.add(publicRadioButton);
	    visibilityGroup.add(privateRadioButton);
	    publicRadioButton.setSelected(true);

	    JButton saveButton = new JButton("저장");
	    saveButton.setBounds(32, 488, 70, 34);
	    add(saveButton);

	    JButton cancelButton = new JButton("취소");
	    cancelButton.setBounds(112, 488, 70, 34);
	    add(cancelButton);
	}
}
