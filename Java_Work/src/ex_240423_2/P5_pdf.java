package ex_240423_2;

public class P5_pdf {
	// 인스턴스 멤버
	int i1 = 10;
	// 스태틱 멤버
	static int i2 = 20;
	public static void showNumber(int input) {
		int i1 = 100;
//		i1 = input;
		System.out.println("result : "+ i1);
	}
	
	public static void main(String[] args) {
		int i1 = 20;
		System.out.println("i1 : "+i1);
		
		// 메서드 호출
		showNumber(i1);

		
		// 객체 만들기
		// 정의 : 클래스명 참조형 변수 = new 클래스명(); <- 생성자
		P5_pdf p5 = new P5_pdf();
		int result = p5.i1;
		System.out.println("result i1 : "+result);
		int result2 = p5.i2;
		int result3 = P5_pdf.i2;
		System.out.println("result i2 : "+result2);
		System.out.println("result i3 : "+result3);
		
		// 
	}

}
