package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_9205 {
	static int n;
	static int hx, hy;
	static String res;
	static boolean[][] map;
	static class pos{
		int x;
		int y;
		public pos(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
	}
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int t = Integer.parseInt(in.readLine());
		
		for(int tc = 1; tc <= t; tc++) {
			n = Integer.parseInt(in.readLine());
			ArrayList<pos> list = new ArrayList<pos>();
			for(int i = 0; i < n+2; i++) {
				st = new StringTokenizer(in.readLine());
				list.add(new pos(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
			}
			map = new boolean[n+2][n+2];
			// 집- 각편의점- 페스티벌 갈수 있는지
			for(int i = 0; i < n+2; i++) {
				for(int j = i+1; j < n+2; j++) {
					if(Math.abs(list.get(i).x-list.get(j).x)+Math.abs(list.get(i).y - list.get(j).y) <= 1000) {
						map[i][j] = true;
						map[j][i] = true;
					}
				}
			}
			for(int k = 0; k < n+2; k++) {
				for(int i = 0; i < n+2; i++) {
					for(int j = 0; j < n+2; j++) {
						if(map[i][k] && map[k][j]) map[i][j] = true;
					}
				}
			}
			//집- 페스티벌이므로 좌표는 0, n+1
			if(map[0][n+1]) res="happy";
			else res = "sad";
			
			System.out.println(res);
		}
	}

}
