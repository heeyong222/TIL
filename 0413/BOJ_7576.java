
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class BOJ_7576 {
	static Queue<pos> q;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int c = Integer.parseInt(st.nextToken());//가로
		int r = Integer.parseInt(st.nextToken());//세로
		q = new LinkedList<pos>();
		int[][] map = new int[r][c];
		for(int i = 0; i < r; i++) {
			st = new StringTokenizer(in.readLine());
			for(int j = 0; j < c; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) q.add(new pos(i,j));
			}
		}
		System.out.println(bfs(r,c,map));
	}
	
	public static int bfs(int m, int n, int[][] map) {
		int day = 0;
		
		while(!q.isEmpty()) {
			day += 1;
			int l = q.size();
			for(int i = 0; i < l; i++) {
				pos p = q.poll();
				int x = p.x;
				int y = p.y;
				for(int d = 0; d < 4; d++) {
					int nx = x+dx[d];
					int ny = y+dy[d];
					
					if(nx >= 0 && ny >= 0 && nx < m && ny < n && map[nx][ny] == 0) {
						map[nx][ny] = map[x][y] + 1;
						q.add(new pos(nx, ny));
					}
				}
			}
		}
		
		for(int i = 0 ; i < m; i++) {
			for(int j = 0; j < n; j++) {
				if(map[i][j] == 0) return -1;
			}
		}
		
		return day-1;
	}

}
class pos{
	int x, y;
	pos(int x, int y){
		this.x = x;
		this.y = y;
	}
}