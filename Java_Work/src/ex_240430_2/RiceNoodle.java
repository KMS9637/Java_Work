package ex_240430_2;

public interface RiceNoodle extends Noodle {
	// 면류 인터페이스를 상속 받은 쌀국수 인터페이스
	public final static String price = "기본 8000원";
	
	// 쌀국수만의 기능
	// 면 굵기 조절
	public abstract void selectNoodleSize(String[] );
}
