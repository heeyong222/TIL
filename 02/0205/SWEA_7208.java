

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_7208{
	static int N;
	static int[] color;
	static int[] ccolor;
	static int[][] map;
	static int min;
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(in.readLine());
		for(int tc = 1; tc <= T; tc++) {
			min = 99999;
			N = Integer.parseInt(in.readLine());
			color = new int[N];
			st = new StringTokenizer(in.readLine(), " ");
			for(int i = 0; i < N; i++) {
				color[i] = Integer.parseInt(st.nextToken());
			}
//			for(int i = 0; i < N; i++) {
//				System.out.print(color[i]+" ");
//			}
//			System.out.println();
			ccolor = new int[N];
			map = new int[N][N];
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(in.readLine(), " ");
				for(int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			permutation(0);
			System.out.println("#"+tc+" "+min);
			
		}

	}
	
	public static void permutation(int idx) {
		if(idx == N) {
//			for(int i = 0; i < N; i++) {
//				System.out.print(ccolor[i]+" ");
//			}
//			System.out.println();
			if(check(ccolor)) {
				int change = 0;
				for(int i = 0; i < N; i++) {
					if(color[i] != ccolor[i]) {
						change++;
					}
				}
//				System.out.println("min : "+min+"change : "+change);
				min = Math.min(change, min);			
			}
			return;
		}
		for(int i = 1; i<=4; i++) {
			ccolor[idx] = i;
			permutation(idx+1);
		}
		
	}
	
	public static boolean check(int[] c) {
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(map[i][j] == 1) {
					if(c[i] == c[j])
						return false;
				}
			}
		}
		return true;
	}

}
