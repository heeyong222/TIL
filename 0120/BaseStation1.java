package fillCell;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * NxN 배열을 위한 기지국(A)와 집(H)가에 대한 정보가 주어진다. 
 * 기지국은 상하좌우 1셀씩만 커버한다. 커버하지 못하는 집의 개수를 출력
 *
 * [제약조건]
 * N은 3~15이하
 * 
 * [입력]
 * 첫줄은 테스트 케이스 수(T)가 주어진다.
 * 두번째 줄은 배열 크기(N)이 주어지고
 * 세번째 줄부터 N개의 기지국 정보가 제공된다. 
 * 
 * [출력 결과]
 * #1 4
 * #2 5
 * #3 9
 */
public class BaseStation1 {
    static int AnswerN=0;
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    static char[][] map;
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("res/basestation1.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int test_case=1; test_case<=T; test_case++){
			AnswerN=0;
			int N=sc.nextInt();
			
			//내코드
//			char[][] map = new char[N][N];
//			for(int i = 0; i < N; i++) {
//				for(int j = 0; j < N; j++) {
//					map[i][j] = sc.next().charAt(0);
//				}
//			}
//			
//			for(int i = 0; i < N; i++) {
//				for(int j = 0; j < N; j++) {
//					if(map[i][j] == 'H') {
//						boolean covered = false;
//						int[] row = {-1,1,0,0};
//						int[] col = {0,0,-1,1};
//						int nr, nc;
//						for(int x = 0; i<4; i++) {
//							nr = i+row[x];
//							nc = j+col[x];
//							if(nr>-1 && nr<N && nc>-1 && nc<N && map[nr][nc] == 'A') {
//								covered = true;
//								break;
//								
//							}	
//						}
//						if(covered == false)
//							
//							AnswerN += 1;
//						
//					}
//				}
//			}
			
			
			//풀이
			map = new char[N][N];
			sc.nextLine();
			for(int i = 0; i < N; i++) {
				String line = sc.nextLine();
				for(int j = 0, c = 0; j < N; j++, c+=2) {
					map[i][j] = line.charAt(c);
				}
			}
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(map[i][j] == 'A') {
						for(int k = 0; k<4; k++) {
							int nr = i+dr[k];
							int nc = j+dc[k];
							if(nr > -1 && nr < N && nc > -1 && nc < N && map[nr][nc] == 'H') {
								map[nr][nc] = 'X';
							}
						}
					}
				}
			}
			
			
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(map[i][j] == 'H') {
						AnswerN++;
					}
				}
//				System.out.println(Arrays.toString(map[i]));
			}
			
			
			
			System.out.println("#"+test_case+" "+AnswerN);
		}
	}//end main
}//end class









