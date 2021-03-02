
public class T5_CoronaThread extends Thread {
	int num;
	
	public T5_CoronaThread(int num) {
		this.num = num;
	}
	
	@Override
	public void run() {
		
		for( int i=0; i< 10000; i++ ) {
			if( i == 5000 && num % 2 == 0 ) {
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		System.out.println(num);
	}
}
