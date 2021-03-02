

public class T3_CoronaThread extends Thread{
	int num;
	
	public T3_CoronaThread(int num) {
		this.num = num;
	}
	
	@Override
	public void run() {
		
		System.out.println("#" + num + " is Started");
		for( int i=0; i< 10000; i++ ) {
			int j = i*100;
		}
		System.out.println(num);
	}
}

