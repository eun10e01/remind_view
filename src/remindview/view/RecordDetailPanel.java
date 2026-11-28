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
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.MatteBorder;

public class RecordDetailPanel extends JPanel {

    private static final long serialVersionUID = 1L;

    public RecordDetailPanel() {
        setLayout(null);
        setBackground(Color.WHITE);

        // 상세 화면 전체를 스크롤
        JScrollPane detailScrollPane = new JScrollPane();
        detailScrollPane.setBounds(0, 0, 700, 550);
        detailScrollPane.setBorder(null);
        detailScrollPane.setHorizontalScrollBarPolicy(
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        add(detailScrollPane);

        JPanel detailContentPanel = new JPanel();
        detailContentPanel.setLayout(
                new BoxLayout(detailContentPanel, BoxLayout.Y_AXIS));
        detailContentPanel.setBackground(Color.WHITE);
        detailScrollPane.setViewportView(detailContentPanel);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.WHITE);
        panel.setAlignmentX(Component.LEFT_ALIGNMENT);
        panel.setPreferredSize(new Dimension(670, 540));
        panel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 540));
        detailContentPanel.add(panel);

        JLabel recordTitleLabel = new JLabel("기록 제목");
        recordTitleLabel.setFont(new Font("Dialog", Font.BOLD, 20));
        recordTitleLabel.setBounds(32, 24, 425, 32);
        panel.add(recordTitleLabel);

        JButton editButton = new JButton("수정");
        editButton.setBounds(511, 25, 66, 32);
        panel.add(editButton);

        JButton deleteButton = new JButton("삭제");
        deleteButton.setBounds(587, 25, 66, 32);
        panel.add(deleteButton);

        // 작성자와 YouTube URL
        JPanel panel_1 = new JPanel();
        panel_1.setLayout(null);
        panel_1.setBackground(Color.WHITE);
        panel_1.setBounds(32, 66, 621, 77);
        panel_1.setBorder(new MatteBorder(
                0, 0, 1, 0, new Color(220, 220, 220)));
        panel.add(panel_1);

        JLabel authorAvatarLabel = new JLabel("작성자 사진");
        authorAvatarLabel.setBounds(0, 8, 86, 30);
        panel_1.add(authorAvatarLabel);

        JLabel authorNameLabel = new JLabel("작성자 닉네임");
        authorNameLabel.setFont(new Font("Dialog", Font.BOLD, 14));
        authorNameLabel.setBounds(94, 8, 160, 30);
        panel_1.add(authorNameLabel);

        JLabel youtubeUrlLabel = new JLabel("유튜브 영상 링크");
        youtubeUrlLabel.setBounds(0, 43, 600, 22);
        panel_1.add(youtubeUrlLabel);

        // 기록 내용과 좋아요·스크랩
        JPanel panel_2 = new JPanel();
        panel_2.setLayout(null);
        panel_2.setBackground(Color.WHITE);
        panel_2.setBounds(32, 150, 621, 147);
        panel_2.setBorder(new MatteBorder(
                0, 0, 1, 0, new Color(220, 220, 220)));
        panel.add(panel_2);

        JLabel contentLabel = new JLabel("내용");
        contentLabel.setFont(new Font("Dialog", Font.BOLD, 15));
        contentLabel.setBounds(0, 0, 100, 24);
        panel_2.add(contentLabel);

        JTextArea contentTextArea = new JTextArea();
        contentTextArea.setEditable(false);
        contentTextArea.setLineWrap(true);
        contentTextArea.setWrapStyleWord(true);
        contentTextArea.setFont(new Font("Dialog", Font.PLAIN, 13));
        contentTextArea.setBackground(Color.WHITE);
        contentTextArea.setBounds(0, 32, 610, 56);
        panel_2.add(contentTextArea);

        JButton likeButton = new JButton("좋아요");
        likeButton.setBounds(0, 99, 95, 32);
        panel_2.add(likeButton);

        JButton scrapButton = new JButton("스크랩");
        scrapButton.setBounds(106, 99, 85, 32);
        panel_2.add(scrapButton);

        // 댓글 영역
        JPanel commentSectionPanel = new JPanel();
        commentSectionPanel.setLayout(null);
        commentSectionPanel.setBackground(Color.WHITE);
        commentSectionPanel.setBounds(32, 309, 621, 177);
        panel.add(commentSectionPanel);

        JLabel commentCountLabel = new JLabel("댓글(1)");
        commentCountLabel.setFont(new Font("Dialog", Font.BOLD, 15));
        commentCountLabel.setBounds(0, 0, 160, 25);
        commentSectionPanel.add(commentCountLabel);

        JPanel commentListPanel = new JPanel();
        commentListPanel.setLayout(
                new BoxLayout(commentListPanel, BoxLayout.Y_AXIS));
        commentListPanel.setBackground(Color.WHITE);
        commentListPanel.setBounds(0, 34, 621, 76);
        commentSectionPanel.add(commentListPanel);

        JPanel commentItemPanel = new JPanel();
        commentItemPanel.setLayout(null);
        commentItemPanel.setBackground(Color.WHITE);
        commentItemPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        commentItemPanel.setPreferredSize(new Dimension(621, 76));
        commentItemPanel.setMaximumSize(
                new Dimension(Integer.MAX_VALUE, 76));
        commentListPanel.add(commentItemPanel);

        JLabel commentUserLabel = new JLabel("서연");
        commentUserLabel.setBounds(0, 5, 60, 20);
        commentItemPanel.add(commentUserLabel);

        JTextArea commentDataTextArea = new JTextArea();
        commentDataTextArea.setText("댓글 내용");
        commentDataTextArea.setWrapStyleWord(true);
        commentDataTextArea.setLineWrap(true);
        commentDataTextArea.setEditable(false);
        commentDataTextArea.setBackground(Color.WHITE);
        commentDataTextArea.setBounds(65, 5, 380, 48);
        commentItemPanel.add(commentDataTextArea);

        JLabel commentTimeLabel = new JLabel("2026.11.27 21:03");
        commentTimeLabel.setBounds(452, 5, 160, 20);
        commentItemPanel.add(commentTimeLabel);

        JButton commentEditButton = new JButton("수정");
        commentEditButton.setBounds(475, 35, 65, 30);
        commentItemPanel.add(commentEditButton);

        JButton commentDeleteButton = new JButton("삭제");
        commentDeleteButton.setBounds(549, 35, 65, 30);
        commentItemPanel.add(commentDeleteButton);

        JPanel commentInputPanel = new JPanel();
        commentInputPanel.setLayout(null);
        commentInputPanel.setBackground(Color.WHITE);
        commentInputPanel.setBounds(0, 122, 621, 42);
        commentSectionPanel.add(commentInputPanel);

        JTextArea commentWriteTextArea = new JTextArea();
        commentWriteTextArea.setText("댓글을 입력하세요.");
        commentWriteTextArea.setBounds(0, 5, 535, 32);
        commentWriteTextArea.setBorder(new MatteBorder(
                1, 1, 1, 1, new Color(210, 210, 210)));
        commentInputPanel.add(commentWriteTextArea);

        JButton commentRegisterButton = new JButton("등록");
        commentRegisterButton.setBounds(547, 5, 67, 32);
        commentInputPanel.add(commentRegisterButton);
    }
}