

public class FiboTest {
	
	public static long fiboRec(int n) {
		if(n <= 1) return n;
		return fiboRec(n-1)+fiboRec(n-2);
		
	}
	
	static long memo[];
	public static long fiboMemo(int n) {
		if(n <= 1) return n;
		if(memo[n-1] == 0) memo[n-1] = fiboMemo(n-1);
		if(memo[n-2] == 0) memo[n-2] = fiboMemo(n-2);
		return memo[n-1] + memo[n-2];
	}
	
	public static long fiboDp(int n) {
		memo[1] = 1;
		for(int i = 2; i <= n; i++) {
			memo[i] = memo[i-1]+memo[i-2];
		}
		return memo[n];
	}
	public static void main(String[] args) {
		int n = 45;
		long start = System.currentTimeMillis();
		System.out.println(fiboRec(n));
		long end = System.currentTimeMillis();
		System.out.printf("Recursive : %dms \n", end-start);
		
		memo = new long[n+1];
		start = System.currentTimeMillis();
		System.out.println(fiboMemo(n));
		end = System.currentTimeMillis();
		System.out.printf("DP : %dms \n", end-start);
	}

}
