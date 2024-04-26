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
		
		public static final String COMMENT = "야구장 갑시다";
		
		public static void showComment() {
			System.out.println("코멘트 : " + COMMENT);
			
		}
		
		public sportsData(String sportsName, String sportstype, String sportsSeason) {
			this.sportsName = sportsName;
	        this.sportstype = sportstype;
	        this.sportsSeason = sportsSeason;
		}
	
		@Override
		public String toString() {
			return "sportsData [sportsName=" + sportsName + ", sportstype=" + sportstype + ", sportsSeason="
					+ sportsSeason + "]";
		}
		
}


