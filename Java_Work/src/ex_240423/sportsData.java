package ex_240423;

public class sportsData {
		private String sportsName;
		private String sportstype;
		private String sportsSeason;
		
		
		public String getSportsName() {
			return sportsName;
		}
		public void setSportsName(String sportsName) {
			this.sportsName = sportsName;
		}
		public String getSportstype() {
			return sportstype;
		}
		public void setSportstype(String sportstype) {
			this.sportstype = sportstype;
		}
		public String getSportsSeason() {
			return sportsSeason;
		}
		public void setSportsSeason(String sportsSeason) {
			this.sportsSeason = sportsSeason;
		}
		
		
		public void name() {
			System.out.println("야구ㅜㅜㅜㅜㅜㅜㅜㅜㅜ");
		}
		public void sportsPlace() {
			System.out.println("사직구장 ㄱㄱ");
		}
		public void sportsSeason(String season) {
			System.out.println("언제부터 언제까지 : "+season);
		}
}
