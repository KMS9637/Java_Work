package ex_240423;

public class Hello {
	// 전역으로 사용된, 메서드
	public static int sum(int a, int b) {
		return a+b;
	}
	public static void main(String[] args) {
		
		// 이 경우에는 메인 함수 안에 있음.
		// 효력범위: 지역변수는 그 함수가 호출이 되고,
		// 종료하는 시점에 없어짐.
		// 지역 변수, 함수 안에 있기 때문에
		int i = 20;
		
		// 자기자신이라서 Hello.sum 생략
		int result = sum(100,200);
		System.out.println("result의 값 출력 해보기 : "+result);
		
	}

}
