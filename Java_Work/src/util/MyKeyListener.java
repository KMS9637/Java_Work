package util;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JLabel;
import javax.swing.text.AbstractDocument.Content;

public class MyKeyListener extends KeyAdapter {
	private Container container;
	private JLabel jLabel;
	
	//생성자. 
	public  MyKeyListener(Container container, JLabel jLabel) {
		this.container = container;
		this.jLabel = jLabel;
		
	}
	
	public void keyPressed(KeyEvent event) {
// 임의의 색을 만들기 위해 랜덤하게 r, g, b 성분 생성
		int r = (int) (Math.random() * 256); // red 성분
		int g = (int) (Math.random() * 256); // green 성분
		int b = (int) (Math.random() * 256); // blue 성분
		switch (event.getKeyChar()) { // 입력된 키 문자
		case '\n': // <Enter> 키 입력
			jLabel.setText("r=" + r + ", g=" + g + ", b=" + b);
			container.setBackground(new Color(r, g, b));
			break;
		case 'q':
			System.exit(0);
		}
	}
}