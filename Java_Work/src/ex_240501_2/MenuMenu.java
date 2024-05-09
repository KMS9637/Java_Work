//미니 실습
//벡터를 만들기 / 타입은 Person 타입으로
//데이터 추가하기.
//데이터 삭제하기.
//데이터 출력하기.
//확인 해보기.
//
//Scanner 이용해서
//콘솔에서 본인이 먹고싶은 메뉴를 입력해서 벡터에 저장하기.
//
//1. 메뉴 입력
//2. 메뉴 출력
//3. 검색하기
//4. 종료하기
//
//1번 입력 - (출력) 메뉴를 입력해주세요>> - 값 입력 - 메인 메뉴로 돌아가는 exit
//2번 입력 - 메뉴 출력, 세로로, 출력 후 다시 메인 메뉴 나오기
//3번 입력 - (출력) 검색해주세요>> - 해당 키워드가 있다, 없다 표기하기 - 다시 메인 메뉴로
//4번 입력 - (출력) 프로그램 종료합니다.
//5번 데이터 삭제하기 어디갔지

package ex_240501_2;

import java.util.Scanner;
import java.util.Vector;

import util.CollectionUtils;

public class MenuMenu {
	public static void main(String[] args) {
		// Person 클래스 선언
		class Person {
		    private String menu;

		    public Person(String menu) {
		        this.menu = menu;
		    }

		    public String getMenu() {
		        return menu;
		    }
		}
		
		// 입력받기위한스캐너생성
		Scanner scanner = new Scanner(System.in);
		
		// Vector 생성
		Vector<Person> v = new Vector<Person>(); 
		
		while (true) {
		// 메뉴 선택 (메인 메뉴)
		System.out.println("메뉴를 선택하세요");
		System.out.print("1.메뉴 입력 / 2.메뉴 출력 / 3.메뉴 검색 / 4.프로그램 종료 / 5.메뉴 삭제>>");
		int Menu_Number =scanner.nextInt();
		
		// 1.메뉴 입력 (데이터 추가하기)
		if (Menu_Number==1) {
			
			while(true) {
				System.out.print("메뉴를 입력해주세요(exit 입력시 종료)>>");
				String insert_menu =scanner.next();
		
				if(insert_menu.equals("exit")) {break;}
				
				Person person = new Person(insert_menu);
				v.add(person);
				
			}
		}
		
		// 2. 메뉴 출력 (데이터 출력하기)
		else if (Menu_Number==2) {
			for (int i = 0; i < v.size(); i++) {
				System.out.println(v.get(i).getMenu());		
			}
			System.out.println("=========================");
			continue;
		  }
		
		// 3. 검색하기
		else if (Menu_Number==3) {
			System.out.print("메뉴를 검색해주세요>>");
			// 메뉴 입력
			String Search_Menu =scanner.next();
			
			boolean found = false;

            for (Person person : v) {
                if (person.getMenu().equals(Search_Menu)) {
                    found = true;
                    break;
                }
            }
            
			// 존재할 경우, 존재하지 않을 경우
            if (found) {
                System.out.println(Search_Menu + " 메뉴가 있습니다!");
            } else {
                System.out.println(Search_Menu + " 메뉴가 없습니다!");
            }
		
			continue;
		}
		
		// 4. 종료하기
		else if (Menu_Number==4) {
			System.out.print("프로그램 종료");
			break;
		}
		
		// 5. 삭제하기
		else if (Menu_Number==5) {
			System.out.print("삭제할 메뉴를 입력하세요>>");
			String Remove_Menu =scanner.next();

			boolean found2 = false;
			Person removeTarget = null;
			
			for (Person person : v) {
                if (person.getMenu().equals(Remove_Menu)) {
                	removeTarget=person;
                	found2=true;
                	break;
                }
			}
            if(found2) {
              	System.out.println(Remove_Menu + " 메뉴를 삭제했습니다!");
               	v.remove(removeTarget);
            }
            else {
               	System.out.println(Remove_Menu + " 메뉴가 없습니다!");
               	}
            
			continue;
		}
	}
		// 반환
		scanner.close();
 }
}

