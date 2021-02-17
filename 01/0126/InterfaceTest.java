

import java.io.Serializable;

/**
 * interface 
 *   - 추상 메서드와 상수로만 구성 
 *   - 객체 생성 불가   => 다형성에 의해서 sub참조 할수 있다. 
 *   - 다중 상속이 된다.  =>다형성을 위해서 
 *   
 *   
 *   
 *   상속
 *     - type 상속		interface
 *     - type + 구현상속      class
 *     
 *     
 *   - interface 선언 방법
 *     [public] interface 인터페이스이름 [extends 부모인터페이스1, 부모인터페이스2....]{
 *     
 *     }    
 *   
 *   - interface 구현 방법
 *     [modifier] class 클래스명 [extends 부모클래스] [implements 인터페이스명1, 인터페이스명2...]{
 *     
 *     }
 */
interface Trans extends Serializable, Cloneable{
	void start();
	void stop();
} 

interface Flyer {
	void fly();
}

class Human{
	String name;
	public void start() {
		System.out.println("걸어 갑니다.");
	};
}

class SuperMan extends Human implements Trans, Flyer{
	public void fly() {
		System.out.println("날아서 지구를 구해야지");
	}
	public void stop() {
		System.out.println("잠깐 쉴까?");
	}
}

public class InterfaceTest {
	public static void main(String[] args) {
		SuperMan clark = new SuperMan();
		clark.start();
		clark.stop();
		clark.fly();
		Flyer f = clark;
		
		Trans t = clark;
		
		Cloneable c= clark;
		
	}
}





