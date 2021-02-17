

public class Refrigerator extends Product {
	
	private int size;
	
	
	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public Refrigerator() {
		
		
	}

	public Refrigerator(int num, String name, int price, int count, int size) {
		super(num, name, price, count);
		this.size = size;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("냉장고 [상품번호 : ").append(getNum()).append("\t상품명 : ").append(getName())
				.append("\t상품가격 : ").append(getPrice()).append("\t 재고 : ").append(getCount())
				.append("\t 크기 : ").append(getSize()).append("]");
		return builder.toString();
	}
	
	
}
