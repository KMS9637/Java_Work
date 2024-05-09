package util;

import java.util.Random;

public class RandomSelectNumber {
	public static int selectInt(int boundary) {
		Random random = new Random();
		// 함수 사용. 	random.nextInt(5); , 5미만의 정수, 랜덤 뽑기. 
		int randomNumber = random.nextInt(5);
		System.out.println("랜덤한 숫자 : " + randomNumber );
		return randomNumber;
	}
	
}
