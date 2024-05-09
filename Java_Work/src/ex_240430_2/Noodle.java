package ex_240430_2;

public interface Noodle {
	// 면류
	// 구성품 1) 상수 2) 추상메서드 3) private 메서드 4) default 메서드 5) static 메서드
	public final static String NOODLENAME = "면류 음식";
	// 기능) 
	//	1) 면 삶기 
	public abstract void boiledNoodle(String boiledTime);
	//	2) 토핑 추가 
	public abstract void addTopping(String[] ToppingSource);
	//	3) 육수 만들기 
	public abstract void makeSoup(String[] SoupSource);
	//	4) 양념 만들기
	public abstract void makeSource(String[] Sources);
}
