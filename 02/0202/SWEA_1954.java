

import java.util.Scanner;

public class SWEA_1954 {
	private static int[][] map;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		int[] r = {0, 1,0, -1};
		int[] c = {1, 0, -1, 0};
		for(int tc = 1; tc <= T; tc++) {
			int n = sc.nextInt();
			map = new int[n][n];
			int way = 0;//방향
			int cnt = 1;
			int x = 0;
			int y = 0;
			
			map[0][0] = cnt;
			
			while(true) {
				boolean isexist = false; // 다음으로 진행 가능 여부
				// 범위 밖이거나 다음에 숫자가 배치되어있는경우 방향변환
				if(x+r[way%4] >= n || x+r[way%4] < 0 || y+c[way%4]<0 || y+c[way%4] >= n || map[x+r[way%4]][y+c[way%4]] != 0 ) 
					way++;
				//다음으로 갈 곳이 있는 경우 진행여부 true로 변환
				if(x+r[way%4] < n && x+r[way%4] >= 0 && y+c[way%4] < n && y+c[way%4] >= 0 && map[x+r[way%4]][y+c[way%4]] == 0) 
					isexist = true;
				//다음으로  갈 곳이 없는 경우			
				if(isexist == false) break;
				cnt++;
				
				x = x+r[way%4];
				y = y+c[way%4];
				map[x][y] = cnt;							
			}
			
			//결과 출력
			System.out.println("#"+tc);
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					System.out.print(map[i][j]+" ");
				}
				System.out.println();
			}
			
			
		}

	}

}
