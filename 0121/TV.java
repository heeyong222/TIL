

public class TV {
	private int tvnum;
	private String tvname;
	private int price;
	private int inch;
	private int count;
	private String dptype;
	public int getTvnum() {
		return tvnum;
	}
	public void setTvnum(int tvnum) {
		this.tvnum = tvnum;
	}
	public String getTvname() {
		return tvname;
	}
	public void setTvname(String tvname) {
		this.tvname = tvname;
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
	public String getDptype() {
		return dptype;
	}
	public void setDptype(String dptype) {
		this.dptype = dptype;
	}
	
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public TV() {}
	
	public TV(int tvnum, String tvname, int price, int inch, int count, String dptype) {
		this.tvnum = tvnum;
		this.tvname = tvname;
		this.price = price;
		this.inch = inch;
		this.count = count;
		this.dptype = dptype;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("제품번호 : ").append(tvnum).append(" 제품명 : ").append(tvname).append(" 가격 : ").append(price).append(" 수량 : ").append(count)
				.append(" 인치 : ").append(inch).append(" 제품타입 : ").append(dptype);
		return builder.toString();
	}
	
	
	
}
