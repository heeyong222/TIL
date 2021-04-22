import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1194 {
	static int n, m, res, sx, sy, cnt;
	static char[][] map;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	//abcdef 2^6 64가지
	static boolean[][][] v;
	static Queue<pos> q;
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new char[n][m];
		v = new boolean[n][m][64];
		for(int i = 0; i < n; i++) {
			String str = in.readLine();
			for(int j = 0; j < m; j++) {
				map[i][j] = str.charAt(j);
				if(map[i][j] == '0') {
					sx = i;
					sy = j;
				}
			}
		}
		q = new LinkedList<pos>();
		q.offer(new pos(sx,sy,0, 0));
		v[sx][sy][0] = true;
		if(bfs()) System.out.println(res+1);
		else System.out.println(-1);
		
	}

	public static boolean isvalid(int x, int y) {
		if(x < 0 || y < 0 || x >= n || y >= m) return false;
		return true;
	}
	public static int newkey(int curkey, char nkey) {
		int tmp = curkey | (1<<(nkey -'a'));
		return tmp;
	}
	
	public static boolean havekey(int curkey, char door) {
//		System.out.println(curkey + " "+ door);
//		System.out.println((1 << (door-'A')));
		if((curkey & (1 << (door-'A'))) == 0) return false;
		return true;
	}
	
	public static boolean bfs() {
		while(!q.isEmpty()) {
			
			pos p = q.poll();
			
			for(int i = 0; i < 4; i++) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];
				
				if(!isvalid(nx,ny)) continue;
				if(v[nx][ny][p.key] || map[nx][ny] == '#') continue;
				
				if(map[nx][ny] == '1') {
					res = p.curcnt;
					return true;
				}else if(map[nx][ny] >= 'a' && map[nx][ny] <= 'f') {
					int tmp = newkey(p.key, map[nx][ny]);
					q.offer(new pos(nx, ny, tmp, p.curcnt + 1));
					
					v[nx][ny][tmp] = true;
				}else if(map[nx][ny] >= 'A' && map[nx][ny] <= 'F') {
					if(havekey(p.key, map[nx][ny])) {
						q.offer(new pos(nx, ny, p.key, p.curcnt + 1));
						v[nx][ny][p.key] = true;
						
					}
				}else {
					q.offer(new pos(nx, ny, p.key, p.curcnt + 1));
					v[nx][ny][p.key] = true;
					
				}
				
			}
			
		}
		return false;
	}
	public static class pos{
		int x, y, key, curcnt;
		public pos(int x, int y, int key, int curcnt) {
			this.x = x;
			this.y = y;
			this.key = key;
			this.curcnt = curcnt;
		}
	}

}
