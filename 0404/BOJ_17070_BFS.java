package BOJ;
/*
N 이 15인 경우는 가능하지만
16이 들어오면 시간초과
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_17070_BFS {
	static int n;
	static int[][] map;
	static Queue<pos> q;
	static int res;
	final static int[] dx = {0,1,1};//가로, 대각선, 세로
	final static int[] dy = {1,1,0};//가로, 대각선, 세로
	static class pos{
		int x, y, way;

		public pos(int x, int y, int way) {
			super();
			this.x = x;
			this.y = y;
			this.way = way;// 현재 방향 가로 대각선 세로 0 1 2
		}
		
	}
	public static void main(String[] args)throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(in.readLine());
		map = new int[n][n];
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(in.readLine());
			for(int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		bfs();
		
		System.out.println(res);
	}
	
	public static void bfs() {
		q = new LinkedList<pos>();
		q.add(new pos(0,1,0));
		while(!q.isEmpty()) {
			pos p = q.poll();
			if(p.x == n-1 && p.y == n-1) {//끝에 도착했다면 ++
				res++;
				continue;
			}
			
			for(int i = 0; i < 3; i++) {
				if(p.way == 0 && i == 2) continue; //현재 파이파 방향이 가로, 다음 방향이 세로인경우
				if(p.way == 2 && i == 0) continue; //현재 파이프 방향이 세로, 다음 방향이 세로인경우
				int nx = p.x+dx[i];
				int ny = p.y+dy[i];
				if(i == 1) {//다음 방향이 대각선이경우
					if(nx < n && ny < n && map[nx][ny] == 0 && map[nx-1][ny] == 0 && map[nx][ny-1] == 0) 
						q.add(new pos(nx, ny, i));
				}else {
					if(nx < n && ny < n && map[nx][ny] == 0) 
						q.add(new pos(nx, ny, i));
					
				}
			}
		}
	}

}
