

import java.util.Arrays;

public class CombinationTest1 {
	static int N; // 원소 개수
	static int R; // 조합할 개수
	static int[] numbers; // 조합을 저장하는 배열
	static int tc; // 조합 개ㅜㅅ
	static int count;// 재귀 함수 호출 수
	public static void main(String[] args) {
		N = 5;
		R = 3;
		numbers = new int[R];
		long stime = System.currentTimeMillis();
		combination(0,1);
		long etime = System.currentTimeMillis();
		System.out.printf("%dC%d의 조합 시간 : %d\n", N, R, etime-stime);
		System.out.printf("%dC%d의 조합 개수 : %d\n", N, R, tc);
		System.out.printf("%dC%d의 조합 콜수 : %d\n", N, R, count);
	}
	private static void combination(int idx, int start) {
		count++;
		if(idx == R) {//한개의 조합을 모두 만든 경우
			tc++;
			System.out.println(Arrays.toString(numbers));
			return;
		}
		
		for(int i = start; i <= N; i++) {
			numbers[idx] = i;
			combination(idx+1, i+1);
		}
	}
}
