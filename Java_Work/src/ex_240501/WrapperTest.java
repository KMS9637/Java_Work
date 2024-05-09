package ex_240501;

public class WrapperTest {

	public static void main(String[] args) {
		// Wrapper 클래스, 기본형 -> 참조형(객체) 타입 변경 - 박싱
		// 언박싱 - 참조형 -> 기본형, 자동으로 업캐스팅, 다운캐스팅 등 지원
		Integer integer =Integer.valueOf(31);
		// bitCount(int i) -> 이진숫자에서 1의 개수를 리턴
		int bitCountResult =integer.bitCount(31);
		System.out.println(bitCountResult);
		
		// 참조형에서 기본형으로 변환
		// intValue() : int타입으로 반환
		int refTointResult = integer.intValue();
		System.out.println(refTointResult);

		// int parseInt(String str) : int반환
		 int stringTointResult =integer.parseInt("1234");
		System.out.println(stringTointResult);
		
		// int parseInt(String str, int radix)
		int intToBinaryResult = integer.parseInt("31", 16);
		System.out.println(intToBinaryResult);
	}

}
