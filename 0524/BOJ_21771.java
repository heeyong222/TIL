import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_21771 {
	static int[][] map;
	static int n, m, rx, ry, px, py, sx, sy;
	static boolean res;
	public static void main(String[] args) throws IOException{
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		
		st = new StringTokenizer(in.readLine());
		rx = Integer.parseInt(st.nextToken());
		ry = Integer.parseInt(st.nextToken());
		px = Integer.parseInt(st.nextToken());
		py = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i < n; i++) {
			String str = in.readLine();
			for(int j = 0; j < m; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		top:
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(map[i][j] == 'G') {
					if(map[i][j+1] == 'P') res = true;
				}
				if(map[i][j] == 'P') {
					sx = i;
					sy = j;
					break top;
				}
			}
		}
		if(res) {
			System.out.println(1);
		}
		else {
			for(int i = sx; i < sx+px-1; i++) {
				for(int j = sy; j < sy+ py-1; j++) {
					if(map[i][j] == 'G') {
						res = true;
						break;
					}
				}
			}
			
		}
		if(res) System.out.println(1);
		else System.out.println(0);
		
	}

}
