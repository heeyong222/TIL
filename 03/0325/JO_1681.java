import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//백트래킹 문제
public class JO_1681 {
	static int n;
	static int[][] map;
	static boolean[] v;
	static int res = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		n = Integer.parseInt(in.readLine());
		map = new int[n][n];
		v = new boolean[n];
		v[0] = true;
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(in.readLine());
			for(int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dfs(0, 0, 0);
		System.out.println(res);
	}
	private static void dfs(int idx, int start, int cost) {
		if(cost >= res) return;
		if(idx == n-1){//회사로 돌아가는 일만 남은 경우
			if(map[start][0] != 0) res = Math.min(res, cost+map[start][0]);
			return;
		}
		for(int i = 1; i < n; i++) {
			if(!v[i]) {
				if(map[start][i] == 0) continue;//갈수없는경우
				//갈수있는경우
				v[i] = true;
				dfs(idx+1, i, cost+map[start][i]);
				v[i] = false;
				
			}
		}
	}

}
