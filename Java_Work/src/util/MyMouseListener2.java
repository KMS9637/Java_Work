package util;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;

public class MyMouseListener2 implements MouseListener {
	private JLabel jLabel;
	
	public MyMouseListener2(JLabel jLabel) {
		this.jLabel = jLabel;
	}
	
	public void mousePressed(MouseEvent event) {
		int x = event.getX(); // 마우스의 클릭 좌표 x
		int y = event.getY(); // 마우스의 클릭 좌표 y
		jLabel.setLocation(x-50, y-50); // (x,y) 위치로 레이블 이동
		}
		public void mouseReleased(MouseEvent e) {}
		public void mouseClicked(MouseEvent e) {}
		public void mouseEntered(MouseEvent e) {}
		public void mouseExited(MouseEvent e) {}
		}

