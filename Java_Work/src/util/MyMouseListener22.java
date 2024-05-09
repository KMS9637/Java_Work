package util;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JLabel;

public class MyMouseListener22 implements MouseListener, MouseMotionListener {
	public JLabel jLabel;
	

	public MyMouseListener22(JLabel jLabel) {
		this.jLabel = jLabel;
	
	}

	public void mousePressed(MouseEvent e) {
		jLabel.setLocation(e.getX(), e.getY());
//		setTitle("mousePressed(" + e.getX() + "," + e.getY() + ")");
		jLabel.setText("mousePressed(" + e.getX() + "," + e.getY() + ")");
	}

	public void mouseReleased(MouseEvent e) {
		jLabel.setLocation(e.getX(), e.getY());
//		setTitle("mouseReleased(" + e.getX() + "," + e.getY() + ")");
		jLabel.setText("mouseReleased(" + e.getX() + "," + e.getY() + ")");
	}

	public void mouseClicked(MouseEvent e) {
	}

	public void mouseEntered(MouseEvent e) {
		Component comp = (Component) e.getSource();
		comp.setBackground(Color.CYAN);
	}

	public void mouseExited(MouseEvent e) {
		Component comp = (Component) e.getSource();
		comp.setBackground(Color.YELLOW);
//		setTitle("mouseExited(" + e.getX() + "," + e.getY() + ")");
		jLabel.setText("mouseExited(" + e.getX() + "," + e.getY() + ")");

	}

	public void mouseDragged(MouseEvent e) {
		jLabel.setLocation(e.getX(), e.getY());
//		setTitle("mouseDragged(" + e.getX() + "," + e.getY() + ")");
		jLabel.setText("mouseDragged(" + e.getX() + "," + e.getY() + ")");
	}

	public void mouseMoved(MouseEvent e) {
		jLabel.setLocation(e.getX(), e.getY());
//		setTitle("mouseMoved (" + e.getX() + "," + e.getY() + ")");
		jLabel.setText("mouseMoved(" + e.getX() + "," + e.getY() + ")");

	}
}