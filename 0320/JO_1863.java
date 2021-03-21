import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JO_1863 {
	static int n, m, res;
	static int[] p;
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st ;
		st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		p = new int[n+1];
		
		make();
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(in.readLine());
			int tmp1 = Integer.parseInt(st.nextToken());
			int tmp2 = Integer.parseInt(st.nextToken());
			union(tmp1, tmp2);
		}
		res = 0;
		for(int i = 1; i <= n; i++) {
			if(i == p[i]) {
				res++;
			}
		}
		System.out.println(res);
	}
	private static void make() {
		for(int i = 1; i < n+1; i++) {
			p[i] = i;
			
		}
	}
	private static int findSet(int a) {
		if(p[a] == a) {
			return a;
		}else {
			p[a] = findSet(p[a]);
		}
		return p[a];
	}
	private static void union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		if(aRoot != bRoot) p[bRoot] = aRoot;
		
		
	}
}
