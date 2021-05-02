import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_17135 {
	static int[][] map;
	static int[][] initmap;
	static int n, m, d, tmp, res;
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		map = new int[n+1][m];
		initmap = new int[n+1][m];
		for(int i = 0; i < n+1; i++) {
			if(i == n) {
				for(int j = 0; j < m; j++) {
					map[i][j] = 2;
					initmap[i][j] = 2;
					
				}
				continue;
			}
			st = new StringTokenizer(in.readLine());
			for(int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				initmap[i][j] = map[i][j];
			}
		}
		
		//궁수 위치 설정
		for(int i = 0; i < m-2; i++) {
			for(int j = i+1; j <m-1; j++) {
				for(int k = j+1; k < m; k++) {
					tmp = 0;
					tmp = attack(i, j, k);
//					System.out.println("####################################"+i+" "+j + " "+k +" : "+ tmp);

					res = Math.max(tmp, res);// 기존 최대값과 비교하여 더 큰값
					initmap();
					
				}
			}
		}
		
		System.out.println(res);
	}
	public static void initmap() {
		for(int i = 0; i < n+1; i++) {
			for(int j = 0; j < m; j++) {
				map[i][j] = initmap[i][j];
			}
		}
	}
	
	public static int attack(int i, int j, int k) {

		pos[] archer = {new pos(n, i), new pos(n, j), new pos(n, k)};
		ArrayList<posdist> tmpkilllist = new ArrayList<>();
		ArrayList<posdist> killlist = new ArrayList<>();
		for(int cnt = 0; cnt < n; cnt++) {
			tmpkilllist = new ArrayList<>();
			killlist = new ArrayList<>();
			for(pos arch : archer) {
				
				tmpkilllist = new ArrayList<>();
				for(int row = 0; row < n; row++) {
					for(int col = 0; col < m; col++) {
						if(map[row][col] == 1 && canattack(new pos(arch.x, arch.y), new pos(row, col))) {
//							System.out.println(arch.x+","+arch.y+"에서 공격가능"+row + " " + col);
							tmpkilllist.add(new posdist(row, col, dist(new pos(arch.x, arch.y), new pos(row, col))));
						}
					}
				}
				if(tmpkilllist.size() == 0) {
					continue;
				}else if(tmpkilllist.size() == 1) {
					posdist enemy = tmpkilllist.get(0);
					killlist.add(enemy);
				}else if(tmpkilllist.size() >= 2) {
					Collections.sort(tmpkilllist);
					posdist enemy = tmpkilllist.get(0);
					killlist.add(enemy);
				}
			}
			// 궁수별로 죽일 수 있는 적 다구했으니 죽임
			int count = 0;
			for(posdist p : killlist) {
				if(map[p.x][p.y] == 1) {
					count++; //죽인 적 ++
					map[p.x][p.y] = 0;
				}
				// 0인경우 이미 다른 궁수가 죽였으니 pass
			}
			tmp += count;
			//한 턴 끝났으니 맵변경
			turn();
		}
		
		return  tmp;
	}
	// 궁수가 공격가능한지 구하는 함수
	public static int dist(pos arc, pos enemy) {
		return Math.abs(arc.x-enemy.x) + Math.abs(arc.y - enemy.y);
	}
	public static boolean canattack(pos arc, pos enemy) {
		if(dist(arc, enemy) <= d) {
			return true;
		}
		return false;
	}
	
	public static void turn() {
		for(int i = n-1; i >= 1; i--) {
			for(int j = 0; j < m; j++) {
				map[i][j] = map[i-1][j];
			}
		}
		for(int j = 0; j < m; j++) {
			map[0][j] = 0;
		}
	}
	
	private static class pos implements Comparable<pos>{
		int x;
		int y;
		int dist;
		pos(int x, int y){
			this.x = x;
			this.y = y;
		}
		//가장 왼쪽 적 찾기위한 함수
		@Override
		public int compareTo(pos p) {
			if(this.y > p.y) {
				return 1;
			}else if(this.y == p.y) {
				if(this.x < p.x) return 1;
			}
			return -1;
		}
	}
	private static class posdist implements Comparable<posdist>{
		int x;
		int y;
		int dist;
		posdist(int x, int y, int dist){
			this.x = x;
			this.y = y;
			this.dist = dist;
		}
		//가장 왼쪽 적 찾기위한 함수
		@Override
		public int compareTo(posdist p) {
			if(this.dist > p.dist) {
				return 1;
			}else if(this.dist == p.dist) {
				if(this.y > p.y) return 1;
			}
			return -1;
		}
	}

}
