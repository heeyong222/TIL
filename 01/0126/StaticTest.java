


class Counter{
	//static variable, class variable
	static int scount;
	//non-static variable, instance variable
	int icount;
	
	static {
		System.out.println("statick block 호출됨.....");
	}
	{
		System.out.println("instance block이 호출됨");
	}
	
	
	Counter(){
		System.out.println("생성자 호출됨");
		scount++;
		icount++;
	}
	void print() {
		System.out.printf("scount:%d\ticount:%d\n",scount, icount);
	}
//	static void sprint() {
//		System.out.printf("scount:%d\ticount:%d\n",scount, icount); // ->icount는 에러남
//	}
}


public class StaticTest {

	public static void main(String[] args) {
		Counter.scount++;
		System.out.println(Counter.scount);
		
		Counter c1 = new Counter();
		c1.print();
		
		Counter c2 = new Counter();
		c2.print();
	}	

}
