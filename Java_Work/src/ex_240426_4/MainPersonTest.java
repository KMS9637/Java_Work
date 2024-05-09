package ex_240426_4;

import javax.management.modelmbean.ModelMBean;

public class MainPersonTest {

	public static void main(String[] args) {
		// 인스턴스 만들기
		// 받는 타입 : Person 부모
		// 생성자 호출의 타입 : Student 자식
		// 다형성
		Person2222222222222222222222 lsy = new Student();

		//
		Person2222222222222222222222 lcs = new StudentWorker();
		
		// lsy는 타입이 뭐죠? Person, Student
		// lcs는 타입이 뭐죠? Person, Student, StudentWorker
		
		// lsy는 현재 상황에서 보이는 메서드는 어디까지일까요? : Person
		// 즉, Student의 study가 안보임
		// Student의 study를 보려고 한다. 어떻게 할까 : 다운캐스팅
		// instanceof
		// 결론, 어떻게 사용하는지? model // 타입을 일치시키고 작업
		// 다운 캐스팅 그냥 하면 안되고 유효성 타입 체크 필요
		if (lsy instanceof Student) {
			// 타입이 맞는지 확인 후 다운캐스팅 해야함
			// 문법상에는 걸리지 않기 때문
			// 실행시점에서 클래스캐스트 예외가 발생해서.
			Student lsyStudent=(Student)lsy;
			lsyStudent.study();
		}
		
		// 부모 클래스 중에서 기능이 4개 있다
		// 말하기, 먹기, 걷기, 잠자기
		// Student 자식 말하기 재정의
		// 부모에도 자식에도 말하기 기능 있음
		// 이상황에서 lsy는 -> 부모? 자식? 누구의 말하기 기능을 쓸까? : 자식 사용 (가상 메서드)
		// 상속을 받았다면 재정의할 때 자식 메서드가 우선임
		lsy.speak();
	}

}
