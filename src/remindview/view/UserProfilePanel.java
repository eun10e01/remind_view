package remindview.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

public class UserProfilePanel extends JPanel {

    private static final long serialVersionUID = 1L;

    public UserProfilePanel() {
        setLayout(null);
        setBackground(Color.WHITE);

        JPanel profilePanel = new JPanel();
        profilePanel.setLayout(null);
        profilePanel.setBackground(Color.WHITE);
        profilePanel.setBounds(32, 28, 634, 113);
        profilePanel.setBorder(new MatteBorder(
                0, 0, 1, 0, new Color(220, 220, 220)));
        add(profilePanel);

        JLabel profileImageLabel = new JLabel("프로필 사진");
        profileImageLabel.setBounds(0, 2, 90, 38);
        profilePanel.add(profileImageLabel);

        JLabel nicknameLabel = new JLabel("민지");
        nicknameLabel.setFont(new Font("Dialog", Font.BOLD, 16));
        nicknameLabel.setBounds(95, 2, 150, 38);
        profilePanel.add(nicknameLabel);

        JButton followButton = new JButton("팔로우");
        followButton.setBounds(0, 55, 85, 34);
        profilePanel.add(followButton);

        JLabel publicRecordsCountLabel = new JLabel("공개 기록 목록(1)");
        publicRecordsCountLabel.setFont(new Font("Dialog", Font.BOLD, 17));
        publicRecordsCountLabel.setBounds(32, 151, 250, 28);
        add(publicRecordsCountLabel);

        JScrollPane publicRecordsScrollPane = new JScrollPane();
        publicRecordsScrollPane.setBounds(32, 190, 634, 245);
        add(publicRecordsScrollPane);

        JPanel publicRecordsListPanel = new JPanel();
        publicRecordsListPanel.setLayout(
                new BoxLayout(publicRecordsListPanel, BoxLayout.Y_AXIS));
        publicRecordsListPanel.setBackground(Color.WHITE);
        publicRecordsScrollPane.setViewportView(publicRecordsListPanel);

        JPanel recordItemPanel = new JPanel();
        recordItemPanel.setLayout(null);
        recordItemPanel.setBackground(Color.WHITE);
        recordItemPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        recordItemPanel.setPreferredSize(new Dimension(600, 100));
        recordItemPanel.setMaximumSize(
                new Dimension(Integer.MAX_VALUE, 100));
        recordItemPanel.setBorder(
                new LineBorder(new Color(220, 220, 220)));
        publicRecordsListPanel.add(recordItemPanel);

        JLabel recordTitleLabel = new JLabel("자바 Swing 정리");
        recordTitleLabel.setFont(new Font("Dialog", Font.BOLD, 16));
        recordTitleLabel.setBounds(16, 10, 580, 25);
        recordItemPanel.add(recordTitleLabel);

        JLabel recordDateLabel = new JLabel("2026.11.28");
        recordDateLabel.setBounds(16, 40, 150, 20);
        recordItemPanel.add(recordDateLabel);

        JLabel recordPreviewLabel =
                new JLabel("FlowLayout, BorderLayout...(내용 미리보기)");
        recordPreviewLabel.setBounds(16, 68, 580, 20);
        recordItemPanel.add(recordPreviewLabel);

        JButton backToMainButton = new JButton("메인으로");
        backToMainButton.setBounds(32, 450, 95, 34);
        add(backToMainButton);
    }
}