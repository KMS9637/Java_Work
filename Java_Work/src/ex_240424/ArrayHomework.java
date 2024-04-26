package ex_240424;

import java.util.Random;
import java.util.Scanner;

public class ArrayHomework {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		String menuArray[] =new String[5];
		
		System.out.println("메뉴를 입력하세요.(최대 5개)");
		
		for(int i=0;i<menuArray.length;i++) {
			menuArray[i]=scanner.next();
		}
		
		// 랜덤한 숫자 0~4 중에서, 하나 선택 후 임시변수에 담아서 배열에 menuArray[임시변수]해서 출력
		Random random = new Random();
		int randomnumber = random.nextInt(5);
		System.out.println("랜덤한 숫자 : "+randomnumber);
		
		System.out.println("점심메뉴 리스트");
		System.out.println("=====================");
//		for(int j=0;j<menuArray.length;j++) {
			System.out.print(menuArray[randomnumber]+" ");
//		}
		
		scanner.close();
	}
}