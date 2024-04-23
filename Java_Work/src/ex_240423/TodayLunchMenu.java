package ex_240423;

public class TodayLunchMenu {
	// 자바는 메인에서 시작해서 메인에서 끝난다. 실행하는 클래스 역할.
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("메인 시작");
		
		// 임의로 진도 상관없이, 설계도면으로 사용하는 클래스를 사용하는 방법.
		// A a = new A()
		// A : 클래스명, 예)KoreanFood
		// a : 참조형 변수, 예) bibimbab
		// new : 예약어, 시스템에서 미리 선정해서 사용해서 이름으로 사용불가.
		// A() : 생성자라고 부름 
		// ex) KoreanFood(String foodName, int foodPrice, String foodPlace)
		// 객체 만들어보기, 인스턴스화 하기, 이렇게 부른다
		KoreanFood bibimbab = new KoreanFood("비빔밥", 9000,"본죽비빔밥");
		
		// 객체 -> 수납도구 -> 멤버와 함수가 있다.
		// 출력해보기.
		System.out.println(" 오늘 점심 메뉴 : " + bibimbab.getFoodName());
		System.out.println(" 오늘 점심 메뉴 가격 : " + bibimbab.getFoodPrice()+"원");
		System.out.println(" 오늘 점심 장소 : "+bibimbab.getFoodPlace());
		
		// 전역 상수 및 전역 메서드 사용해보기. 클래스명 : KoreanFood
		// 사용방법 : 클래스명.멤버 또는 클래스명.함수
		String test = KoreanFood.showStaticMember();
		System.out.println("test 변수에 담긴 내용 출력해보기 : "+test);
		
		// 변수를 사용할 때, 
		// 1) 인스턴스 멤버: 객체를 생성해야 사용 가능
		// 2) static 멤버: 클래스명으로 객체 생성 없이 바로 사용 가능함
		
		// Hello.java 파일 안에 있는 전역 함수 사용해보기.
		// 같은 패키지(폴더)안에 있어서, 따로 임포트를 안해도 된다.
		int result = Hello.sum(1000, 2000);
		System.out.println("Hello의 클래스안에 함수 실행 결과 result : "+result);
		
	}
}
