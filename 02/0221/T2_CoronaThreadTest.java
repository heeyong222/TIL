
import com.ssafy.thread.T2_CoronaRunnable;


public class T2_CoronaThreadTest {

	public static void main(String[] args) {
		for( int t=0; t<1000; t++ ) {
			
			T2_CoronaRunnable cr = new T2_CoronaRunnable(t);
			Thread thread = new Thread(cr);
			thread.start();
			
		}
	}
}