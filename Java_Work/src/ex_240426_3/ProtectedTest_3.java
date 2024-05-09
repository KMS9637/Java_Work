package ex_240426_3;

import ex_240426_2.B;

public class ProtectedTest_3 extends B {
	void f() {
		// 다른 3번째 패키지이고
		// 2번의 B라는 클래스에서 멤버가 protected이면 패키지가 달라도
		// 상속받은 자식 클래스는 접근이 가능
		n =3;
		g();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
