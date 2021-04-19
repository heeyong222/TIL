import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_2105 {
	static int n, res, sx, sy;
	static int[][] map;
	static int[] dx = {1,1,-1,-1};
	static int[] dy = {1,-1,-1,1};
	static boolean[][] v;
	static boolean[] deserts = new boolean[101];
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb;
		int T = Integer.parseInt(in.readLine());
		for(int tc = 1; tc <= T; tc++) {
			res = 0;
			sb = new StringBuilder();
			n = Integer.parseInt(in.readLine());
			map = new int[n][n];
			v = new boolean[n][n];
			for(int i = 0; i < n; i++) {
				st = new StringTokenizer(in.readLine());
				for(int j = 0; j < n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			
			for(int i = 0; i < n-1; i++) {
				for(int j = 0; j < n-1; j++) {
					sx = i;
					sy = j;// 시작점 설정
					deserts[map[i][j]] = true;
					dfs(i, j, 0, 0);
					deserts[map[i][j]] = false;
				}
			}
			if(res == 0) res = -1;
			sb.append("#"+tc+" "+res);
			System.out.println(sb);
		}
	}
	public static void dfs(int x, int y, int dir, int cnt) {
		if(x == sx && y == sy && cnt > 1) {
			// 원래위치로 돌아온경우
			res = Math.max(res, cnt);
			return;
		}
		for(int i = 0; i < 2; i++) {
			//현재 방향 그대로 가거나 꺾거나 2가지
			if(dir + i >= 4) break;
			
			int nx = x+dx[dir+i];
			int ny = y+dy[dir+i];
			if(nx <  0 || ny < 0 || nx >= n || ny >= n) continue;
			if(!v[nx][ny] && !deserts[map[nx][ny]]) {
				deserts[map[nx][ny]] = true;
				v[nx][ny] = true;
				dfs(nx, ny, dir+i, cnt+1);
				v[nx][ny] = false;
				deserts[map[nx][ny]] = false;
			}else if(nx == sx && ny == sy) {
				dfs(nx, ny, dir+i, cnt+1);
			}
		}
		
	}
}
