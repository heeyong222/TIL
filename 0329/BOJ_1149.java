package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1149 {
	static int[][] map;
	static int[][] dp;
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int n = Integer.parseInt(in.readLine());
		map = new int[n+1][3];
		dp = new int[n+1][3];
		for(int i = 1; i <= n; i++) {
			st = new StringTokenizer(in.readLine());
			map[i][0] = Integer.parseInt(st.nextToken());
			map[i][1] = Integer.parseInt(st.nextToken());
			map[i][2] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 1; i <= n; i++) {
			dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + map[i][0];
			dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + map[i][1];
			dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + map[i][2];
		}
		
		System.out.println(Math.min(Math.min(dp[n][0], dp[n][1]), dp[n][2]));
		
	}

}
