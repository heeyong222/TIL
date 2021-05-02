import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class SWEA_1868 {
	static int n, res;
	static char[][] map;
	static int dx[] = {-1,-1,-1,0,1,1,1,0};
	static int dy[] = {-1,0,1,1,1,0,-1,-1};
	static boolean[][] v;
	static ArrayList<pos> list;
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = null;
		int T = Integer.parseInt(in.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			res = 0;
			n = Integer.parseInt(in.readLine());
			map = new char[n][n];
			v = new boolean[n][n];
			for(int i = 0; i < n; i++) {
				String str = in.readLine();
				for(int j = 0; j < n; j++) {
					map[i][j] = str.charAt(j);
				}
			}
			list = new ArrayList<pos>();
			
			
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					if(checkcnt(i,j) == 0) list.add(new pos(i,j));
				}
			}
			
			//0 인부분 먼저 제거
			for(int i = 0; i < list.size(); i++) {
				pos p = list.get(i);
				if(map[p.x][p.y] == '.') bfs(p.x, p.y);
			}
			//나머지 처리
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					if(map[i][j] == '.') bfs(i,j);

				}
			}
			
			sb = new StringBuilder();
			sb.append("#" + tc + " " + res);
			System.out.println(sb);
			
		}
	}
	
	public static boolean isvalid(int x, int y) {
		if(x < 0 || y < 0 || x >= n || y >= n) return false;
		return true;
	}
	
	public static void bfs(int x, int y) {
		int tmp = checkcnt(x,y);
		if(tmp != 0) {
			map[x][y] = (char)(tmp+'0');
			res++;
			return;
		}
		Queue<pos> q = new LinkedList<pos>();
		q.offer(new pos(x,y));
		map[x][y] = '0';
		v[x][y] = true;
		res++;
		while(!q.isEmpty()) {
			pos p = q.poll();
			x = p.x;
			y = p.y;
			for(int i = 0; i < 8; i++) {
				int nx = x+dx[i];
				int ny = y+dy[i];
				if(!isvalid(nx,ny) || v[nx][ny]) continue;
				if(map[nx][ny] == '*') continue;
				tmp = checkcnt(nx,ny);

				if(tmp == 0) {
					map[nx][ny] = '0';
					v[nx][ny] = true;
					q.offer(new pos(nx,ny));
				}else {
					map[nx][ny] = (char)(tmp+'0');
					v[nx][ny] = true;
				}
			}
			
		}
	}
	public static int checkcnt(int x, int y) {
		int cnt = 0;
		for(int i = 0; i < 8; i++) {
			
			int nx = x+dx[i];
			int ny = y+dy[i];
			if(!isvalid(nx,ny)) continue;
			if(map[nx][ny] == '*') cnt++;
		}
		return cnt;
	}
	public static class pos{
		int x,y;
		public pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
