

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class Solution22 {
	static int AnswerN=0;
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    static int[][] map;
    

	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input3.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int test_case=1; test_case<=T; test_case++){
			AnswerN=0;
			int N=sc.nextInt();
			map = new int[N][N];
			int num = sc.nextInt();
			for(int i = 0; i < num; i++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				int c = sc.nextInt();
//				map[a][b] = 1;
				//3칸 2칸 1칸 뛰므로
				for(int j = 3; j>0; j--) {
					//움직이기전 소금쟁이 위치는 0으로 변경
					if(a >-1 && b > -1 && a < N && b < N) {
						map[a][b] = 0;
					}
					a = a+dr[c-1]*j;
					b = b+dc[c-1]*j;
					//배열 밖으로 나가면 소금쟁이 사망
					if(a < 0 || b < 0 || a > N-1 || b > N-1 ) {
						continue;
					}// 배열크기 안에 있고 그 자리에 소금쟁이가 없다면 추가
					else if(a >-1 && b > -1 && a < N && b < N && map[a][b] != 1) {
						map[a][b] = 1;
					}
					
					
				}
				
			}
			
			for(int i = 0; i<N; i++) {
				for(int j = 0; j < N; j++) {
					if (map[i][j] == 1) {
						AnswerN += 1;
					}
				}
			}
			
			
//			
//			for(int i = 0; i < N; i++) {
//				System.out.println(Arrays.toString(map[i]));
//			}
//			
//			
			
			
			System.out.println("#"+test_case+" "+AnswerN);
			
		}
		
		
	}

}
