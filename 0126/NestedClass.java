

class OuterClass{
	private int i;
	
	//nested class 는 static, private, protected도 사용가능, 일반class는 사용불가
	//outerclass에 선언된 private 멤버에 접근 가능
	class NestedClass{
		public void test() {
			//같은 클래스의 멤버이기때문에 private인 i에 접근 가능
			System.out.println(i);
		}
	}
	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}
	
}
public class NestedClass {
	
	public static void main(String[] args) {
		OuterClass o = new OuterClass();
		System.out.println(o.getI());
	}

}
