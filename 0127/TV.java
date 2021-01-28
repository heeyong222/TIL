

public class TV extends Product {
	
	private int inch;
	
	
	public int getInch() {
		return inch;
	}

	public void setInch(int inch) {
		this.inch = inch;
	}

	public TV() {
		
	}

	public TV(int num, String name, int price, int count,int inch) {
		super(num, name, price, count);
		this.inch = inch;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("TV   [상품번호 : ").append(getNum()).append("\t상품명 : ").append(getName())
				.append("\t상품가격 : ").append(getPrice()).append("\t 재고 : ").append(getCount())
				.append("\t 크기 : ").append(getInch()).append("]");
		return builder.toString();
	}
	

}
