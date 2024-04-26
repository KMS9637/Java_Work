package ex_240424;

import java.util.Scanner;

public class ScannerTest1 {

	public static void main(String[] args) {
		// 스캐너 사용하기.
		// 순서1. Scanner 클래스 사용하기.
		// 클래스 객체(인스턴스) 생성 어떻게 하나요?
		// A a = new A(); A: 클래스명, a: 참조형 변수, new: 키워드, 예약어, A(): 생성자 <- 초기화 하는 역할
		// 초기화 = 동적메모리 어딘가에 할당을 한다. <--> null
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("가입할 이메일을 작성해주세요 : ");
		String userEmail = scanner.next();
		
		System.out.println("가입할 메일은 : "+userEmail);

		scanner.close();
		
	}

}
