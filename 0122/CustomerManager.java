
import java.util.Arrays;


public class CustomerManager {
	//고객 정보를 저장할 배열
	private Customer[] custs;
	//등록된 고객 수, 고객이 저장된 배열 위치
	
	private static int size;
	private int MAX_SIZE = 3;
	//이거랑
	private static CustomerManager instance;
	private CustomerManager() {
		custs = new Customer[MAX_SIZE];
	}
	//이거 추가, 생성할때 CustomerManager mgr = CustomerManager.getInstance(); 싱글톤아니면 CustomerManager mgr = new CustomerManager();
	public static CustomerManager getInstance() {
		if(instance == null) {
			instance = new CustomerManager();
		}
		return instance;
	}
	/**
	 * 고객 정보를 등록하는 기능
	 * @param cust 등록할 고객 정보
	 */
	
	public void add(Customer cust) {
		if(size < MAX_SIZE) {
			custs[size++] = cust;
		}else {
			System.out.println("더이상 등록할 공간이 없습니다.");
		}
	}
//	
//	public void add(Customer cust) {
//		if(size >=  MAX_SIZE) {
//			MAX_SIZE += 10;
//			custs = Arrays.copyOf(custs,  MAX_SIZE);
//		}
//		custs[size++] = cust;
//	}
	
	public void remove(String name) {
		for(int i = 0; i < size; i++) {
			if(name.equals(custs[i].getName())) {
				custs[i] = custs[size-1];
				custs[size-1] = null;
				size--;
				break;
			}
		}
	}
	
	public Customer searchByName(String name) {
		for(int i = 0; i < size; i++) {
			if(name.equals(custs[i].getName())) {
				return custs[i];
			}
		}
		return null;
	}
	
	public void update(Customer cust) {
		String name = cust.getName();
		for(int i = 0; i < size; i++) {
			if(name.equals(custs[i].getName())) {
//				custs[i].setAddress(cust.getAddress());
//				custs[i].setAge(cust.getAge());
				custs[i] = cust;
				break;
			}
		}
	}
	
	public Customer[] getList() {
		return Arrays.copyOfRange(custs, 0, size);
	}
	
	public void printCustomers() {
		for(Customer customer : custs) {
			System.out.println(customer);
		}
	}
	
	
}
