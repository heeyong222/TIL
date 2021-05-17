import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class SWEA_5656 {
	static int n, w, h, res;
	static int[] pick;
	static int[][] map;
	static int[][] tmpmap;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb;
		int T = Integer.parseInt(in.readLine());
		for(int tc = 1; tc <= T; tc++) {
			sb = new StringBuilder();
			st = new StringTokenizer(in.readLine());
			n = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			map = new int[h][w];
			tmpmap = new int[h][w];
			pick = new int[n];
			for(int i = 0; i < h; i++) {
				st = new StringTokenizer(in.readLine());
				for(int j = 0; j < w; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			res = Integer.MAX_VALUE;
			for(int i = 0; i < w; i++) {
				pick[0] = i;
				comb(i, 0);
			}
			
			System.out.println("#"+ tc+" "+ res);
			
		}
	}
	
	public static void comb(int start, int idx) {
		if(idx == n-1) {
			initmap();
			for(int i = 0; i < n; i++) {
				drop(pick[i]);
				fall();
				
			}
			res = Math.min(res,  cal());
			return;
		}
		for(int i = 0; i < w; i++) {
			pick[idx+1] = i;
			comb(i, idx+1);
		}
	}
	public static int cal() {
		int sum = 0;
		for(int i=0; i<h; i++) {
			for(int j=0; j<w; j++) {
				if(tmpmap[i][j] != 0) sum++; 
			}
		}
		return sum;
	}
	public static void drop(int col) {
		for(int i=0; i<h; i++) {
			if(tmpmap[i][col] > 0) {
				bomb(new pos(i, col));
				break;
			}
		}
	}
	public static void fall() {
		int[][] a = new int[h][w];
		
		int row = h-1;
		
		for(int i=0; i<w; i++) {
			row = h-1;
			Stack<Integer> s = new Stack<Integer>();
			for(int j=0; j<h; j++) {
				if(tmpmap[j][i] != 0) s.add(tmpmap[j][i]);
			}
			while(!s.isEmpty()) {
				a[row--][i] = s.pop();
			}
		}
		
		for(int i=0; i<h; i++) {
			for(int j=0; j<w; j++) {
				tmpmap[i][j] = a[i][j];
			}
		}
	}
	public static void initmap() {
		for(int i=0; i<h; i++) {
			for(int j=0; j<w; j++) {
				tmpmap[i][j] = map[i][j];
			}
		}
	}
	public static void bomb(pos p) {
		Queue<pos> queue = new LinkedList<pos>();
		queue.offer(new pos(p.x, p.y));
		
		while(!queue.isEmpty()) {
			pos pp = queue.poll();
			int temp = tmpmap[pp.x][pp.y];
			tmpmap[pp.x][pp.y] = 0;
			for(int i=0; i<4; i++) {
				for(int j=0; j<temp; j++) {
					int nx = pp.x+dx[i]*j;
					int ny = pp.y+dy[i]*j;
					
					if(valid(nx, ny) && tmpmap[nx][ny] > 0) {
						queue.offer(new pos(nx, ny));
					}
				}
			}
		}
	}
	public static boolean valid(int x, int y) {
		if(x>=0 && x < h && y>=0 && y<w) return true;
		else return false;
	}
	public static class pos {
		int x;
		int y;
		pos(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
}
