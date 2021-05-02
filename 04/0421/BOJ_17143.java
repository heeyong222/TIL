import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//1 2 3 4 상 하 우 좌
public class BOJ_17143 {
	static class shark{
		int s,d,z;
		public shark(int s, int d, int z) {
			this.s=s;
			this.d=d;
			this.z=z;
		}
	}
	static int[] dx = {0,-1,1,0,0};// 상화우좌
	static int[] dy = {0,0,0,1,-1};
	
	static int r,c,m, x, y, s, d, z, res;
	static shark[][] map;
	static shark[][] tmpmap;
	public static void main(String[] args)throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new shark[r+1][c+1];
		
		//상어 입력
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(in.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			s = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken());
			z = Integer.parseInt(st.nextToken());
			map[x][y] = new shark(s,d,z);
		}
		//낚시왕 오른쪽으로 한칸씩 이동
		for(int i = 1; i < c+1; i++) {
			getshark(i);
			moveshark();

		}
		
		System.out.println(res);

	}
	public static void copymap(shark[][] tmpmap) {
		for(int i = 0; i < r+1; i++) {
			for(int j = 0; j < c+1; j++) {
				map[i][j] = tmpmap[i][j];
			}
		}
	}
	public static boolean checkshark(int a, int b) {
		if(tmpmap[a][b] == null) return true;
		else return false;
	}
	public static void moveshark() {
		tmpmap = new shark[r+1][c+1];
		for(int i = 1; i < r+1; i++) {
			for(int j = 1; j < c+1; j++) {
				if(map[i][j] != null) {
					int tmpi = i;
					int tmpj = j;
					int tmp = 0;
					shark s = map[i][j];
					if(s.d == 1 || s.d == 2) tmp = s.s % ((r-1)*2);
					else tmp =  s.s % ((c-1)*2);
					while(tmp != 0) {
						int nx = tmpi + dx[s.d];
						int ny = tmpj + dy[s.d];
						if(1 <= nx && 1 <= ny && nx < r+1 && ny < c+1) {
							tmpi = nx;
							tmpj = ny;
						}else {//방향 바뀌는 경우
							if(nx > r) {
								nx -= 2;
								s.d = 1;
							}
							else if(nx < 1) {
								nx+=2;
								s.d = 2;
							}
							else if(ny > c) {
								ny -= 2;
								s.d = 4;
							}
							else if(ny < 1) {
								ny += 2;
								s.d = 3;
							}
							tmpi = nx;
							tmpj = ny;
							
						}
						tmp--;
						
					}
					//위치에 상어가 있는 경우 크기 비교
					if(!checkshark(tmpi, tmpj)) {
						if(tmpmap[tmpi][tmpj].z < s.z) tmpmap[tmpi][tmpj] = s;
					}else {//없는경우 상어 옮기기
						tmpmap[tmpi][tmpj] = s;
					}
				}
			}
		}
		copymap(tmpmap);
		
		
		
	}
	public static void getshark(int i) {
		for(int j = 1; j < r+1; j++) {
			if(map[j][i] != null) {
				res += map[j][i].z;
				map[j][i] = null;
				return;
			}
		}
	}

}
