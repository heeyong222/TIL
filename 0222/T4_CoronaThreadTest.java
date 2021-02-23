

public class T4_CoronaThreadTest {
	public static void main(String[] args) {
		
		System.out.println("before Thread.sleep()");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("after Thread.sleep()");

	}
}
