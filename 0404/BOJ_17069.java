package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17069 {
	static int n;
	static int[][] map;
	static long[][][] dp;
	static long res;
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(in.readLine());
		map = new int[n+1][n+1];
		dp = new long[n+1][n+1][3];
		for(int i = 1; i <= n; i++) {
			st = new StringTokenizer(in.readLine());
			for(int j = 1; j <= n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		//방향 : 가 세 대 0 1 2
		dp[1][2][0] = 1;
		for(int i = 1; i < n+1; i++) {
			for(int j = 1; j < n+1; j++) {
				if(j < n && map[i][j+1] == 0) dp[i][j+1][0] += dp[i][j][0] + dp[i][j][2];
				if(i < n && map[i+1][j] == 0) dp[i+1][j][1] += dp[i][j][1] + dp[i][j][2];
				if(i < n && j < n && map[i+1][j+1] == 0 && map[i][j+1] == 0 && map[i+1][j] == 0) dp[i+1][j+1][2] += dp[i][j][0] + dp[i][j][1] + dp[i][j][2];
			}
		}
		for(long i : dp[n][n]) res += i;
		System.out.println(res);
	}

}
