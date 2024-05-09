package ex_240508;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class TextAreaEx_lv1 extends JFrame {
	private JTextField tf_id = new JTextField(20);
	private JTextField tf_email = new JTextField(20);
	private JTextField tf_password = new JTextField(20);
	private JTextField tf_repassword = new JTextField(20);
	private JLabel jLabel; 
	
	public TextAreaEx_lv1() {
		setTitle("회원가입");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		c.add(new JLabel("이름 "));
		c.add(tf_id);
		c.add(new JLabel("이메일 "));
		c.add(tf_email); 
		c.add(new JLabel("패스워드 "));
		c.add(tf_password);
		c.add(new JLabel("패스워드 확인 "));
		c.add(tf_repassword);
		
		JButton btn = new JButton("회원가입");
		c.add(btn);
		
		 jLabel = new JLabel();
		 c.add(jLabel);
		
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
		
		setSize(300, 300);
		setVisible(true);
	}

	public static void main(String[] args) {
		new TextAreaEx_lv1();
	}
}