

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class SWEA_2805 {
	static int[][] map;
	
	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for(int tc = 0; tc < T; tc++) {
			int N = Integer.parseInt(in.readLine());
			map = new int[N][N];
			int result = 0;
			for(int n = 0; n < N; n++) {
				String s = in.readLine();
				for(int m = 0; m < N; m++) {
					map[n][m] = s.charAt(m)-'0';
				}			
			}
//			for(int i = 0; i < N; i++) {
//				for(int j = 0; j < N; j++) {
//					System.out.print(map[i][j]+" ");
//				}
//				System.out.println();
//			}
			
			for(int i = 0; i < N/2 ; i++) {
				for(int j = N/2-i; j<=N/2+i;j++) {
					result += map[i][j];
//					System.out.println(map[i][j]);
				}
			}	
			for(int i = N/2; i>=0; i--) {
				for(int j = N/2-i; j <= N/2+i; j++) {
					result += map[N-i-1][j];
//					System.out.println(map[N-i-1][j]);
				}
			}
			
			System.out.println("#"+(tc+1)+" "+result);
			
		}
		
		
	}
}
