


import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SWEA_1873_1{
	static int T;
	static int N;
	static int[][] farm;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(in.readLine());
		for(int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(in.readLine());
			farm = new int[N][N];
			for(int i = 0; i < N; i++) {
				String str = in.readLine();
				for(int j = 0; j < N; j++) {
					farm[i][j] = str.charAt(j)-'0';
				}
			}
			
			int sum = 0;
			for(int i = 0; i < (N-1)/2; i++) {
				sum += farm[i][(N-1)/2];
				sum += farm[N-1-i][(N-1)/2];
				for(int j = (N-1)/2-1, k = (N-1)/2+1; (j >= ((N-1)/2 - i) && k <= ((N-1)/2 + i)); j--, k++) {
					sum += farm[i][j];
					sum += farm[i][k];
					sum += farm[N-1-i][j];
					sum += farm[N-1-i][k];
				}
			}
			for(int j = 0; j < N; j++) {
				sum += farm[(N-1)/2][j];
			}
			sb.append("#").append(tc).append(" ").append(sum).append("\n");
		}
		System.out.println(sb.toString());
	}

}
