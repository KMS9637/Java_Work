package ex_240509;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

public class kms_java_project_signUp extends JFrame {
	JTextField nameField;
	JTextField emailField;
	JTextField passwordField;
	JTextField repasswordField;

	JButton submitBtn;

	GridBagLayout gb;

	GridBagConstraints gbc;
		
    private JRadioButton[] Music = new JRadioButton[3];
    private String[] names = { "발라드", "힙합", "J-Pop" };
    private JLabel selectedMusicLabel;
	
	public kms_java_project_signUp() {
		setTitle("Sign Up");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		Container c = getContentPane();

		gb = new GridBagLayout();

		setLayout(gb);

		gbc = new GridBagConstraints();

		gbc.fill = GridBagConstraints.BOTH;
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;

		
		JLabel namelabel = new JLabel("닉네임");
		namelabel.setHorizontalAlignment(SwingConstants.CENTER);
		Border border = BorderFactory.createLineBorder(Color.BLACK, 2);
		namelabel.setBorder(border);
		nameField = new JTextField(20);

		gbAdd(namelabel, 0, 0, 1, 1);
		gbAdd(nameField, 1, 0, 3, 1);


		JLabel emaillabel = new JLabel("이메일");
		emaillabel.setHorizontalAlignment(SwingConstants.CENTER);
		Border border2 = BorderFactory.createLineBorder(Color.BLACK, 2);
		emaillabel.setBorder(border);
		emailField = new JTextField(20);

		gbAdd(emaillabel, 0, 1, 1, 1);
		gbAdd(emailField, 1, 1, 3, 1);
		
		JLabel passwordlabel = new JLabel("비밀번호");
		passwordlabel.setHorizontalAlignment(SwingConstants.CENTER);
		Border border3 = BorderFactory.createLineBorder(Color.BLACK, 2);
		passwordlabel.setBorder(border2);
		passwordField = new JTextField(20);

		gbAdd(passwordlabel, 0, 2, 1, 1);
		gbAdd(passwordField, 1, 2, 3, 1);

		JLabel repasswordlabel = new JLabel("비밀번호 확인");
		repasswordlabel.setHorizontalAlignment(SwingConstants.CENTER);
		Border border4 = BorderFactory.createLineBorder(Color.BLACK, 2);
		repasswordlabel.setBorder(border2);
		repasswordField = new JTextField(20);

		gbAdd(repasswordlabel, 0, 3, 1, 1);
		gbAdd(repasswordField, 1, 3, 3, 1);

		JLabel musicPreferenceLabel = new JLabel("당신의 음악 취향은?");
		gbAdd(musicPreferenceLabel, 0, 5, 1, 1);
        musicPreferenceLabel.setHorizontalAlignment(SwingConstants.CENTER);
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(10, 0, 10, 0);
        gbc.gridwidth = 4;
        gb.setConstraints(musicPreferenceLabel, gbc);
        add(musicPreferenceLabel, gbc);

        ButtonGroup g = new ButtonGroup();
        for (int i = 0; i < Music.length; i++) {
            Music[i] = new JRadioButton(names[i]);
            g.add(Music[i]);
            gbAdd(Music[i], i, 6, 1, 1);
        }
        
		submitBtn = new JButton("회원가입");
		submitBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String email = emailField.getText();
                String password = passwordField.getText();
                String repassword = repasswordField.getText();

                if (name.isEmpty() || email.isEmpty() || password.isEmpty() || repassword.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "모든 정보를 입력해주세요!");
                } else if (!password.equals(repassword)) {
                    JOptionPane.showMessageDialog(null, "비밀번호와 비밀번호 확인이 일치하지 않습니다. 다시 확인해주세요!");
                } else {
                    JOptionPane.showMessageDialog(null, "회원가입 성공!");
                    dispose(); // 현재 창 닫기
                }
            }
        });
		gbAdd(submitBtn, 0, 4, 4, 1);


		// 회원가입 창 내용 구성...
		// (원하는 내용을 여기에 추가)
		setSize(400, 500);
		setVisible(true);
	}
	
	private void gbAdd(JComponent c, int x, int y, int w, int h) {
		gbc.gridx = x;
		gbc.gridy = y;
		gbc.gridwidth = w;
		gbc.gridheight = h;
		gb.setConstraints(c, gbc);
		gbc.insets = new Insets(2, 2, 2, 2);
		add(c, gbc);
	}// gbAdd

}