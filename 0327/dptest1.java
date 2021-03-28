import java.util.Scanner;


public class dptest1 {
	static int[] memo;
	static int n;
	public static int dp(int x) {
		for(int i = 2; i < x; i++) {
			
			memo[i] = memo[i-1]+memo[i-2];
		}
		return memo[x-1];
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		memo = new int[n];
		memo[0] = 2;
		memo[1] = 3;
		System.out.println(dp(n));
		

	}

}
