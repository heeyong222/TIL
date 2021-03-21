package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14889 {
	static int N;
	static int[][] map;
	static boolean[] v;
	static int res;
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		res = Integer.MAX_VALUE;
		N = Integer.parseInt(in.readLine());
		map = new int[N][N];
		v = new boolean[N];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
			
		}
		
		c(0,0);
		System.out.println(res);

	}
	
	public static void c(int idx, int start) {
		if(start == N/2) {
			int s = 0;
			int l = 0;
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(v[i] && v[j]) s += map[i][j];
					if(!v[i] && !v[j]) l += map[i][j];
				}
			}

			res = Math.min(res, Math.abs(s-l));
		}
		
		for(int i = idx; i < N; i++) {
			if(!v[i]) {
				v[i] = true;
				c(i+1, start+1);
				v[i] = false;
			}
		}
	}

}
