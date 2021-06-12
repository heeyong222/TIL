import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	static int t,n, m, res, sx, sy, gx, gy, cnt;
	static char[][] map;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static boolean[][][] v;
	static Queue<pos> q;
	public static void main(String[] args) throws IOException{
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb;
		t = Integer.parseInt(in.readLine());
		for(int tc = 1; tc <= t; tc++) {
			st = new StringTokenizer(in.readLine());
			
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			
			map = new char[n][m];
			
			v = new boolean[n][m][256];
			st = new StringTokenizer(in.readLine());
			sx = Integer.parseInt(st.nextToken());
			sy = Integer.parseInt(st.nextToken());
			gx = Integer.parseInt(st.nextToken());
			gy = Integer.parseInt(st.nextToken());
			for(int i = 0; i < n; i++) {
				st = new StringTokenizer(in.readLine());
				for(int j = 0; j < m; j++) {
					map[i][j] = st.nextToken().charAt(0);
				}
			}
			
			q = new LinkedList<pos>();
			q.offer(new pos(sx,sy,0, 0));
			v[sx][sy][0] = true;
			sb = new StringBuilder();
			sb.append("#" + tc + " ");
			if(bfs()) {
				sb.append(res+1);
			}
			else {
				sb.append(-1);
			}
			System.out.println(sb);
		}
		
	}

	public static boolean isvalid(int x, int y) {
		if(x < 0 || y < 0 || x >= n || y >= m) return false;
		return true;
	}
	public static int newtool(int curval, char newtool) {
		int tmp = curval | (1<<(newtool -'A'));
		return tmp;
	}
	
	public static boolean havetool(int curval, char trap) {
		if(trap == '|') {
//			System.out.println("curval : " + curval + " 현재 l 값 : "+ (1 << ('H'-'A')));
			if((curval & (1 << ('H'-'A'))) == 0) {
				return false;
			}
			return true;
		}else {
//			System.out.println("curval : " + curval +" 현재 # 값 : "+ (1 << ('C'-'A')));
			if((curval & (1 << ('C'-'A'))) == 0) {
				return false;
			}
			return true;
		}
		
	}
	
	public static boolean bfs() {
		while(!q.isEmpty()) {
			
			pos p = q.poll();
			
			for(int i = 0; i < 4; i++) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];
//				System.out.println("nx : "+ nx + " ny : "+ ny + " key : "+p.tools);
				if(!isvalid(nx,ny)) continue;
				if(v[nx][ny][p.tools]) continue;
				if(nx == gx && ny == gy) {
					res = p.curcnt;
					return true;
				}else if(map[nx][ny] == '#') {
					
					if(havetool(p.tools, map[nx][ny])) {
						q.offer(new pos(nx, ny, p.tools, p.curcnt + 1));
						v[nx][ny][p.tools] = true;
					}
				}else if(map[nx][ny] == '|') {
					if(havetool(p.tools, map[nx][ny])) {
						q.offer(new pos(nx, ny, p.tools, p.curcnt + 1));
						v[nx][ny][p.tools] = true;
					}
				}else if(map[nx][ny] == 'H' || map[nx][ny] == 'C') {
					int tmp = newtool(p.tools, map[nx][ny]);
					q.offer(new pos(nx, ny, tmp, p.curcnt + 1));
					v[nx][ny][tmp] = true;
					
				}else {
					q.offer(new pos(nx, ny, p.tools, p.curcnt + 1));
					v[nx][ny][p.tools] = true;
					
				}
				
			}
			
		}
		return false;
	}
	public static class pos{
		int x, y, tools, curcnt;
		public pos(int x, int y, int tools, int curcnt) {
			this.x = x;
			this.y = y;
			this.tools = tools;
			this.curcnt = curcnt;
		}
	}

}
