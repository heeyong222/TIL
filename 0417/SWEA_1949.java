import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1949 {
	static int n, k, top, res;
	static int[][] map;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static boolean[][] v;
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb;
		int T = Integer.parseInt(in.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			res = 0;
			top = 0;
			st = new StringTokenizer(in.readLine());
			n = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			map = new int[n][n];
			for(int i = 0; i < n; i++) {
				st = new StringTokenizer(in.readLine());
				for(int j = 0; j < n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					top = top < map[i][j] ? map[i][j] : top;
				}
			}
			
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					if(map[i][j] == top) {
//						System.out.println("# I :"+i+" J : "+j);
						v = new boolean[n][n];
						v[i][j] = true;
						dfs(i,j,0,1);
					}
				}
			}
			sb = new StringBuilder();
			sb.append("#" + tc + " "+ res);
			System.out.println(sb);
			
		}
	}
	public static boolean isvalid(int x, int y) {
		if(x < 0 || y < 0 || x >= n || y >= n) return false;
		return true;
	}
	public static void dfs(int x, int y, int breakcnt, int length) {

		res = Math.max(res, length);
		
		for(int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(isvalid(nx,ny) && !v[nx][ny]) {
				if(map[x][y] > map[nx][ny]) {
					v[nx][ny] = true;
					dfs(nx,ny,breakcnt,length+1);
					v[nx][ny] = false;
				}else if(map[x][y] <= map[nx][ny] && breakcnt == 0) {
					int tmpheight = map[nx][ny] - map[x][y];
					if(tmpheight < k) {
						v[nx][ny] = true;
						map[nx][ny] -= (tmpheight+1);
						dfs(nx,ny,breakcnt+1,length+1);
						map[nx][ny] += (tmpheight+1);
						v[nx][ny] = false;
					}
				}
			}
		}

	}

}
