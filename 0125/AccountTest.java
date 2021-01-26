

public class AccountTest {

	public static void main(String[] args) {
		Account  account = new Account("111","1111",10000);
		
		System.out.println("입금 후 : "+account.deposit(3000));
		System.out.println("15000출구 후 : "+account.withdraw("2222", 150000));
		System.out.println("15000출구 후 : "+account.withdraw("1111", 150000)	);
		
		}

}
