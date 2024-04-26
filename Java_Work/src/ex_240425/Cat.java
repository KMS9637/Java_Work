package ex_240425;

public class Cat extends Animal{
	private String place;

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	// 생성자 만들기.
	public Cat() {
		// super() = Animal() 호출하는 것과 동일함
		super(); // 부모의 기본 생성자를 호출하는 키워드
		
	}

	// 자식 클래스 Cat, 생성자
	public Cat(String name, int age, String[] favoriteFood, String place) {
		// super(name, age, favoriteFood); => Animal(name, age, favoriteFood); 
		super(name, age, favoriteFood);
		this.place = place;
	}
}