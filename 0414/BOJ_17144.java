import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17144 {
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int r, c, t, res;
	static int[][] map;
	static int[][] tmpmap;
	static int cir1, cir2;
	public static void main(String[] args)throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		t = Integer.parseInt(st.nextToken());
		map = new int[r][c];
		
		for(int i = 0; i < r; i++) {
			st = new StringTokenizer(in.readLine());
			for(int j = 0; j < c; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == -1) cir2 = i;
			}
		}
		cir1 = cir2-1;
		for(int tc = 0; tc < t; tc++) {
			spread();
			rotate();
			map[cir1][0] = map[cir2][0] = -1;
//			for(int i = 0; i < r; i++) {
//				for(int j = 0; j < c; j++) {
//					System.out.print(map[i][j]+" ");
//					
//				}
//				System.out.println();
//			}
		}
		
		for(int i = 0; i < r; i++) {
			for(int j = 0; j < c; j++) {
//				System.out.print(map[i][j]+" ");
				if(map[i][j] != -1) res += map[i][j];
			}
//			System.out.println();
		}
		System.out.println(res);
		
	}
	//확산 함수
	public static void bfs(int x, int y) {
		int cnt = 0;
		int center = map[x][y];
		for(int i = 0; i < 4; i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			if(nx >= 0 && ny >= 0 && nx < r && ny < c && map[nx][ny] != -1) {
				cnt++;
				tmpmap[nx][ny] += center / 5;
			}
		}
		
		tmpmap[x][y] += map[x][y] - (center/5)*cnt;
		
		
	}
	//1.
	public static void spread() {
		tmpmap = new int[r][c];
		for(int i = 0; i < r; i++) {
			for(int j = 0; j < c; j++) {
				if(map[i][j] != -1 && map[i][j] != 0) {
					bfs(i, j);
				}
			}
		}
		for(int i = 0; i < r; i++) {
			for(int j = 0; j < c; j++) {
				map[i][j] = tmpmap[i][j];
			}
		}
//		System.out.println("@@@@@@@@@@@@@@@@@@");
//		for(int i = 0; i < r; i++) {
//			for(int j = 0; j < c; j++) {
//				System.out.print(map[i][j]+" ");
//				
//			}
//			System.out.println();
//		}
//		System.out.println("##################");
	}
	//2.
	public static void rotate() {
		// 위쪽 공기청정기 회전
		for(int i = cir1 -1; i > 0; i--) {
			map[i][0] = map[i-1][0];
		}
		for(int i = 0; i < c-1; i++) {
			map[0][i] = map[0][i+1];
		}
		for(int i = 0; i < cir1; i++) {
			map[i][c-1] = map[i+1][c-1];
		}
		for(int i = c-1; i > 0; i--) {
			map[cir1][i] = map[cir1][i-1];
		}
		map[cir1][1] = 0;
		
		//아래쪽 공기청정기 회전
		for(int i = cir2+1; i < r-1; i++) {
			map[i][0] = map[i+1][0];
		}
		for(int i = 0; i < c-1; i++) {
			map[r-1][i] = map[r-1][i+1];
		}
		for(int i = r-1; i > cir2; i--) {
			map[i][c-1] = map[i-1][c-1];
		}
		for(int i = c-1; i > 0; i--) {
			map[cir2][i] = map[cir2][i-1];
		}
		map[cir2][1] = 0;
	}

}
