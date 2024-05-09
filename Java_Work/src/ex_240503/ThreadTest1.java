package ex_240503;

public class ThreadTest1 extends Thread{
	int n = 0;
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		while(true)
		{
			System.out.println("숫자 카운트 스레드1 : "+n);
			n++;
			
			try {
				sleep(1000);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}		
	}
	
	public static void main(String[] args) {
		

	}

}
