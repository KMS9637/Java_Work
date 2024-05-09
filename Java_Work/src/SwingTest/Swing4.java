package SwingTest;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


// 작업순서1, JFrame 그림도구 상속받기. 
public class Swing4 extends JFrame{
	public Swing4() {
		// 제목
		setTitle("300x300 스윙 프레임 만들기");
		// 창의 엑스 표시를 클릭시 종료하는 코드
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// 창 사이즈
		setSize(1000, 800);
	
		// 프레임의 컨텐트팬을 알아낸다.
		Container contentPane = getContentPane(); 
		
		//정의만 하고서, 설정을 안했음. 
		//MyPanel myPanel = new MyPanel();
		
		// 패널 더 추가 해보기. 
//		Container contentPane = getContentPane(); // 컨텐트팬 알아내기
		contentPane.setBackground(Color.ORANGE); // 오렌지색 배경 설정
		// html flex 랑 동일해요, 기본 가로로 순차 배치, 
		// 마진 처럼, 왼쪽,오른쪽 정렬 : 수평, : 수직 간격 주고
		// new FlowLayout(정렬방법,수평 간격,수직 간력)
		contentPane.setLayout(null); // 컨텐트팬에 FlowLayout
		// 배치관리자 달기
		// new BorderLayout() -> , 위치 , 동, 서,남,북,센터 : 상수 값. 
		// contentPane.add(요소,위치)
		
		JLabel la = new JLabel("Hello, Press Buttons!");
		la.setLocation(130, 50); // la를 (130,50) 위치로 지정
		la.setSize(200, 20); // la를 200x20 크기로 지정
		contentPane.add(la); // la를 컨텐트팬에 부착
		// 9개의 버튼 컴포넌트를 생성하고 동일한 크기로 설정한다.
		// 위치는 서로 겹치게 설정한다.
		for(int i=1; i<=9; i++) {
		JButton b = new JButton(Integer.toString(i)); // 버튼 생성
		b.setLocation(i*15, i*15); // 버튼의 위치 설정
		b.setSize(200, 50); // 버튼의 크기는 동일하게 50x20
		contentPane.add(b); // 버튼을 컨텐트팬에 부착
		}
		
		// 임의로 버튼 오른쪽에 하나 더 추가해보기
		JButton tempbtn =new JButton("TempBtn");
		tempbtn.setLocation(500, 400);
		tempbtn.setSize(300, 200);
		contentPane.add(tempbtn);
		
		
		// 창 보여줄지 여부. 
		setVisible(true); 
		
		
		

		}

	public static void main(String[] args) {
		// 인스턴스를 생성하는 과정 중에, 기본 생성자를 호출해서, 실행함. 
		Swing4 swing1 = new Swing4() ;

	}

}



