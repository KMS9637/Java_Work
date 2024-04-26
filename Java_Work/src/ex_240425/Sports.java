package ex_240423;

public class Sports {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		sportsData sports1 = new sportsData(null,null,null);
		
		sports1.setSportsName("야구ㅜㅜㅜㅜ");
		
		sports1.setSportstype("야외에서");
				
		sports1.setSportsSeason("4월부터10월까지");

		System.out.println(sports1.toString()); 

		System.out.println(sportsData.COMMENT);
		
		sportsData.showComment();
	}

}
