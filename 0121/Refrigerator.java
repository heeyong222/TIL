

public class Refrigerator {	
	private int refnum;
	private String refname;
	private int price;
	private int inch;
	private int L;
	public int getRefnum() {
		return refnum;
	}
	public void setRefnum(int refnum) {
		this.refnum = refnum;
	}
	public String getRefname() {
		return refname;
	}
	public void setRefname(String refname) {
		this.refname = refname;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getInch() {
		return inch;
	}
	public void setInch(int inch) {
		this.inch = inch;
	}
	public int getL() {
		return L;
	}
	public void setL(int l) {
		L = l;
	}
	public Refrigerator() {}
	
	public Refrigerator(int refnum, String refname, int price, int inch, int l) {
		this.refnum = refnum;
		this.refname = refname;
		this.price = price;
		this.inch = inch;
		L = l;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("제품번호 : ").append(refnum).append(" 제품명 : ").append(refname).append(" 가격 : ")
				.append(price).append(" 수량 : ").append(inch).append(" 용량 : ").append(L);
		return builder.toString();
	}
	
	
	

}
