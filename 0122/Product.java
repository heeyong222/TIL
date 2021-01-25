

public class Product {
	private int num;
	private String name;
	private int price;
	private int count;
	
	
	

	public int getNum() {
		return num;
	}


	public void setNum(int num) {
		this.num = num;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}


	public int getCount() {
		return count;
	}


	public void setCount(int count) {
		this.count = count;
	}

	public Product(){}
	public Product(int num, String name, int price, int count) {
		this.num = num;
		this.name = name;
		this.price = price;
		this.count = count;
	}


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Product [num=").append(num).append(", name=").append(name).append(", price=").append(price)
				.append(", count=").append(count).append("]");
		return builder.toString();
	}
	
}
