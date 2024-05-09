package ex_240508;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Random;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;

public class CheckBoxItemEventEx_lv3 extends JFrame {
	private JCheckBox [] menu = new JCheckBox [5]; 
	private String [] names = {"국밥", "라면", "칼국수", "밀면", "짬뽕"}; 
	private JLabel sumLabel;
	private int sum = 0;
	
	public CheckBoxItemEventEx_lv3() {
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
		
		JButton btn = new JButton("랜덤추천");
		c.add(btn);
		JButton btn2 = new JButton("초기화");
		c.add(btn2);
		
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent event) {
				 Random random = new Random();
	                int randomIndex = random.nextInt(menu.length); // 랜덤 인덱스 생성
	                JCheckBox selectedMenu = menu[randomIndex]; // 랜덤으로 선택된 메뉴

	                int price = getPrice(selectedMenu.getText()); // 선택된 메뉴의 가격
	                sum += price; // 총 가격에 더함
	                sumLabel.setText(selectedMenu.getText() + " 선택됨, 현재 " + sum + "원 입니다.");
			}
		});
		
		btn2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				for (JCheckBox checkBox : menu) {
                    checkBox.setSelected(false);
                }
				sum = 0;
				sumLabel.setText("가격 초기화");
			}
		});
		
		sumLabel = new JLabel("현재 0 원 입니다."); 
		c.add(sumLabel);
		setSize(250,200);
		setVisible(true);
	}
	// Item 리스너 구현
	class MyItemListener implements ItemListener {
//		private int sum = 0; // 가격의 합
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
	
	   private int getPrice(String menuName) {
	        switch (menuName) {
	            case "국밥":
	                return 100;
	            case "라면":
	                return 200;
	            case "칼국수":
	                return 300;
	            case "밀면":
	                return 400;
	            case "짬뽕":
	                return 500;
	            default:
	                return 0;
	        }
	    }
	
	public static void main(String [] args) {
		new CheckBoxItemEventEx_lv3();
	}
}