package ex_240423;

public class KoreanFood {
	// 설계도면으로 사용할 예정
	// 객체=클래스 -> 수납도구 -> 멤버와 함수를 가지고 있다.
	// 멤버, 메서드를 가지고 있다.
	private String foodName;
	private int foodPrice;
	private String foodPlace;
	
	// 전역으로 사용이 되고, 상수로 사용함. - 전역 상수
	private static final String projectName = "오늘 점심 메뉴 선정 프로젝트";
	
	// 방법1. getter/setter 라는 것을 추가하기.
		// 반자동( 코드 스니펫으로 자동 만들기)
		// 우클릭 -> Source 
	public String getFoodName() {
		return foodName;
	}
	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}
	public int getFoodPrice() {
		return foodPrice;
	}
	public void setFoodPrice(int foodPrice) {
		this.foodPrice = foodPrice;
	}
	public String getFoodPlace() {
		return foodPlace;
	}
	public void setFoodPlace(String foodPlace) {
		this.foodPlace = foodPlace;
	}
	public KoreanFood(String foodName, int foodPrice, String foodPlace) {
		super();
		this.foodName = foodName;
		this.foodPrice = foodPrice;
		this.foodPlace = foodPlace;
	}
	
	// 방법2, lombok 라이브러리
	// 메모리상에 getters, setters toString, Data 등 만들어둠
	
	// 생성자 만들기. 클래스 설계도면
	
	public static String showStaticMember() {
		return projectName;
	}
	
	// 귀찮으니, 다 출력하는 함수 만들기. 인스턴스 메서드 방법으로
	public void showInfo(){
		System.out.println("오늘 점심 메뉴 : "+this.foodName+", 가격 : "+this.foodPrice+", 장소 : "+this.foodPlace);
	}
}
