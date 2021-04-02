

import java.util.Scanner;

public class DP1_KanpsackTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();// 물건의 개수
		int W = sc.nextInt();// 가방의 무게
		
		int[] weights = new int[N+1];
		int[] profits = new int[N+1];
		int[][] D = new int[N+1][N+1];
		
		for(int i = 1; i <= N; i++) {
			weights[i] = sc.nextInt();
			profits[i] = sc.nextInt();
		}
		
		for(int i = 1; i <= N; i++) {// 첫 물건부터 고려
			for(int w = 1; w <= W; w++) {// 무게 1부터 고려
				if(weights[i] <= w) {// 가방에 넣을 수 있는 상황
					//넣을까
					D[i][w] = Math.max(D[i-1][w-weights[i]]+profits[i], D[i-1][w]);
					//말까
				}else{
					D[i][w] = D[i-1][w];
				}
			}
		}
		System.out.println(D[N][W]);
	}

}
