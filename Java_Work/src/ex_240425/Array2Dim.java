package ex_240425;

public class Array2Dim {

	public static void main(String[] args) {
		// 2차원 배열 선언 및 값 출력 해보기.
		// 정의: 기본 배열에서 대괄호 하나씩 추가
		// 방법1
		// int[][] intArray = new int[3][2];
		// 방법2
		// int[][] intArray2 = {{1,2},{3,4},{5,6}};
		
		int[][] intArray = new int[3][2];
		// 데이터 입력 방법
		// 1) 각각 더미로 입력 2) 스캐너로 입력 3) 파일로 입력 4) 데이터 베이스에 불러와서 입력 등
		intArray[0][0] = 1;
		intArray[0][1] = 2;
		intArray[1][0] = 3;
		intArray[1][1] = 4;
		intArray[2][0] = 5;
		intArray[2][1] = 6;
		// intArray.length -> 행 , 3행 , 0,1,2
		for (int i=0; i<intArray.length; i++) {
			// intArray[i].length -> 열 , 2행 , 0,1
			for(int j=0; j<intArray[i].length;j++) {
				System.out.print(i+"행"+j+"열"+"값: "+intArray[i][j]+"\t");
			}
			System.out.println();
		}

	}

}
