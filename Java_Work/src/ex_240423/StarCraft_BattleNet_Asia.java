package ex_240423;

public class StarCraft_BattleNet_Asia {

	public static void main(String[] args) {
		System.out.println("스타크래프트로 객체 생성 배우기");
		// 작업 순서1 - 저그 객체를 생성한다.
		Zerg zerg1 = new Zerg();
		
		// 작업 순서2 - 드론을 만들기.
		zerg1.setDrone("9드론 생산함");
		
		// 작업 순서3 - 드론으로 미네랄, 가스 채취.
		zerg1.makeMoney();
		
		// 작업 순서4 - 드론으로 정찰 보내기.
		zerg1.patrolDrone();
		
		// 작업 순서5 - 전략 선택.
		String lsyZergStrategy = "4드론 ㄱㄱ";
		zerg1.selectStrategy(lsyZergStrategy);
		
		System.out.println("오늘도 즐거운 한 판");
	}

}
