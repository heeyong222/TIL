
import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class JO_1661 {
	static int map[][];
	static boolean visited[][];
	static int n, m, x, y, x1, y1, cnt, row, col;
	static String tmp;
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,1,0,-1};
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(in.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(in.readLine());
		y = Integer.parseInt(st.nextToken())-1;
		x = Integer.parseInt(st.nextToken())-1;
		y1 = Integer.parseInt(st.nextToken())-1;
		x1 = Integer.parseInt(st.nextToken())-1;
					

		map = new int[n][m];
		visited = new boolean[n][m];

		
		for(int i = 0; i < n; i++) {
			tmp = in.readLine();
			for(int j = 0; j < m; j++) {
				map[i][j] = tmp.charAt(j)-'0';
			}
		}
		
		bfs(x,y);
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				System.out.print(map[i][j]+"  ");
			}
			System.out.println();
		}
		System.out.println(map[x1][y1]);
	}
	
	public static void bfs(int r, int c) {
		Queue<Point> q = new LinkedList<>();
		q.offer(new Point(r,c));

		
		while(!q.isEmpty()) {
			int tmpx = q.peek().x;
			int tmpy = q.peek().y;
			q.poll();
			
			visited[tmpx][tmpy] = true;
			for(int i = 0; i < 4; i++) {
				
				row = tmpx + dx[i];
				col = tmpy + dy[i];
				if(row >= 0 && row < n && col >= 0 && col < m && map[row][col] == 0 && visited[row][col] == false ) {
					map[row][col] = map[tmpx][tmpy]+1;
					q.offer(new Point(row,col));
					
				}
			}
		}
	}

}
