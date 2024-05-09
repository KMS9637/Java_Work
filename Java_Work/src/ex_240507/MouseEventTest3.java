package ex_240507;

import java.awt.Container;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import util.MyMouseListener;

public class MouseEventTest3 extends JFrame {
//pdf19 정답 코드 복붙. 
	// 코드 확인.

	// 생성자, -> JLabel 이라는 참조형 변수를 받는 매개변수 선언. 
	// Hello 라는 문자열 라벨도, 인스턴스 임. 
	public MouseEventTest3(JLabel jaJLabel, JLabel jaJLabel2) {

		setTitle("Mouse 이벤트 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// 패널
		Container c = getContentPane();
		
		// 마우스로 클릭시 이벤트 처리기를 붙이기 작업, 
		// 방법1) 독립된 클래스 버전
		// 각 요소마다, 이벤트 처리기가 각각 다르다. 
//		c.addMouseListener(new MyMouseListener(jaJLabel));
		
		// 방법2) 익명 클래스 버전
		c.addMouseListener(
				new MouseListener() {

					@Override
					public void mouseClicked(MouseEvent event) {
						int x = event.getX(); // 마우스의 클릭 좌표 x
						int y = event.getY(); // 마우스의 클릭 좌표 y
						jaJLabel.setLocation(x, y); // (x,y) 위치로 레이블 이동
						jaJLabel2.setLocation(x-50, y-50); // (x,y) 위치로 레이블 이동
					}

					@Override
					public void mousePressed(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void mouseReleased(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void mouseEntered(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void mouseExited(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}}
				
				);
		
		// 배치 관리자가 없음. 자동 정렬이 안됨. 임의의 위치에 지정이 가능.
		c.setLayout(null);
		// jaJLabel 의 가로 , 세로 크기
		jaJLabel.setSize(50, 20); // 레이블의 크기 50x20 설정
		// jaJLabel의 시작 위치. 
		jaJLabel.setLocation(30, 30); // 레이블의 위치 (30,30)으로 설정
		// 라벨을 패널에 붙이기. 
		c.add(jaJLabel);
		// jaJLabel 의 가로 , 세로 크기
		jaJLabel2.setSize(50, 20); // 레이블의 크기 50x20 설정
		// jaJLabel의 시작 위치. 
		jaJLabel2.setLocation(80, 80); // 레이블의 위치 (30,30)으로 설정
		// 라벨을 패널에 붙이기. 
		c.add(jaJLabel2);
		// 윈도우 창의 크기
		setSize(200, 200);
		// 모든 요소를 보열줄지 여부. 
		setVisible(true);
	}

	public static void main(String[] args) {
		// 인스턴스 생성시, 라벨 여기서 추가할 예정. 
		// 인스턴스 멤버, 
		JLabel la = new JLabel("Hello"); // "Hello" 레이블
		JLabel la2 = new JLabel("Menu"); // "Hello" 레이블
		MouseEventTest3 mouseEventTest = new MouseEventTest3(la, la2);

	}

}
