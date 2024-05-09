package ex_240430_2;

import util.RandomSelectNumber;

public class Main {

	public static void main(String[] args) {
		// 확인 , 쌀쌀 국수 
		RiceRiceNoodle lsy = new RiceRiceNoodle();
		System.out.println("이상용 쌀쌀국수 만들기 프로젝트");
		
		lsy.boiledNoodle("5");
		// 토핑 재료 추가 
		String[] toppingSource = {"고수",
				"양파","숙주","소고기","쪽파","레몬"
				,"마늘"};
		lsy.addTopping(toppingSource);
		
		// 국물 재료 추가 
		String[] soupSource = {"멸치","다시다",
				"월계수","후추","팔각","향신료"};
		
		lsy.makeSoup(soupSource);
		
		// 양념 재료 추가. 
		String[] source = {"칠리","땅콩",
				"고추","호두","물고기소스"};
		lsy.makeSource(source);
		
		// 면 1. 가는 면, 2. 굵은 면 
		lsy.selectNoodleSize(1);
		
		System.out.println("쌀쌀 국수 완성");
		
		// 시식
		String[] eatMembers = {"오현제",
				"이한솔","이상용",
				"임채수","김소영",
				"이수진","강루키"};
		
		// 랜덤하게, 멤버 한명 선택해서 먹기. 
		// util , 패키지 , 자주 사용하는 기능들 모아두기. 
		// RandomSelectNumber, 메서드 명 : selectInt
		int selectedNumberofMember = RandomSelectNumber.selectInt(7);
		// 시식자 선정 완료. 
		System.out.println("시식하는 사람은 : " + eatMembers[selectedNumberofMember] + " 당첨.ㅋㅋㅋ");
		
	}

}


