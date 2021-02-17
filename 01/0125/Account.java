

/**
 * 입출금만 가능한 클래스
 * @author laru1
 *
 */
public class Account {
	private String no;
	private String password;
	protected int balance;//부모자식간에는 접근가능
	
	public Account() {}
	public Account(String no, String password, int balance) {
		this.no = no;
		this.password = password;
		this.balance = balance;
	}
	/* 입금 기능 */
	public int deposit(int amount) {
		return this.balance += amount;
	}
	/* 출금기능 */
	public int withdraw(String password, int amount) {
		if(isAvailable(password) && balance >= amount) {
			setBalance(balance-amount);
			this.balance -= amount;
		}
		return balance;
	}
	
	protected boolean isAvailable(String password) {
		if(password.equals(this.password))
			return true;
		return false;
	}
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
        if(balance>0) {
            this.balance = balance;
        }else {
            System.out.println("계좌에 잔액이 부족합니다.");
        }
    }
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Account [no=").append(no).append(", password=").append(password).append(", balance=")
				.append(balance).append("]");
		return builder.toString();
	}
	
	
}
