package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16236 {
	static int[][] map;
	static boolean[][] v;
	static int N, sx, sy;
	static int[] nx = {0, -1, 1, 0};
	static int[] ny = {-1, 0, 0, 1};
	static int res;
	static Queue<pos> q;
	static int ssize = 2;
	static int eatcnt;
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(in.readLine());
		map = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 9) {
					sx = i;
					sy = j;
				}
			}
		}
		
		res = 0;
		bfs();
		q = new LinkedList<pos>();
		q.offer(new pos(sx, sy));
		
			
		
		
		
	}
	
	public static void bfs() {
		PriorityQueue<pos> pq = new PriorityQueue<pos>();
		while(true) {
			
		}
	}
	public static void find (PriorityQueue<pos> pq) {
		v = new boolean[N][N];
		int curx = sx;
		int cury = sy;
		int ecnt = eatcnt;
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {curx, cury, 0});
		v[curx][cury] = true;
		while(!q.isEmpty()) {
			int size = q.size();
			for(int i = 0; i < size; i++) {
				int[] pos = q.poll();
				
			}
		}
	}
	
	public static class pos implements Comparable<pos>{
		int x;
		int y;
		public pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
		public int compareTo(pos o) {
			if(this.x == o.x) {
				return Integer.compare(this.y,  o.y);
			}
			
			return Integer.compare(this.x, o.x);
		}
		
	}

}
