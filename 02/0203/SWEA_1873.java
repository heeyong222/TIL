

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1873 {
	
	static int[] nr = {0,-1,0,1};
	static int[] nc = {-1,0,1,0};
	static char[][] map;
	static int n;
	static int m;
	static int x;
	static int y;
	static int way; // 0 : 왼쪽, 1 : 위, 2 : 오른쪽, 3 : 아래
	public static void main(String[] args) throws IOException{
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(in.readLine());
		for(int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(in.readLine(), " ");
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			map = new char[n][m];
			
			for(int i = 0; i < n; i++) {
				String str = in.readLine();
				for(int j = 0; j < m; j++) {
					map[i][j] = str.charAt(j);
				}
			}
			findxy(map);//초기 좌표값 및 방향 찾기
			
			int num = Integer.parseInt(in.readLine());
			String order = in.readLine();
			for(int i = 0; i < num; i++) {
				if(order.charAt(i) == 'S') {
					shoot(x,y,way);					
				}
				else {
					move(x,y,order.charAt(i));
				}
				
				
			}
			System.out.print("#"+(tc+1)+" ");
//			System.out.println(order.charAt(i)+" "+way);
			for(int a = 0; a < n; a++) {
				for(int j = 0; j < m; j++) {
					System.out.print(map[a][j]);
				}
				System.out.println();
			}
			
			
			
		}
		
	}
	
	public static void findxy(char[][] map) {
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(map[i][j] == '<'||map[i][j] == '>'||map[i][j] == '^'||map[i][j] == 'v') {
					x = i;
					y = j;
					if(map[i][j] == '<') {
						way = 0;
					}else if(map[i][j] == '>') {
						way = 2;
					}else if(map[i][j] == '^') {
						way = 1;
					}else if(map[i][j] == 'v') {
						way = 3;
					}
//					switch(map[i][j]) {
//						case '<':
//							way = 0;
//						case '^':
//							way = 1;
//						case '>':
//							way = 2;
//						case 'v':
//							way = 3;
//					}
					return;
				}
					
			}
		}
	}
	
	public static boolean canGo(int r, int c, int way) {
		if(way == 0) {
			if(c-1 >= 0 && map[r][c-1] == '.')
				return true;
		}else if(way == 1) {
			if(r-1 >= 0 && map[r-1][c] == '.')
				return true;
		}else if(way == 2) {
			if(c+1 < m && map[r][c+1] == '.')
				return true;
		}else if(way == 3) {
			if(r+1 < n && map[r+1][c] == '.')
				return true;
		}
		return false;
	}
	
	public static void move(int r, int c, char dir) {
		if(dir == 'L') {
			way = 0;
			if(canGo(r,c,0)) {
				y = c-1;
				map[r][c] = '.';
				map[x][y] = '<';
				
			}else {
				map[r][c] = '<';
			}
		}else if(dir == 'U') {
			way = 1;
			if(canGo(r,c,1)) {
				x = r-1;
				map[r][c] = '.';
				map[x][y] = '^';
			}else {
				map[r][c] = '^';
			}
		}else if(dir == 'R') {
			way = 2;
			if(canGo(r,c,2)) {
				y = c+1;
				map[r][c] = '.';
				map[x][y] = '>';
				
			}else {
				map[r][c] = '>';
			}
		}else if(dir == 'D'){
			way = 3;
			if(canGo(r,c,3)) {
				x = r+1;
				map[r][c] = '.';
				map[x][y] = 'v';
			}else {
				map[r][c] = 'v';
			}
		}
	}
	public static void shoot(int r, int c, int dir) {
		int tmpx = r+nr[dir];//0
		int tmpy = c+nc[dir];//2
		while(true) {
			
			if(tmpx < 0 || tmpy < 0 || tmpx >= n || tmpy >= m || map[tmpx][tmpy] == '#')
				break;
			if(map[tmpx][tmpy] == '*') {
				map[tmpx][tmpy] = '.';
				break;				
			}
			tmpx += nr[dir];
			tmpy += nc[dir];
				
			
		}
	}

}
