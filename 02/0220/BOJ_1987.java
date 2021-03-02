

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1987 {
	static int r;
	static int c;
	static int[] nx = {-1,0,1,0};
	static int[] ny = {0,-1,0,1};
	static char[][] map;
//	static boolean[][] visited;
	static boolean[] alpha;
	static int answer;
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(in.readLine(), " ");
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		map = new char[r][c];
//		visited = new boolean[r][c];
		alpha = new boolean[26];
		for(int i = 0; i < r; i++) {
			String str = in.readLine();
			for(int j = 0; j < c; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		answer = 0;
		alpha[map[0][0]-'A'] = true;
		bt(0,0,1);
		System.out.println(answer);
		
	}
	public static void bt(int x, int y, int cnt) {
		
		if(cnt > answer) {
			answer = cnt;	
		}else if(cnt == 26) {
			return;
		}
//		for(int i = 0 ; i < 26; i++) {
//			System.out.print(alpha[i]+" ");
//		}
//		System.out.println();
		for(int i = 0; i < 4; i++) {
			int nextx = x+nx[i];
			int nexty = y+ny[i];
			
			if(nextx >= 0 && nextx < r && nexty >= 0 && nexty < c) {
				
				if(alpha[map[nextx][nexty]-'A'] == false) {
			
					alpha[map[nextx][nexty]-'A'] = true;
					bt(nextx, nexty, cnt+1);
					alpha[map[nextx][nexty]-'A'] = false;
				}
			}
		}
		
			
	}

}
