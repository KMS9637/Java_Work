package ex_240508;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class TextAreaEx_lv3 extends JFrame {
	private JTextField tf_id = new JTextField(20);
	private JTextField tf_email = new JTextField(20);
	private JTextField tf_password = new JTextField(20);
	private JTextField tf_repassword = new JTextField(20);
	private JTextArea ta = new JTextArea(7, 20);
	private JLabel jLabel; 

	public TextAreaEx_lv3() {
		setTitle("회원가입");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());

		c.add(new JLabel("이름 "));
		c.add(new JLabel("입력 후 <Enter> 키를 입력하세요"));
		c.add(tf_id);
		c.add(new JLabel("이메일 "));
		c.add(new JLabel("입력 후 <Enter> 키를 입력하세요"));
		c.add(tf_email); 
		c.add(new JLabel("패스워드 "));
		c.add(new JLabel("입력 후 <Enter> 키를 입력하세요"));
		c.add(tf_password);
		c.add(new JLabel("패스워드 확인 "));
		c.add(new JLabel("입력 후 <Enter> 키를 입력하세요"));
		c.add(tf_repassword);
		
		c.add(new JScrollPane(ta));
		tf_id.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JTextField t = (JTextField)e.getSource();
				ta.append(t.getText() + "\n"); 
				t.setText(""); 
			}
		});
		tf_email.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JTextField t = (JTextField)e.getSource();
				ta.append(t.getText() + "\n"); 
				t.setText(""); 
			}
		});
		tf_password.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JTextField t = (JTextField)e.getSource();
				ta.append(t.getText() + "\n"); 
				t.setText(""); 
			}
		});
		tf_repassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JTextField t = (JTextField)e.getSource();
				ta.append(t.getText() + "\n"); 
				t.setText(""); 
			}
		});

		JButton btn = new JButton("회원가입");
		c.add(btn);

		jLabel = new JLabel();
		

		btn.addActionListener(new ActionListener() {	

			@Override
			public void actionPerformed(ActionEvent e) {
				String id=tf_id.getText();
				String email=tf_email.getText();
				String password=tf_password.getText();
				String repassword=tf_repassword.getText();

				jLabel.setText("이름: "+id+"이메일: "+email+"패스워드: "+password+"패스워드 확인: "+repassword);
			}
		});

		JButton btn3 = new JButton("초기화");
		c.add(btn3);
		
		btn3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				tf_id.setText("");
				tf_email.setText("");
				tf_password.setText("");
				tf_repassword.setText("");
				ta.setText("");
				jLabel.setText("");
			}
		});
		
		c.add(jLabel);
		
		setSize(300, 400);
		setVisible(true);
	}

	public static void main(String[] args) {
		new TextAreaEx_lv3();
	}
}