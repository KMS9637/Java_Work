package ex_240508;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class TextAreaEx_lv4 extends JFrame {
    private ArrayList<JTextField> textFields = new ArrayList<>();
    private JTextArea ta = new JTextArea(7, 20);
    private JLabel jLabel;

    public TextAreaEx_lv4() {
        setTitle("회원가입");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 입력 패널 설정
        JPanel inputPanel = new JPanel(new GridLayout(4, 2));
        String[] labels = {"이름", "이메일", "패스워드", "패스워드 확인"};
        for (String label : labels) {
            JTextField textField = new JTextField(20);
            textField.addActionListener(e -> register());
            textFields.add(textField);
            inputPanel.add(createInputLabel(label));
            inputPanel.add(textField);
        }

        // 버튼 패널 설정
        JPanel buttonPanel = new JPanel();
        JButton registerButton = new JButton("회원가입");
        JButton clearButton = new JButton("초기화");
        buttonPanel.add(registerButton);
        buttonPanel.add(clearButton);

        // 결과 출력 라벨 설정
        jLabel = new JLabel();

        // 이벤트 처리
        registerButton.addActionListener(e -> register());
        clearButton.addActionListener(e -> clear());

        // 패널에 라벨과 버튼 추가
        JPanel labelButtonPanel = new JPanel(new BorderLayout());
        labelButtonPanel.add(jLabel, BorderLayout.NORTH);
        labelButtonPanel.add(buttonPanel, BorderLayout.SOUTH);

        // 프레임에 컴포넌트 추가
        Container c = getContentPane();
        c.setLayout(new BorderLayout());
        c.add(inputPanel, BorderLayout.NORTH);
        c.add(new JScrollPane(ta), BorderLayout.CENTER);
        c.add(labelButtonPanel, BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    // 입력 라벨 생성 메서드
    private JLabel createInputLabel(String text) {
        return new JLabel(text + " 입력 후 <Enter> 키를 입력하세요");
    }

    // 회원가입 처리 메서드
    private void register() {
        StringBuilder result = new StringBuilder();
        for (JTextField textField : textFields) {
            result.append(textField.getText()).append(", ");
        }
        result.delete(result.length() - 2, result.length()); // 마지막 ", " 삭제
        jLabel.setText("이름: " + result.toString()); // 라벨에 출력
    }

    // 초기화 처리 메서드
    private void clear() {
        for (JTextField textField : textFields) {
            textField.setText("");
        }
        ta.setText("");
        jLabel.setText("");
    }

    public static void main(String[] args) {
        new TextAreaEx_lv4();
    }
}
