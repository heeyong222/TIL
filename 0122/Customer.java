
public class Customer {
	private String name;
	private String address;
	private int age;
	public Customer() {}
	
	public Customer(String name, String address, int age) {
		this.name = name;
		this.address = address;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		if(age > -1) {
			this.age = age;			
		}else {
			System.out.println("나이는 0이상으로 설정해주세요");
		}
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Customer [name=").append(name).append(", address=").append(address).append(", age=").append(age)
				.append("]");
		return builder.toString();
	}
	
	
	
}
