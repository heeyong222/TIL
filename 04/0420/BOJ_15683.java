import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_15683 {
	static int n, m, res, cctvcnt;
	static int[][] map;
	
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	static int[][] dir = {{}, {1}, {1, 3}, {0, 1}, {0, 1, 3}, {0, 1, 2, 3}};
	static ArrayList<cctv> cctvs;
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		res = Integer.MAX_VALUE;
		cctvs = new ArrayList<>();
		cctvcnt = 0;
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(in.readLine());
			for(int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				
				if(map[i][j] != 0 && map[i][j] != 6) {
					cctvcnt++;
					cctvs.add(new cctv(i, j, map[i][j]));
				}
			}
		}
		dfs(0,map);
		System.out.println(res);
		
		
	}
	public static void dfs(int idx, int[][] tmpmap) {
		if(idx == cctvcnt) {
			int count = 0;
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < m; j++) {
//					System.out.print(tmpmap[i][j]);
					if(tmpmap[i][j] == 0) count++;
				}
			}
			res = Math.min(res, count);
			return;
		}
		
		cctv c = cctvs.get(idx);
		for(int d = 0; d < 4; d++) {
			int[][] newmap = newmap(tmpmap);
			for(int i = 0; i < dir[c.type].length; i++) {
				int nx = c.x;
				int ny = c.y;
				int nd = (dir[c.type][i]-d+3)%4;
				while(true) {
					nx += dx[nd];
					ny += dy[nd];
					if(!isvalid(nx,ny) || tmpmap[nx][ny] == 6) break;
					newmap[nx][ny] = 7;
				}
			}
			dfs(idx+1, newmap);
		}
	}
	static boolean isvalid(int x, int y) {
		if(x>=0 && y>=0 && n>x && m>y) return true;
		else return false;
	}
	static int[][] newmap(int[][] tmpmap) {
		int[][] newmap = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j <m; j++) {
				newmap[i][j] = tmpmap[i][j];
			}
		}
		return newmap;
	}
	public static class cctv{
		int x;
		int y;
		int type;
		public cctv(int x, int y, int type) {
			this.x = x;
			this.y = y;
			this.type = type;
		}
	}
	

}
