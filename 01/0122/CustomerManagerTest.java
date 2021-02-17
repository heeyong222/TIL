
public class CustomerManagerTest {

	public static void main(String[] args) {
		CustomerManager mgr = CustomerManager.getInstance();
		
		mgr.add(new Customer("111","강남",5));
		mgr.add(new Customer("홍길동","강남",29));
		mgr.add(new Customer("고길동","역삼",50));
		
		System.out.println("==============고객 등록 후===============");
		mgr.printCustomers();
		System.out.println("==============이름으로 고객 찾기===============");
		System.out.println(mgr.searchByName("홍길동"));
		System.out.println(mgr.searchByName("ㄱㄱㄱ"));
		System.out.println("==============고객 수정 후===============");
		mgr.update(new Customer("111", "강남", 99));
		mgr.printCustomers();
		
		System.out.println("==============고객 목록===============");
		Customer[] cust = mgr.getList();
		for(Customer customer : cust) {
			System.out.println(customer);
		}
		System.out.println("==============고객 삭제 후===============");
		mgr.remove("ssafy");
//		
//		mgr.printCustomers();
		
	}
	

}
