import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1717 {
	static int[] parent;
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int x, a, b;
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		parent = new int[n+1];
		for(int i = 0; i < n+1; i++) {
			parent[i] = i;
		}
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(in.readLine());
			x = Integer.parseInt(st.nextToken());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			if(x == 0) {
				union(a,b);
			}else {
				if(find(a) == find(b)) System.out.println("YES");
				else System.out.println("NO");
			}
		}
		
	}
	public static void union(int a, int b) {
		int fa = find(a);
		int fb = find(b);
		if(fa < fb) parent[fa] = fb;
		else if(fa > fb) parent[fb] = fa;
	}
	public static int find(int a) {
		if(parent[a] == a)return a;
		else return parent[a] = find(parent[a]);
	}
	
}
