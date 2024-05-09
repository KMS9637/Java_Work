package ex_240430;

class Parent {
	public String parentname;
	
	public void makeNoodle() {
		System.out.println("부모님 국수 메뉴 레시피로 국수 만들기");
	}
}

class Child extends Parent {
	public String childName;
	
	public void makeNoodle() {
		System.out.println("나의 국수 메뉴 레시피로 국수 만들기");
		super.parentname="부모님 국수 이름 테스트";
	}
}

public class SuperAccessTest {

	public static void main(String[] args) {
		// 업캐스팅(부모타입=자식타입)을 해서 자식 거 안보인다 확인
		// 자식 클래스 멤버에 접근이 가능하냐? No
		Parent p1=new Child();
//		p1.parentname;
		
		// 다운캐스팅(자식타입=(자식타입)부모타입)
		Child c1 = (Child)p1; 
		// 자식 클래스 멤버 및 부모 클래스 멤버도 보임
//		c1.childName;
		
		// 자식에서 국수 만들기 메서드 호출
		// 부모에도 같은 메서드가 있고 자식에도 있다 그러면 자식의 메서드 선택
		// 재정의 한 메서드가 우선이다
		c1.makeNoodle();
		
		// 점심 메뉴 자동 뽑기 호출
		// ctrl + h : 범위 지정해서 검색 가능

		System.out.println("c1.parentName : "+c1.parentname);
		
	}

}
