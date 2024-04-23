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
	}

}
