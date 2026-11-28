package remindview.view;

import java.awt.CardLayout;
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

public class MyPagePanel extends JPanel {

    private static final long serialVersionUID = 1L;

    public MyPagePanel() {
        setLayout(null);
        setBackground(Color.WHITE);

        // 프로필
        JPanel profilePanel = new JPanel();
        profilePanel.setLayout(null);
        profilePanel.setBackground(Color.WHITE);
        profilePanel.setBounds(32, 27, 634, 52);
        add(profilePanel);

        JLabel profileImagePanel = new JLabel("프로필 사진");
        profileImagePanel.setBounds(0, 7, 90, 32);
        profilePanel.add(profileImagePanel);

        JLabel nicknameLabel = new JLabel("서연");
        nicknameLabel.setFont(new Font("Dialog", Font.BOLD, 16));
        nicknameLabel.setBounds(94, 7, 160, 32);
        profilePanel.add(nicknameLabel);

        // 탭 버튼
        JPanel tabPanel = new JPanel();
        tabPanel.setLayout(null);
        tabPanel.setBackground(Color.WHITE);
        tabPanel.setBounds(32, 87, 634, 40);
        add(tabPanel);

        JButton myRecordsButton = new JButton("내 기록");
        myRecordsButton.setBounds(0, 0, 85, 34);
        tabPanel.add(myRecordsButton);

        JButton scrapsButton = new JButton("스크랩");
        scrapsButton.setBounds(94, 0, 85, 34);
        tabPanel.add(scrapsButton);

        JButton followingButton = new JButton("팔로우");
        followingButton.setBounds(188, 0, 85, 34);
        tabPanel.add(followingButton);

        // 탭에 따라 아래 내용만 교체
        CardLayout cards = new CardLayout();
        JPanel listContentPanel = new JPanel(cards);
        listContentPanel.setBounds(32, 137, 634, 268);
        add(listContentPanel);

        //내 기록 탭
        JPanel myRecordsPanel = new JPanel();
        myRecordsPanel.setLayout(null);
        myRecordsPanel.setBackground(Color.WHITE);
        listContentPanel.add(myRecordsPanel, "MY_RECORDS");

        JLabel myRecordsCountLabel = new JLabel("내 기록(1)");
        myRecordsCountLabel.setFont(new Font("Dialog", Font.BOLD, 17));
        myRecordsCountLabel.setBounds(0, 0, 230, 28);
        myRecordsPanel.add(myRecordsCountLabel);

        JScrollPane myRecordsScrollPane = new JScrollPane();
        myRecordsScrollPane.setBounds(0, 37, 634, 230);
        myRecordsPanel.add(myRecordsScrollPane);

        JPanel myRecordsListPanel = new JPanel();
        myRecordsListPanel.setLayout(
                new BoxLayout(myRecordsListPanel, BoxLayout.Y_AXIS));
        myRecordsListPanel.setBackground(Color.WHITE);
        myRecordsScrollPane.setViewportView(myRecordsListPanel);

        JPanel recordItemPanel = new JPanel();
        setItemStyle(recordItemPanel, 75);
        myRecordsListPanel.add(recordItemPanel);

        JLabel recordTitleLabel = new JLabel("훠궈 소스 만드는 법");
        recordTitleLabel.setFont(new Font("Dialog", Font.BOLD, 16));
        recordTitleLabel.setBounds(16, 10, 500, 25);
        recordItemPanel.add(recordTitleLabel);

        JLabel recordVisibilityLabel = new JLabel("공개");
        recordVisibilityLabel.setBounds(16, 42, 50, 20);
        recordItemPanel.add(recordVisibilityLabel);

        JLabel recordDateLabel = new JLabel("2026.11.28");
        recordDateLabel.setBounds(74, 42, 150, 20);
        recordItemPanel.add(recordDateLabel);

        //스크랩 탭
        JPanel scrapsPanel = new JPanel();
        scrapsPanel.setLayout(null);
        scrapsPanel.setBackground(Color.WHITE);
        listContentPanel.add(scrapsPanel, "SCRAPS");

        JLabel scrapsCountLabel = new JLabel("스크랩한 기록(1)");
        scrapsCountLabel.setFont(new Font("Dialog", Font.BOLD, 17));
        scrapsCountLabel.setBounds(0, 0, 250, 28);
        scrapsPanel.add(scrapsCountLabel);

        JScrollPane scrpasScrollPane = new JScrollPane();
        scrpasScrollPane.setBounds(0, 37, 634, 230);
        scrapsPanel.add(scrpasScrollPane);

        JPanel scrapsListPanel = new JPanel();
        scrapsListPanel.setLayout(
                new BoxLayout(scrapsListPanel, BoxLayout.Y_AXIS));
        scrapsListPanel.setBackground(Color.WHITE);
        scrpasScrollPane.setViewportView(scrapsListPanel);

        JPanel ScrapItemPanel = new JPanel();
        setItemStyle(ScrapItemPanel, 105);
        scrapsListPanel.add(ScrapItemPanel);

        JLabel scrapTitleLabel = new JLabel("훠궈 소스 만드는 법");
        scrapTitleLabel.setFont(new Font("Dialog", Font.BOLD, 16));
        scrapTitleLabel.setBounds(16, 10, 500, 25);
        ScrapItemPanel.add(scrapTitleLabel);

        JLabel scrapAuthorLabel = new JLabel("서연");
        scrapAuthorLabel.setBounds(16, 40, 55, 20);
        ScrapItemPanel.add(scrapAuthorLabel);

        JLabel scrapDateLabel = new JLabel("2026.11.28");
        scrapDateLabel.setBounds(74, 40, 150, 20);
        ScrapItemPanel.add(scrapDateLabel);

        JButton unscrapButton = new JButton("스크랩 취소");
        unscrapButton.setBounds(16, 68, 110, 29);
        ScrapItemPanel.add(unscrapButton);

        //팔로우 탭
        JPanel followingPanel = new JPanel();
        followingPanel.setLayout(null);
        followingPanel.setBackground(Color.WHITE);
        listContentPanel.add(followingPanel, "FOLLOWING");

        JLabel lblNewLabel = new JLabel("팔로우 중인 사용자(1)");
        lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 17));
        lblNewLabel.setBounds(0, 0, 280, 28);
        followingPanel.add(lblNewLabel);

        JScrollPane followingScrollPane = new JScrollPane();
        followingScrollPane.setBounds(0, 37, 634, 230);
        followingPanel.add(followingScrollPane);

        JPanel followingListPanel = new JPanel();
        followingListPanel.setLayout(
                new BoxLayout(followingListPanel, BoxLayout.Y_AXIS));
        followingListPanel.setBackground(Color.WHITE);
        followingScrollPane.setViewportView(followingListPanel);

        JPanel followingItemPanel = new JPanel();
        setItemStyle(followingItemPanel, 100);
        followingListPanel.add(followingItemPanel);

        JLabel userImageLabel = new JLabel("프로필 사진");
        userImageLabel.setBounds(16, 12, 90, 30);
        followingItemPanel.add(userImageLabel);

        JLabel userNicknameLabel = new JLabel("서현");
        userNicknameLabel.setFont(new Font("Dialog", Font.BOLD, 15));
        userNicknameLabel.setBounds(110, 12, 150, 30);
        followingItemPanel.add(userNicknameLabel);

        JButton unfollowButton = new JButton("팔로우취소");
        unfollowButton.setBounds(16, 56, 115, 30);
        followingItemPanel.add(unfollowButton);

        JButton backToMainButton = new JButton("메인으로");
        backToMainButton.setBounds(32, 420, 95, 34);
        add(backToMainButton);

        //기존 세 버튼으로 카드 전환
        myRecordsButton.addActionListener(
                e -> cards.show(listContentPanel, "MY_RECORDS"));
        scrapsButton.addActionListener(
                e -> cards.show(listContentPanel, "SCRAPS"));
        followingButton.addActionListener(
                e -> cards.show(listContentPanel, "FOLLOWING"));
    }

    private void setItemStyle(JPanel item, int height) {
        item.setLayout(null);
        item.setBackground(Color.WHITE);
        item.setAlignmentX(Component.LEFT_ALIGNMENT);
        item.setPreferredSize(new Dimension(600, height));
        item.setMaximumSize(new Dimension(Integer.MAX_VALUE, height));
        item.setBorder(new LineBorder(new Color(220, 220, 220)));
    }
} 