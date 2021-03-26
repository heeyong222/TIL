

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DijkstraTest {

	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int V = Integer.parseInt(in.readLine());
		int start = 0;
		int end = V-1;
		int[][] adjMatrix = new int[V][V];
		StringTokenizer st = null;
		for(int i = 0; i < V; i++) {
			st = new StringTokenizer(in.readLine());
			for(int j = 0; j < V; j++) {
				adjMatrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int[] distance = new int[V];
		boolean[] visited = new boolean[V];
		
		for(int i = 0; i < V; i++) {
			int min = Integer.MAX_VALUE;
			int current = 0;;
			// 1.처리하지 않은 정점중에 출발지에서 가장 가까운(최소비용) 정점 선택
			for(int j = 0; j < V; j++) {
				if(!visited[j] && min>distance[j]) {
					min = distance[j];
					current = j;
				}
			}
			visited[current] = true;
			if(current == end) break;
			//2. 선택된 current를 경유지로 하여 아직 처리하지 않은 다른 정점으로의 최소비용을 따져봄
			for(int j = 0; j < V; j++) {
				if(!visited[j] && adjMatrix[current][j] != 0 && distance[j] > min +adjMatrix[current][j]) {
					distance[j] = min + adjMatrix[current][j];
				}
			}
		}
		System.out.println(distance[end]);
	}

}
