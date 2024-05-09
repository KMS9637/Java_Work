package ex_240426;

class Sample {
	public int a;
	private int b;
	int c;
	public int getB() {
		return b;
	}
	
	// 전역만 확인해보기.
	
	static int tvChannel = 3;
	public static void channelUp() {
		tvChannel++;	
	}
	public static void channelDown() {
		tvChannel--;
	}
}

public class AccessTest {

	public static void main(String[] args) {
		Sample sample = new Sample();
//		sample.b=3;
		int result = sample .getB();
		System.out.println("b : "+result);
		
		// public int a;
		// 값 직접 접근이 가능해서 읽기/쓰기 가능
		// 직접 쓰기
		sample.a=200;
		// 직접 읽기
		System.out.println("sample.a의 값 : "+ sample.a);
		
		// 이상용씨, 강루키, 홍사자 프로젝트로 합숙, 공용 거실에 쉬는 중
		Sample lsy = new Sample();
		Sample krk = new Sample();
		Sample hsj = new Sample();
		System.out.println("이상용씨가 티비를"+ lsy.tvChannel+"번 채널 시청중");
		System.out.println("강루키씨가 UFC를 보고싶어서 채널을 1 올림.");
		// 강루키씨의 채널 변경
		krk.channelUp();
		System.out.println("이상용씨와 강루키씨, 홍사자씨는 같이 채널 "+lsy.tvChannel+"채널 시청중" );
		
	}

}
