package ex_240424;

import java.util.Scanner;

public class FunctionTest{
		
		public static int startmenu(Scanner scanner){
			System.out.println("오늘 점심 메뉴 무엇을 먹을까요?");
			System.out.println("날씨가 어떤가요? 1.비, 2.흐림, 3.맑음, 4.바람, 5.종료");
			int menu_number = scanner.nextInt();
			return menu_number;
		}
		
		public static void recommendFood(int i) {
			switch(i) {
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
					break;
				default:
					System.out.println("잘못입력함");
				}
			}
				
		public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int i;
		do {
		    i = startmenu(scanner); 
		    if (i != 5) {
		        recommendFood(i);
		    }
		} while (i != 5);
			scanner.close();
		}
}