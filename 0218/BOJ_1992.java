import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1992 {
	static int[][] map;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		map = new int[n][n];
		for(int i = 0; i < n; i++) {
			String str = in.readLine();
			for(int j = 0; j < n; j++) {
				map[i][j] = str.charAt(j)-'0';
			}
		}
		quadTree(0,0,n);
		System.out.println(sb);
		

	}
	public static boolean check(int r, int c, int n) {
		int tmp = map[r][c];
		for(int i = r; i < r+n; i++) {
			for(int j = c; j < c+n; j++) {
				if(tmp != map[i][j]) {
					return false;
				}
			}
		}
		return true;
	}
	public static void quadTree(int r, int c, int n) {
		if(check(r,c,n)) {
			sb.append(map[r][c]);
		}else {
			int nextn = n/2;
			sb.append("(");
			quadTree(r,c,nextn);
			quadTree(r,c+nextn,nextn);
			quadTree(r+nextn,c,nextn);
			quadTree(r+nextn,c+nextn,nextn);
			sb.append(")");
		}
	}


}
