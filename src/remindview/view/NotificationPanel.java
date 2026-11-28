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

public class NotificationPanel extends JPanel {

    private static final long serialVersionUID = 1L;

    public NotificationPanel() {
        setLayout(null);
        setBackground(Color.WHITE);

        JLabel titleLabel = new JLabel("알림");
        titleLabel.setFont(new Font("Dialog", Font.BOLD, 23));
        titleLabel.setBounds(32, 27, 200, 38);
        add(titleLabel);

        JScrollPane notificationScrollPane = new JScrollPane();
        notificationScrollPane.setBounds(32, 80, 634, 320);
        add(notificationScrollPane);

        JPanel notificationListPanel = new JPanel();
        notificationListPanel.setLayout(
                new BoxLayout(notificationListPanel, BoxLayout.Y_AXIS));
        notificationListPanel.setBackground(Color.WHITE);
        notificationScrollPane.setViewportView(notificationListPanel);

        JPanel notificationItemPanel = new JPanel();
        notificationItemPanel.setLayout(null);
        notificationItemPanel.setBackground(Color.WHITE);
        notificationItemPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        notificationItemPanel.setPreferredSize(new Dimension(600, 95));
        notificationItemPanel.setMaximumSize(
                new Dimension(Integer.MAX_VALUE, 95));
        notificationItemPanel.setBorder(
                new LineBorder(new Color(220, 220, 220)));
        notificationListPanel.add(notificationItemPanel);

        JLabel unreadDotLabel = new JLabel("●");
        unreadDotLabel.setBounds(16, 12, 20, 22);
        notificationItemPanel.add(unreadDotLabel);

        JLabel notificationTypeLabel = new JLabel("댓글 알림");
        notificationTypeLabel.setFont(
                new Font("Dialog", Font.BOLD, 15));
        notificationTypeLabel.setBounds(37, 12, 250, 22);
        notificationItemPanel.add(notificationTypeLabel);

        JLabel notificationMessageLabel =
                new JLabel("민지님이 내 기록에 댓글을 남겼습니다.");
        notificationMessageLabel.setBounds(16, 40, 590, 20);
        notificationItemPanel.add(notificationMessageLabel);

        JLabel notificationDateLabel =
                new JLabel("2026.11.28.13:18");
        notificationDateLabel.setFont(
                new Font("Dialog", Font.PLAIN, 12));
        notificationDateLabel.setBounds(16, 66, 200, 18);
        notificationItemPanel.add(notificationDateLabel);

        JButton backToMainButton = new JButton("메인으로");
        backToMainButton.setBounds(32, 415, 95, 34);
        add(backToMainButton);
    }
}