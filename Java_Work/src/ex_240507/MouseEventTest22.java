package ex_240507;

import java.awt.Container;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import javax.swing.JFrame;
import javax.swing.JLabel;

import util.MyMouseListener22;
import util.RandomSelectNumber;
import util.MyMouseListener;
import util.MyMouseListener2;

public class MouseEventTest22 extends JFrame {

	public MouseEventTest22(JLabel jLabel) {
		setTitle("MouseListener와 MouseMotionListener 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		
		MyMouseListener22 listener = new MyMouseListener22(jLabel);
		c.addMouseListener(listener);
		c.addMouseMotionListener((MouseMotionListener) listener);
		c.setLayout(null);
		jLabel.setSize(150, 20);
		jLabel.setLocation(100, 80);
		c.add(jLabel); // 레이블 컴포넌트 삽입
		setSize(300, 200);
		setVisible(true);
	}

	public static void main(String[] args) {
		JLabel la = new JLabel(" Move Me");
		MouseEventTest22 mouseEventTest2 = new MouseEventTest22(la);

	}

}