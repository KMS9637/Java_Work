package ex_240430;

class A {
	public A() {
//		// 작업 순서4, 본인 생성자 호출
//		// 출력 순서1
		System.out.println("생성자 A() 호출");
//		public A(String name) {
//			// 작업 순서4, 본인 생성자 호출
//			// 출력 순서1
//			System.out.println("생성자 A() 호출");
	}
}
class B extends A {
	
		// 작업 순서2, A() 생성자 호출
		// 출력 순서2
	public B() {
		
		System.out.println("생성자 B() 호출");
	}
}
class C extends B {
	public C() {
		// 작업 순서2, B() 생성자 호출
		// 출력 순서3
		System.out.println("생성자 C() 호출");
	}
}

public class SuperConsTest {

	public static void main(String[] args) {
		// 작업 순서1, C() 생성자 호출
		C c = new C(); 

	}
}
