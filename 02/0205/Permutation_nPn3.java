
import java.util.Arrays;

public class Permutation_nPn3 {
	static int N; // 원소 개수
	static int[] numbers; // 순열을 저장하는 배열
	
	static int tc; // 순열 개수
	static int count; //재귀함수 호출 수 
	
	public static void main(String[] args) {
		N = 8;
		numbers = new int[N];
		
		long stime = System.currentTimeMillis();
		permutation(0,0);
		long etime = System.currentTimeMillis();
		System.out.printf("%dP%d의 시간 : %dms\n", N, N, etime-stime);
		System.out.printf("%dP%d의 개수 : %d\n", N, N, tc);
		System.out.printf("%dP%d를 구하는데 수행된 재귀 호출 수 : %d\n", N, N, count);
	}
	
	private static void permutation(int idx,int flag) {
		count++;
		
		if(idx == N) { //순열의 요수를 다 생성
			tc++;
//			System.out.println(Arrays.toString(numbers));
			return;
		}
		
		
		for(int i = 1; i <= N; i++) {
			//증복 검사
			if((flag & 1<<i) != 0) continue;
			//중복되지 않은 경우이므로
			numbers[idx] = i;
								//플레그에 i 숫자를 사용했다고 표시
			permutation(idx+1, flag | 1<<i); //다음 요소 뽑으러
			
		}
	}

}
