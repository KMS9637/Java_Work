package ex_240509;

import java.awt.*;
import javax.swing.*;

public class kms_java_project_first extends JFrame {

    JTextField emailField;
    JTextField passwordField;
    JButton joinBtn;
    JButton signupBtn;
    JButton circularButton;

    public kms_java_project_first() {
        setTitle("KMS_java_project");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container container = getContentPane();

        // 상단 패널 구성
        JPanel topPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbcTop = new GridBagConstraints();
        gbcTop.fill = GridBagConstraints.BOTH;
        gbcTop.weightx = 1.0;
        gbcTop.weighty = 0.5; // 수정

        JLabel emaillabel = new JLabel("이메일");
        emaillabel.setHorizontalAlignment(SwingConstants.CENTER);
        emaillabel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        emailField = new JTextField(20);
        gbAdd(topPanel, emaillabel, gbcTop, 0, 0, 1, 1);
        gbAdd(topPanel, emailField, gbcTop, 1, 0, 3, 1);

        JLabel passwordlabel = new JLabel("비밀번호");
        passwordlabel.setHorizontalAlignment(SwingConstants.CENTER);
        passwordlabel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        passwordField = new JTextField(20);
        gbAdd(topPanel, passwordlabel, gbcTop, 0, 1, 1, 1);
        gbAdd(topPanel, passwordField, gbcTop, 1, 1, 3, 1);

        joinBtn = new JButton("로그인");
        gbAdd(topPanel, joinBtn, gbcTop, 0, 2, 4, 1);

        signupBtn = new JButton("회원가입");
        gbAdd(topPanel, signupBtn, gbcTop, 0, 3, 4, 1);

        // 하단 패널 구성
        JPanel bottomPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbcBottom = new GridBagConstraints();
        gbcBottom.fill = GridBagConstraints.BOTH;
        gbcBottom.weightx = 1.0;
        gbcBottom.weighty = 0.5; // 수정

        circularButton = new JButton("동그란 버튼");
        circularButton.setBorder(BorderFactory.createEmptyBorder());
        circularButton.setOpaque(false);
        circularButton.setContentAreaFilled(false);
        circularButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        gbAdd(bottomPanel, circularButton, gbcBottom, 0, 0, 1, 1);

        // 전체 컨테이너에 패널 배치
        container.setLayout(new BorderLayout());
        container.add(topPanel, BorderLayout.NORTH);
        container.add(bottomPanel, BorderLayout.SOUTH);

        setSize(400, 500);
        setVisible(true);
    }

    private void gbAdd(JPanel panel, JComponent c, GridBagConstraints gbc, int x, int y, int w, int h) {
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.gridwidth = w;
        gbc.gridheight = h;
        gbc.insets = new Insets(2, 2, 2, 2);
        panel.add(c, gbc);
    }

    public static void main(String[] args) {
        new kms_java_project_first();
    }
}
