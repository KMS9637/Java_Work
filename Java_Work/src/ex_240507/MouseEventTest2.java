package ex_240507;

import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JLabel;
import util.MyMouseListener;
import util.MyMouseListener2;
//import util.MyMouseListener2;

public class MouseEventTest2 extends JFrame{
	
	public MouseEventTest2(JLabel jLabel, JLabel jLabel2) {
		
	setTitle("Mouse 이벤트 예제");
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	Container c = getContentPane();
	c.addMouseListener(new MyMouseListener(jLabel));
	c.addMouseListener(new MyMouseListener2(jLabel2));
	
	c.setLayout(null);
	jLabel.setSize(50, 20); // 레이블의 크기 50x20 설정
	jLabel.setLocation(30, 30); // 레이블의 위치 (30,30)으로 설정
	c.add(jLabel); 
	
	jLabel2.setSize(50, 20); // 레이블의 크기 50x20 설정
	jLabel2.setLocation(70, 70); // 레이블의 위치 (30,30)으로 설정
	c.add(jLabel2); 
	
	setSize(200, 200);
	setVisible(true);
}
	
	public static void main(String[] args) {
		
		JLabel la = new JLabel("Hello"); // "Hello" 레이블
		JLabel la2 = new JLabel("Menu"); // "Hello" 레이블
		MouseEventTest2 MouseEventTest1 = new MouseEventTest2(la,la2);
		
	}

}
