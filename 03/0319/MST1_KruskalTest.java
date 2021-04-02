

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/*
5 10
0 1 5
0 2 10
0 3 8
0 4 7
1 2 5
1 3 3
1 4 6
2 3 1
2 4 3
3 4 1

output==>10

7 11
0 1 32
0 2 31
0 5 60
0 6 51
1 2 21
2 4 46
2 6 25
3 4 34
3 5 18
4 5 40
4 6 51

output==>175
 */
public class MST1_KruskalTest {
	
	static class Edge implements Comparable<Edge>{
		int from, to, weight;

		public Edge(int from, int to, int weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}
		@Override
		public int compareTo(Edge o) {
//			return this.weight - o.weight;
			return Integer.compare(this.weight, o.weight);
		}
		
	}
	
	static int V, E;
	static int parents[];
	static Edge[] edgeList;
	
	
	static void make() {
		for(int i = 0 ; i < V; i++) {
			parents[i] = i;
		}
	}
	static int findSet(int a) {
		if(parents[a] == a) {
			return a;
		}
//		return findSet(parents[a]); // path compression 전
		return parents[a] = findSet(parents[a]); // path compression 후
	}
	
	static boolean union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		if(aRoot == bRoot) return false;
		
		parents[bRoot] = aRoot;
		return true;
	}
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		parents = new int[V];
		edgeList = new Edge[E];
		
		for(int i = 0; i < E; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			edgeList[i] = new Edge(from, to, weight);
		}// 간선 리스트
		
		Arrays.sort(edgeList);
		make();
		int result = 0;
		int count = 0; // 선택한 간선 수
		
		for(Edge edge : edgeList) {
			if(union(edge.from, edge.to)) {
				result += edge.weight;
			}
		}
		
		System.out.println(result);
		
	}

}
