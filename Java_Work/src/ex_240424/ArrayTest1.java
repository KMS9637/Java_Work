package ex_240424;

public class ArrayTest1 {

	public static void main(String[] args) {
		// 배열 정의, 방법1
		int []intArray = new int[5]; 
		int intArray2[] = new int[5];
		
		// 선언과 할당(초기화를 분리해서 사용), 방법2
		int []intArray3;
		intArray3 = new int[5];
		
		// 선언과 할당(바로하기) 방법3
		int []inArray4 = {1,2,3,4,5};
		
		// 문자열 버전
		String []strArrayString =new String[5]; 
		String strArrayString2[]  =new String[5];
		String[] strArray3;
		strArray3 = new String[5];
		String []strArray4 = {"김민수1","김민수2","김민수3"};
	}

}
