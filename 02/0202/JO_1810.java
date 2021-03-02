

import java.util.Arrays;
import java.util.Scanner;

public class JO_1810 {
	static int N = 9;
	static int[] tmp = new int[9];
	static int[] result = new int[7];
 	static int total = 100;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int i = 0; i < 9; i++) {
			tmp[i] = sc.nextInt();
		}
		combination(0,0);

	}
//  ### 1번째 방법       시간 : 419ms
	
//	private static void combination(int idx, int start) {
//		
//		if(idx == 7) {//한개의 조합을 모두 만든 경우
//			int num = 0;
//			for(int i = 0; i < result.length; i++) {
//				num += result[i];
//			}
//			if(num == 100) {
//				for(int pick : result) {
//					System.out.println(pick);
//				}
//			}
////			System.out.println(Arrays.toString(result));
//			return;
//		}
//		
//		for(int i = start; i < N; i++) {
//			result[idx] = tmp[i];
//			combination(idx+1, i+1);
//		}
//	}
	
	
//  ### 2번째 방법       시간 : 264ms
	private static void combination(int idx, int start) {
		
		if(idx == 7) {//한개의 조합을 모두 만든 경우		
			if(total == 0) {
				for(int pick : result) {
					System.out.println(pick);
				}
			}
//			System.out.println(Arrays.toString(result));
			return;
		}
		
		for(int i = start; i < N; i++) {
			result[idx] = tmp[i];
			total -= tmp[i];
			combination(idx+1, i+1);
			total += tmp[i];
		}
	}

}
