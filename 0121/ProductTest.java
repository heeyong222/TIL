

public class ProductTest {

	public static void main(String[] args) {
		TV tv = new TV();
		tv.setTvname("SSAFYTV");
		tv.setTvnum(11424);
		tv.setPrice(2000000);
		tv.setCount(120);
		tv.setInch(65);
		tv.setDptype("벽걸이");
		
		Refrigerator ref = new Refrigerator();
		ref.setRefname("samsung");
		ref.setRefnum(12345);
		ref.setPrice(1000000);
		ref.setInch(100);
		ref.setL(150);
		
		System.out.println(tv);
		System.out.println(ref);
	}

}
