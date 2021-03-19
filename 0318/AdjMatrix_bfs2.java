
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class AdjMatrix_bfs2 {
	static boolean[][] map ;
	static boolean[] visited;
	static int N;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/AdjMatrix.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(in.readLine());
			map = new boolean[N][N];
			visited = new boolean[N];
			
			for(int i = 0; i < N; i++) {
				String line = in.readLine();
				for(int j = 0, k = 0; j < N; j++, k+=2) {
					if(line.charAt(k) - '0' == 1) {
						map[i][j] = true;
					}
				}
			}
			bfs(0);
			
			System.out.println();
		}
		

	}
	private static void bfs(int cur) {
		LinkedList<Integer> q = new LinkedList<Integer>();
		visited[cur] = true;
		q.add(cur);
		
		while(!q.isEmpty()) {
			cur = q.poll();
			System.out.printf("%c->", cur+65);
			//인접 노드들 방문
			for(int ad = 0; ad < N; ad++) {
				if(map[cur][ad] && !visited[ad]) {
					visited[ad] = true;
					q.add(ad);
				}
			}
		}
		
	}

}
