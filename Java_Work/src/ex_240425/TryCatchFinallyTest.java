package ex_240425;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TryCatchFinallyTest {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("정수 3개를 입력해주세요.");
		int sum = 0, n=0;
		
		for (int i = 0; i < 3; i++) {
			System.out.println(i+">>");
			try {
				// 정수를 입력하기로 했는데 예외를 만들기 위해서 문자열 입력하기
				n=scanner.nextInt();
				} catch (InputMismatchException e) {
				System.out.println("정수가 아닙니다. 다시 입력하세요");
				scanner.next();
				i--;
				continue;
			}
			sum+=n;
		}
		System.out.println("합은 "+sum);
		scanner.close();
	}

}
