package ex_240509;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginForm extends JFrame {
    JTextField emailField;
    JPasswordField passwordField;
    JButton loginButton;
    JButton signupButton;
    JButton circularButton;

    public LoginForm() {
        setTitle("로그인");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container container = getContentPane();
        container.setLayout(new BorderLayout());

        // 상단 패널
        JPanel topPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbcTop = new GridBagConstraints();
        gbcTop.fill = GridBagConstraints.HORIZONTAL;
        gbcTop.weightx = 1.0;

        JLabel emailLabel = new JLabel("이메일:");
        emailField = new JTextField(20);
        gbAdd(topPanel, emailLabel, gbcTop, 0, 0, 1, 1);
        gbAdd(topPanel, emailField, gbcTop, 1, 0, 3, 1);

        JLabel passwordLabel = new JLabel("비밀번호:");
        passwordField = new JPasswordField(20);
        gbAdd(topPanel, passwordLabel, gbcTop, 0, 1, 1, 1);
        gbAdd(topPanel, passwordField, gbcTop, 1, 1, 3, 1);

        loginButton = new JButton("로그인");
        gbAdd(topPanel, loginButton, gbcTop, 0, 2, 4, 1);

        signupButton = new JButton("회원가입");
        gbAdd(topPanel, signupButton, gbcTop, 0, 3, 4, 1);

        // 하단 패널
        JPanel bottomPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbcBottom = new GridBagConstraints();
        gbcBottom.fill = GridBagConstraints.HORIZONTAL;
        gbcBottom.weightx = 1.0;

        ImageIcon icon = new ImageIcon("testImage.jpg");
        circularButton = new JButton(icon);
        circularButton.setPreferredSize(new Dimension(100, 100));
        circularButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        circularButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "동그란 버튼 클릭됨");
            }
        });
        gbAdd(bottomPanel, circularButton, gbcBottom, 0, 0, 1, 1);

        // 전체 컨테이너에 패널 추가
        container.add(topPanel, BorderLayout.NORTH);
        container.add(bottomPanel, BorderLayout.CENTER);

        setSize(400, 500);
        setVisible(true);
    }

    private void gbAdd(JPanel panel, JComponent c, GridBagConstraints gbc, int x, int y, int w, int h) {
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.gridwidth = w;
        gbc.gridheight = h;
        gbc.insets = new Insets(5, 5, 5, 5);
        panel.add(c, gbc);
    }

    public static void main(String[] args) {
        new LoginForm();
    }
}
