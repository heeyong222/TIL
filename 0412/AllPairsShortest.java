

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 모든 쌍 최단 경로 
 *
 */
public class AllPairsShortest {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/AllPairsShortest.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int[][] matrix = new int [N][N];
		StringTokenizer tokens;
		final int MAX = Integer.MAX_VALUE>>1;
		for (int i = 0; i < N; i++) {
			tokens = new StringTokenizer(in.readLine());
			for (int j = 0; j < N; j++) {
				matrix[i][j] = Integer.parseInt(tokens.nextToken());
				if(i!=j && matrix[i][j] ==0) {  //연결되지 않은 경로
//					Integer.MAX_VALUE값을 주면 다른 경로 가중치를 더할 때 범위 벗어나서 값을 구하지 못함. 
					matrix[i][j] = MAX;
				}
			}
		}
		for (int k = 0; k < N; k++) {				//경유
			for (int i = 0; i < N; i++) {			//출발
				for (int j = 0; j < N; j++) {		//도착
					if(matrix[i][j] > matrix[i][k]+ matrix[k][j]) {
						matrix[i][j] = matrix[i][k]+ matrix[k][j];
					}
				}
			}
		}
		for (int i = 0; i < N; i++) {
			System.out.println(Arrays.toString(matrix[i]));
		}
		
	}
}






