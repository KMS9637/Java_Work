package ex_240426;

import java.io.ObjectInputStream.GetField;
import java.util.Iterator;

public class CallByRefMethodTest {
	public static void increase(int m) {
		// int m = n
		// m은 지역변수, 함수 시작과 종료시에만 있고 후에는 삭제, 따라서 11이 되어도 main으로 넘어가지 못함
		m=m +1;
	}
	// int[] array = a = 0x100
	public static void increaseArray(int []array) {
		for (int i = 0; i < array.length; i++) {
			array[i]++;
		}
	}
	public static void main(String[] args) {
		// 기본형 vs 참조형 , 메소드의 인자값으로 전달시, 생존 여부
		// 결론, 기본형은 소멸, 참조형은 메모리 위치 주소값 생존.
		// 기본형
		int n = 10;
		increase(n);
		System.out.println("n : "+n);
		
		// 참조형, a=0x100, 메모리 위치 주소값이 있다
		int [] a= {1,2,3,4,5};
		increaseArray(a);
		
		// 출력 해보기.
		for (int i = 0; i < a.length; i++) {
			System.out.println("a : "+i+":"+a[i]);
		}
	}

}
