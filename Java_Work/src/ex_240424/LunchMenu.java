package ex_240424;

import java.util.Scanner;

public class LunchMenu {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while(true) {
		System.out.println("오늘 점심 메뉴 무엇을 먹을까요?");
		System.out.println("날씨가 어떤가요? 1.비, 2.흐림, 3.맑음, 4.바람, 5.종료");
		
		int menu_number = scanner.nextInt();
		
		switch(menu_number) {
			case 1:
				System.out.println("1. 오늘은 비, 라면 추천");
				System.out.println("======================");
				break;
			case 2:
				System.out.println("2. 오늘은 흐림, 칼국수 추천");
				System.out.println("======================");
				break;
			case 3:
				System.out.println("3. 오늘은 맑음, 돈까스 추천");
				System.out.println("======================");
				break;
			case 4:
				System.out.println("4. 오늘은 바람, 국밥 추천");
				System.out.println("======================");
				break;
			case 5:
				System.out.println("5. 종료");
				scanner.close();
				break;
			default:
				System.out.println("잘못입력함");
			}
		if (menu_number == 5) {
            break;
        	}
		}
	}
}

//String menu_char = scanner.next();
//숫자 비교 할 경우, 연산자 ==
//

// 문자열을 비교 할 경우, 문자열.equals("")
//if(menu_number==1) {
//	System.out.println("1. 오늘은 비, 라면 추천");
//	}
//else if(menu_number==2) {
//	System.out.println("2. 오늘은 흐림, 칼국수 추천");
//	}
//else if(menu_number==3) {
//	System.out.println("3. 오늘은 맑음, 돈까스 추천");
//	}
//else if(menu_number==4) {
//	System.out.println("4. 오늘은 바람, 국밥 추천");
//	}
//else {
//	System.out.println("5. 기타");
//	}