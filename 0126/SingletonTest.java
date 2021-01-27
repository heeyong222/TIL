


/**
 * Singleton Pattern
 * - 클래스를 통해서 생성된 객체는 오직 하나임을 보장하는 패턴 
 * - 방법
 * 		1. 생성자는 private으로 선언한다. => 클래스 내부에서 한번만 생성할 수 있도록 설계
 * 		2. 객체에 접근할 방법이 없으므로 static 메소드를 통해 생성된 한개의 객체를 전달
 * 		=> 메서드를 통해 전달할 객체는 static 속성으로 선언해야 한다.
 */

class MySingleTon{
	private static MySingleTon instance;
	private MySingleTon() {
		public static MySingleTon getInstance() {
			if(instance == null) {
				instance = new MySingleTon();
			}
			return instance;
		}
	}
}
public class SingletonTest {

	public static void main(String[] args) {
		

	}

}
