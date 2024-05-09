package ex_240508;

import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class ButtonImageEx {

	public class ButtonImageEx2 extends JFrame {
		public ButtonImageEx2() {
		setTitle("이미지 버튼 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		ImageIcon normalIcon = new ImageIcon("images/normalIcon.gif");
		ImageIcon rolloverIcon = new ImageIcon("images/rolloverIcon.gif");
		ImageIcon pressedIcon = new ImageIcon("images/pressedIcon.gif");
		JButton btn = new JButton("call~~", normalIcon);
		btn.setPressedIcon(pressedIcon); // pressedIcon용 이미지 등록
		btn.setRolloverIcon(rolloverIcon); // rolloverIcon용 이미지 등록
		c.add(btn);
		setSize(250,150);
		setVisible(true);
		}
		public static void main(String [] args) {
		new ButtonImageEx();
		}

}
}