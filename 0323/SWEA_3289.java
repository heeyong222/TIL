import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_3289 {
	static int n, m;
	static int[] parents;
	static String res;
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(in.readLine());
		for(int tc = 1; tc <= T; tc++) {
			res = "";
			st = new StringTokenizer(in.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			parents = new int[n+1];
			make();
			for(int i = 0; i < m; i++) {
				st = new StringTokenizer(in.readLine());
				int tmp1 = Integer.parseInt(st.nextToken());
				int tmp2 = Integer.parseInt(st.nextToken());
				int tmp3 = Integer.parseInt(st.nextToken());
				if(tmp1 == 0) {
					union(tmp2, tmp3);
				}else {
					
					if(findSet(tmp2) == findSet(tmp3)) {
						res += "1";
					}else {
						res += "0";
					}
				}
			}
			
			System.out.println("#"+tc+" "+res);
		}
	}
	static void make() {
		for(int i = 1 ; i < n+1; i++) {
			parents[i] = i;
			
		}
	}
	static int findSet(int a) {
		if(parents[a] == a) {
			return a;
		}else {
			parents[a] = findSet(parents[a]);
		}
		return parents[a];
	}
	static void union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		if(aRoot != bRoot) parents[bRoot] = aRoot;
		
	}
	
}
