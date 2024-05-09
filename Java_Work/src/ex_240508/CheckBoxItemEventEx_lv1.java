package ex_240508;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class CheckBoxItemEventEx_lv1 extends JFrame {
	private JCheckBox [] menu = new JCheckBox [5]; 
	private String [] names = {"국밥", "라면", "칼국수", "밀면", "짬뽕"}; 
	private JLabel sumLabel;
	
	public CheckBoxItemEventEx_lv1() {
		setTitle("체크박스와 ItemEvent 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		c.add(new JLabel("국밥 100원, 라면 200원, 칼국수 300원, 밀면 400원, 짬뽕 500원"));
		MyItemListener listener = new MyItemListener();
		
		for(int i=0; i<menu.length; i++) {
			menu[i] = new JCheckBox(names[i]); 
			menu[i].setBorderPainted(true);
			c.add(menu[i]);
			menu[i].addItemListener(listener);
		}
		
		sumLabel = new JLabel("현재 0 원 입니다."); 
		c.add(sumLabel);
		setSize(250,200);
		setVisible(true);
	}
	// Item 리스너 구현
	class MyItemListener implements ItemListener {
		private int sum = 0; // 가격의 합
		public void itemStateChanged(ItemEvent e) {
			if(e.getStateChange() == ItemEvent.SELECTED) { 
				if(e.getItem() == menu[0])
					sum += 100;
				else if(e.getItem() == menu[1])
					sum += 200;
				else if(e.getItem() == menu[2])
					sum += 300;
				else if(e.getItem() == menu[3])
					sum += 400;
				else if(e.getItem() == menu[4])
					sum += 500;
			}
			else {
				if(e.getItem() == menu[0])
					sum -= 100;
				else if(e.getItem() == menu[1])
					sum -= 200;
				else if(e.getItem() == menu[2])
					sum -= 300;
				else if(e.getItem() == menu[3])
					sum -= 400;
				else if(e.getItem() == menu[4])
					sum -= 500;
			}
			sumLabel.setText("현재 " + sum + "원 입니다."); 
		}
	}
	public static void main(String [] args) {
		new CheckBoxItemEventEx_lv1();
	}
}