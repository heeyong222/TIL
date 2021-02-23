
import com.ssafy.thread.T5_CoronaThread;
public class T5_CoronaThreadTest {
	public static void main(String[] args) {
		
		for( int t=0; t<1000; t++ ) {
			
			T5_CoronaThread thread = new T5_CoronaThread(t);
			thread.start();
			
		}
	}
}
