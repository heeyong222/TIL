package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1753 {
	static int V, E, start;
	static int[] d;
	static int INF = Integer.MAX_VALUE;
	static List<List<node>> map;
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		st = new StringTokenizer(in.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		d = new int[V+1];
		map = new ArrayList<List<node>>();
		start = Integer.parseInt(in.readLine());
		map.add(new ArrayList<node>()); // 0번 채우기
		Arrays.fill(d, INF);//distance 무한대로 초기화
		//리스트 초기화
		for(int i = 0; i < V; i++) {
			map.add(new ArrayList<node>());		
		}
		
		//간선 정보 입력
		for(int i = 0; i < E; i++) {
			st  = new StringTokenizer(in.readLine());
			int tmp1, tmp2, tmp3 = 0;
			tmp1 = Integer.parseInt(st.nextToken());
			tmp2 = Integer.parseInt(st.nextToken());
			tmp3 = Integer.parseInt(st.nextToken());
			map.get(tmp1).add(new node(tmp2, tmp3));
		}
		
		dijkstra(start);
		for(int i = 1; i < V+1; i++) {
			if(d[i] == INF) System.out.println("INF");
			else System.out.println(d[i]);
		}
	}
	
	private static void dijkstra(int start) {
		PriorityQueue<node> q = new PriorityQueue<>();
		boolean[] v = new boolean[V+1];
		d[start] = 0;
		q.add(new node(start, 0));
		
		while(!q.isEmpty()) {
			int cur = q.poll().idx;
			if(v[cur]) continue;
			v[cur] = true;
			
			for(node n : map.get(cur)) {
				if(d[n.idx] > d[cur] + n.dist) {
					d[n.idx] = d[cur] + n.dist;
					q.add(new node(n.idx, d[n.idx]));
				}
			}
		}
	}
	
	static class node implements Comparable<node>{
		int idx, dist;
		public node(int idx, int dist) {
			this.idx = idx;
			this.dist = dist;
		}
		public int compareTo(node o) {
			return this.dist - o.dist;
		}
	}

}
