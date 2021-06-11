import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class SWEA_1227_2 {
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static boolean res;
	static boolean[][] v;
	static int sx, sy, gx, gy;
	static int[][] map;
	static Queue<pos> q;
	public static class pos{
		int x,y;
		public pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	public static void main(String[] args)throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb;
		for(int tc = 1; tc <= 10; tc++) {
			sb = new StringBuilder();
			v = new boolean[100][100];
			map = new int[100][100];
			in.readLine();
			// map 입력
			for(int i = 0; i < 100; i++) {
				String s = in.readLine();
				for(int j = 0; j < 100; j++) {
					map[i][j] = s.charAt(j) - '0';
					if(map[i][j] == 2) {
						sx = i; sy = j;
					}
					if(map[i][j] == 3) {
						gx = i; gy = j;
					}
				}
			}
			
			q = new LinkedList<pos>();
			q.add(new pos(sx, sy));
			v[sx][sy] = true;
			res = bfs();
			sb.append("#" + tc + " ");
			if(res) sb.append("1");
			else sb.append("0");
			
			System.out.println(sb);
			
		}
	}
	public static boolean isvalid(int x, int y) {
		if(x < 0 || y < 0 || x >= 100 || y >= 100) return false;
		if(map[x][y] == 1) return false;
		return true;
	}
	
	public static boolean bfs() {
		while(!q.isEmpty()) {
			pos p = q.poll();
			for(int i = 0; i < 4; i++) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];
				
				if(!isvalid(nx, ny)) continue;
				if(v[nx][ny]) continue;
				if(map[nx][ny] == 3) return true;
				
				q.add(new pos(nx, ny));
				v[nx][ny] = true;
			}
		}
		
		return false;
	}

}
