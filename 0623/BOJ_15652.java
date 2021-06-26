import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15652 {
	static int n, m, cnt;
	static int[] map;
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[m];
		for(int i = 1; i <= n; i++) {
			map[0] = i;
			dfs(i, 1);
		}
	}
	
	public static void dfs(int start,  int cnt) {
		if(cnt == m) {
			for(int i = 0; i < m; i++) {
				System.out.print(map[i] + " ");
			}
			System.out.println();
			return;
		}
		for(int i = start; i <= n; i++) {
			map[cnt] = i;
			dfs(i, cnt+1);
		}
	}

}
