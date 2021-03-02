

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_2001 {
	
	static int[][] map;
	static int [][] pari;
	static int N;
	static int M;
	
	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(in.readLine());
		for(int tc = 1;tc<=T;tc++) {
			st = new StringTokenizer(in.readLine()," ");
			int result = 0;
			int tmp = 0;
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			map = new int[N][N];
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(in.readLine(), " ");
				for(int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			for(int i = 0; i < N; i++) {		
				for(int j = 0; j < N; j++) {
					tmp = smash(i,j,M);
//					System.out.println("tmp : "+ tmp + "result : "+result);
					if(tmp >= result)
						result = tmp;
				}
			}
			System.out.println("#"+tc+" "+result);
			
		}
		
		
		
	}
	
	public static int smash(int x, int y, int m) {
		int sum = 0;
		if(x+m > N || y+m>N)
			return 0;
		for(int i = x; i < x+m;i++) {
			for(int j = y; j < y+m; j++) {
				sum += map[i][j];
			}
		}
		return sum;
	}
}
