package remindview.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.MatteBorder;

public class MainRecordPanel extends JPanel {

    private static final long serialVersionUID = 1L;

    private JTextField searchField;
    private JPanel recordListPanel;

    public MainRecordPanel() {
        setLayout(null);
        setBackground(Color.WHITE);

        JLabel titleLabel = new JLabel("리마인드 뷰");
        titleLabel.setFont(new Font("Dialog", Font.BOLD, 24));
        titleLabel.setBounds(32, 32, 300, 38);
        add(titleLabel);

        JButton recordButton = new JButton("글 작성");
        recordButton.setBounds(32, 91, 85, 36);
        add(recordButton);

        JButton mypageButton = new JButton("마이페이지");
        mypageButton.setBounds(129, 91, 105, 36);
        add(mypageButton);

        JButton noticeButton = new JButton("알림");
        noticeButton.setBounds(246, 91, 70, 36);
        add(noticeButton);

        searchField = new JTextField();
        searchField.setBounds(32, 145, 550, 34);
        add(searchField);

        JButton searchButton = new JButton("검색");
        searchButton.setBounds(594, 145, 72, 34);
        add(searchButton);

        JLabel partTitleLabel = new JLabel("공개 기록 목록");
        partTitleLabel.setFont(new Font("Dialog", Font.BOLD, 18));
        partTitleLabel.setBounds(32, 192, 250, 28);
        add(partTitleLabel);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(32, 229, 634, 280);
        scrollPane.setHorizontalScrollBarPolicy(
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        add(scrollPane);

        recordListPanel = new JPanel();
        recordListPanel.setLayout(
                new BoxLayout(recordListPanel, BoxLayout.Y_AXIS));
        recordListPanel.setBackground(Color.WHITE);
        scrollPane.setViewportView(recordListPanel);

        // 화면 배치 확인용 예시. 실제 기록을 불러올 때 교체할 부분
        recordListPanel.add(createRecordItem("자바 Swing 레이아웃 정리", "민지", "2026-11-10",
                "FlowLayout, BorderLayout, GridLayout의 차이를 정리한 기록입니다."));

        recordListPanel.add(createRecordItem("객체지향 개념 정리","지훈", "2026-11-9",
                "클래스와 객체, 상속과 다형성의 핵심 개념을 정리했습니다."));
    }

    private JPanel createRecordItem(
            String title, String writer, String date, String preview) {

        JPanel item = new JPanel();
        item.setLayout(null);
        item.setBackground(Color.WHITE);
        item.setAlignmentX(LEFT_ALIGNMENT);

        // BoxLayout 안에서도 글 하나의 높이가 유지되도록 설정
        item.setPreferredSize(new Dimension(610, 96));
        item.setMinimumSize(new Dimension(610, 96));
        item.setMaximumSize(new Dimension(Integer.MAX_VALUE, 96));
        item.setBorder(new MatteBorder(0, 0, 1, 0,
                new Color(220, 220, 220)));

        JLabel titleLabel = new JLabel(title);
        titleLabel.setFont(new Font("Dialog", Font.BOLD, 16));
        titleLabel.setBounds(16, 12, 590, 24);
        item.add(titleLabel);

        JLabel writerLabel = new JLabel("작성자: " + writer);
        writerLabel.setBounds(16, 43, 130, 18);
        item.add(writerLabel);

        JLabel dateLabel = new JLabel("·  " + date);
        dateLabel.setBounds(146, 43, 150, 18);
        item.add(dateLabel);

        JLabel previewLabel = new JLabel(preview);
        previewLabel.setBounds(16, 67, 590, 18);
        item.add(previewLabel);

        return item;
    }
}