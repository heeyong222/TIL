import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_1219_2 {
	static int t, n, x, y;
	static boolean[] v;
	static Queue<Integer> q;
	static boolean res;
	public static void main(String[] args)throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb;
		
		for(int tc = 1; tc <= 10; tc++) {
			res = false;
			sb = new StringBuilder();
			ArrayList<Integer>[] list = new ArrayList[100];
			for(int i = 0; i < 100; i++) {
				list[i] = new ArrayList<Integer>();
			}
			v = new boolean[100];
			
			st = new StringTokenizer(in.readLine());
			t = Integer.parseInt(st.nextToken());
			n = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(in.readLine());
			for(int i = 0; i < n; i++) {
				x = Integer.parseInt(st.nextToken());
				y = Integer.parseInt(st.nextToken());
				list[x].add(y);
			}
			q = new LinkedList<Integer>();
			v[0] = true;
			q.add(0);
			top:
			while(!q.isEmpty()) {
				int dir = q.poll();
				for(int next : list[dir]) {
					if(v[next]) continue;
					if(next == 99) {
						res = true;
						break top;
					}
					q.add(next);
				}
			}
			sb.append("#" + tc + " ");
			if(res) sb.append("1");
			else sb.append("0");
			System.out.println(sb);
		}
	}

}
