import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class SWEA_1251 {
	static int N;
	static pos[] map;
	static boolean[] v;
	static ArrayList<Edge>[] adjlist;
	static class pos{
		long x, y;

		public pos(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
	}
	static class Edge implements Comparable<Edge>{
		int idx;
		long cost;
		public Edge(int idx, long cost) {
			super();
			this.idx = idx;
			this.cost = cost;
		}
		@Override
		public int compareTo(Edge o) {
			return Long.compare(this.cost, o.cost);
		}
	}
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(in.readLine());
			map = new pos[N];
			
			StringTokenizer st1 = new StringTokenizer(in.readLine());
			StringTokenizer st2 = new StringTokenizer(in.readLine());
			for(int i = 0; i < N; i++) {
				map[i] = new pos(0, 0);
				map[i].x = Long.parseLong(st1.nextToken());
				map[i].y = Long.parseLong(st2.nextToken());
			}
			
			double E = Double.parseDouble(in.readLine());
			adjlist = new ArrayList[N];
			for(int i = 0; i < N; i++) {
				adjlist[i] = new ArrayList<>();
				for(int j = 0; j < N; j++) {
					long tmp = (long) (Math.pow(map[i].x-map[j].x, 2) + Math.pow(map[i].y-map[j].y, 2));
					adjlist[i].add(new Edge(j, tmp));
				}
			}
			long res = 0;
			int cnt = 0;
			v = new boolean[N];
			PriorityQueue<Edge> q = new PriorityQueue<>();
			q.add(new Edge(0,0)); //시작점, cost=0
			while(!q.isEmpty()) {
				Edge cur = q.poll();
				if(v[cur.idx]) continue;//방문했던거면 continue
				
				v[cur.idx] = true;//방문처리
				res += cur.cost;
				if(cnt+1 == N) break; // 총 방문edge갯수가 N개면 끝
				for(int i = 0; i < adjlist[cur.idx].size(); i++) {
					Edge nextE= adjlist[cur.idx].get(i);
					if(!v[nextE.idx]) q.add(nextE);
				}
			}
			
			System.out.println("#" + tc + " "+ Math.round(res*E));
			
		}
	}
	
	
}
