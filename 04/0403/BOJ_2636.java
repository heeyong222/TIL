package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2636 {
	static int n, m;
	static int[][] map;
	static int time, res;
	static ArrayList<pos> list;
	static Queue<pos> q;
	static boolean[][] v;
	static int[] nx = {0,0,-1,1};
	static int[] ny = {-1,1,0,0};
	static class pos{
		int x, y;
		public pos(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(in.readLine());
			for(int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		list = new ArrayList<pos>();
		while(!check()) {
			v = new boolean[n][m];
			bfs();
			time++;
			res = list.size();
			for(pos p : list) {
				map[p.x][p.y] = 0;
			}
//			for(int i = 0; i < n; i++) {
//				for(int j = 0; j < m; j++) {
//					System.out.print(map[i][j]+" ");
//				}
//				System.out.println();
//			}
			list.clear();
			
		}
		System.out.println(time);
		System.out.println(res);

	}
	
	public static boolean check() {
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(map[i][j] == 1) return false;
			}
		}
		return true;
	}
	public static void bfs() {
		q = new LinkedList<pos>();
		q.add(new pos(0,0));
		while(!q.isEmpty()) {
			pos p = q.poll();
			
			for(int i = 0; i < 4; i++) {
				int nextx = p.x + nx[i];
				int nexty = p.y + ny[i];
				if(nextx >= 0 && nexty >= 0 && nextx < n && nexty < m && !v[nextx][nexty]) {
					if(map[nextx][nexty] == 0) {
						v[nextx][nexty] = true;
						q.offer(new pos(nextx,nexty));						
					}else if(map[nextx][nexty] == 1) {
						v[nextx][nexty] = true;
						list.add(new pos(nextx, nexty));
					}
				}
			}
			
		}
	}

}
