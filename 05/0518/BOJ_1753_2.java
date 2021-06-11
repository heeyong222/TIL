import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1753_2 {
	static int v, e, start;
	static int[] d;
	static List<List<node>> map;
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		v = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
		d = new int[v+1];
		map = new ArrayList<List<node>>();
		start = Integer.parseInt(in.readLine());
		Arrays.fill(d, Integer.MAX_VALUE);
		for(int i = 0; i < v+1; i++) {
			map.add(new ArrayList<node>());
		}
		
		for(int i = 0; i < e; i++) {
			st = new StringTokenizer(in.readLine());
			int tmp1, tmp2, tmp3 = 0;
			tmp1 = Integer.parseInt(st.nextToken());
			tmp2 = Integer.parseInt(st.nextToken());
			tmp3 = Integer.parseInt(st.nextToken());
			map.get(tmp1).add(new node(tmp2, tmp3));
		}
		
		dik(start);
		for(int i = 1; i < v+1; i++) {
			if(d[i] == Integer.MAX_VALUE) System.out.println("INF");
			else System.out.println(d[i]);
		}

	}
	public static void dik(int start) {
		PriorityQueue<node> q = new PriorityQueue<>();
		d[start] = 0;
		q.add(new node(start, 0));
		
		while(!q.isEmpty()) {
			node n = q.poll();
			int cur = n.idx;
			if(d[cur] < n.dist) continue;// 지금 위치까지의 거리가 더 작은경우 = 이미 방문한 경우
			for(node nn : map.get(cur)) {
				if(d[nn.idx] > d[cur] + nn.dist) {
					d[nn.idx] = d[cur] + nn.dist;
					q.add(new node(nn.idx, d[nn.idx]));
				}
			}
		}
	}
	public static class node implements Comparable<node>{
		int idx, dist;
		public node(int idx, int dist) {
			this.idx = idx;
			this.dist = dist;
		}
		@Override
		public int compareTo(node o) {
			return this.dist - o.dist;
		}
	}
}
