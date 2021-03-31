

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_2839 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		int[] dp = new int[n+1];
		Arrays.fill(dp, 987654321);
		if(n == 3) {
			System.out.println(1);
			return;
		}
		else if(n == 4) {
			System.out.println(-1);
			return;
		}
		dp[3] = 1;
		dp[5] = 1;
		for(int i = 6; i <= n; i++) {
			dp[i] = Math.min(dp[i-3], dp[i-5])+1;
		}
		if(dp[n] >= 987654321) System.out.println(-1);
		else System.out.println(dp[n]);
	}

}
