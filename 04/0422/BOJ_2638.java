import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2638 {
	static int n, m, res;
	static int[][] map;
	static boolean[][] v;
	static int[][] cntmap;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static Queue<pos> q;
	static class pos{
		int x,y;
		public pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(in.readLine());
			for(int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		while(check()) {
			pos p = findzero();
			q = new LinkedList<pos>();
			q.add(p);
			bfs();
			erase();
			res++;
		}
		System.out.println(res);
	}
	public static void erase() {
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(cntmap[i][j] >= 2) map[i][j] = 0;
			}
		}
	}
	public static boolean isvalid(int x, int y) {
		if(x < 0 || y < 0 || x >= n || y >= m) return false;
		return true;
	}
	public static void bfs() {
		v = new boolean[n][m];
		cntmap = new int[n][m];
		while(!q.isEmpty()) {
			pos p = q.poll();
			int x = p.x;
			int y = p.y;
			for(int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if(!isvalid(nx,ny) || v[nx][ny]) continue;
				
				if(map[nx][ny] == 1) {
					cntmap[nx][ny] += 1;
					continue;
				}
				v[nx][ny] = true;
				q.add(new pos(nx,ny));
			}
		}
	}
	public static pos findzero() {
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(map[i][j] == 0) return new pos(i,j);
			}
		}
		return null;
	}
	public static boolean check() {
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(map[i][j] == 1) return true;
			}
		}
		return false;
	}

}
