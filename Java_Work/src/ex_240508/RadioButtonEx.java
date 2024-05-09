package ex_240508;

import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

public class RadioButtonEx extends JFrame {
	private JLabel selectedFruitLabel;
	
	public RadioButtonEx() {
		
		setTitle("라디오버튼 만들기 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		selectedFruitLabel =new JLabel("선택된 과일은 : "); 
		
		// 라디오 버튼 그룹에 추가, 패널에 붙이는 작업
		ButtonGroup g = new ButtonGroup(); // 버튼 그룹 객체 생성
		JRadioButton apple = new JRadioButton("사과");
		JRadioButton pear = new JRadioButton("배", true);
		JRadioButton cherry = new JRadioButton("체리");
		
		// 버튼 그룹에 3개의 라디오버튼 삽입
		g.add(apple);
		g.add(pear);
		g.add(cherry);
		
		// 컨텐트팬에 3개의 라디오버튼 삽입
		c.add(apple); 
		c.add(pear); 
		c.add(cherry);
		c.add(selectedFruitLabel);
		
		
		setSize(250,150);
		setVisible(true);
		
	}
	public static void main(String [] args) {
		new RadioButtonEx();
	}
}
