import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
class pos{
	int x;
	int y;
	public pos(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
public class SWEA_1249 {
	static int[][] map;
	static int[][] count;
	static boolean[][] v;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int gx, gy, n, res;
	static Queue<pos> q;
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for(int tc = 1; tc <= T; tc++) {
			res = 0;
			n = Integer.parseInt(in.readLine());
			map = new int[n][n];
			v = new boolean[n][n];
			gx = gy = n-1;
			res = Integer.MAX_VALUE;
			for(int j = 0; j < n; j++) {
				String s = in.readLine();
				for(int k = 0; k < n; k++) {
					map[j][k] = s.charAt(k)-'0';
				}
			}
			count = new int[n][n];
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					count[i][j] = Integer.MAX_VALUE;
				}
			}
			count[0][0] = 0;
			q = new LinkedList<>();
			v[0][0] = true;
			q.offer(new pos(0,0));
			bfs(0,0);
			System.out.println("#"+tc+" "+res);
		}
	}
	public static void bfs(int x, int y) {
		while(!q.isEmpty()) {
			pos p = q.poll();
			int nx = p.x;
			int ny = p.y;
			if(nx == gx && ny == gy && res > count[nx][ny]) res = count[nx][ny];
			
			if(res <= map[nx][ny]) continue;
			
			for(int i = 0; i < 4; i++) {
				int nextx = nx+dx[i];
				int nexty = ny+dy[i];
				if(nextx >= 0 && nexty >= 0 && nextx < n && nexty < n) {
					if(!v[nextx][nexty] || count[nextx][nexty] > count[nx][ny]+map[nextx][nexty]) {
						v[nextx][nexty] = true;
						count[nextx][nexty] = count[nx][ny]+map[nextx][nexty];
						q.offer(new pos(nextx, nexty));
					}
				}
			}
		}
	}

}
