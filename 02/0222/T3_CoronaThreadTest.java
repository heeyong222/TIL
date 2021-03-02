

public class T3_CoronaThreadTest {
	public static void main(String[] args) {
		for( int t=0; t<1000; t++ ) {
			
			T3_CoronaThread thread = new T3_CoronaThread(t);
			thread.start();
			
		}
	}
}
