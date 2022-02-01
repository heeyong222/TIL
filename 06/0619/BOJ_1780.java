import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1780 {
	static int n, g, w, b;
	static int[][] map;
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = null;
		
		int n = Integer.parseInt(in.readLine());
		map = new int[n][n];
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(in.readLine());
			for(int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		func(0,0,n);
		System.out.println(g);
		System.out.println(w);
		System.out.println(b);
	}
	
	public static void func(int x, int y, int size) {
		if (Check(x, y, size)) {
			if(map[x][y] == -1) { 
				g++;
			}
			else if(map[x][y] == 0) {
				w++;
			}
			else {
				b++;
			}
			return;
		}
 
		int newSize = size / 3;
		
		func(x, y, newSize);								// 왼쪽 위
		func(x, y + newSize, newSize);						// 중앙 위
		func(x, y + 2 * newSize, newSize);					// 오른쪽 위
		
		func(x + newSize, y, newSize);						// 왼쪽 중간
		func(x + newSize, y + newSize, newSize);			// 중앙 중간
		func(x + newSize, y + 2 * newSize, newSize);		// 오른쪽 중간
		
		func(x + 2 * newSize, y, newSize);					// 왼쪽 아래
		func(x + 2 * newSize, y + newSize, newSize);		// 중앙 아래
		func(x + 2 * newSize, y + 2 * newSize, newSize);	// 오른쪽 아래
	}
	public static boolean Check(int x, int y, int size) {
		int color = map[x][y];
 
		
		for (int i = x; i < x + size; i++) {
			for (int j = y; j < y + size; j++) {
				if (color != map[i][j]) {
					return false;
				}
			}
		}
		return true;
	}
}
