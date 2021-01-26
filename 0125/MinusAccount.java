
public class MinusAccount extends Account {
	private int limit;
	public MinusAccount() {}
	public MinusAccount(String no, String password, int balance, int limit) {
		super(no, password, balance);
		this.limit = limit;
	}
	
	public int getLimit() {
		return limit;
	}
	
	public void setLimit(int limit) {
		this.limit = limit;
	}
	

	public void setBalance(int balance) {
		if(-limit <= Math.abs(balance)) {
			this.balance = balance;
		}else {
			System.out.println("한도 부족으로 출금할 수 없습니다.");
		}
	}
}
