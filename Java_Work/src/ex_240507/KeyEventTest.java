package ex_240507;

import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;

import util.MyKeyListener;

public class KeyEventTest extends JFrame{

	public KeyEventTest(JLabel jLabel) {
		
			super("KeyListener의 문자 키 입력 예제");
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			Container c = getContentPane(); 
			c.setLayout(new FlowLayout());
			c.add(jLabel);
			
			
			c.addKeyListener(new MyKeyListener(c,jLabel));
			
			
			setSize(250, 150);
			setVisible(true);
			
			c.setFocusable(true); // 컨텐트팬이 포커스를 받을 수 있도록 설정
			c.requestFocus(); // 컨텐트팬에 포커스 설정
	}

	public static void main(String[] args) {
		JLabel la = new JLabel("<Enter>키로 배경색이 바뀝니다");
		KeyEventTest keyEventTest = new KeyEventTest(la);

	}

}