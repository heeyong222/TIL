

import java.util.Arrays;

/*
 * Sub Set은 특정 원소를 선택 했을 때와 안 했을 경우로 만들 수 있으므로 요소의 수는 2의 N승개이다.
 * 0: 원소를 선택 안했을 경우
 * 1: 원소를 선택 했을 경우
 * 0   000 원소를 하나도 선택 안한 경우
 * 1   001 맨 끝의 원소를 선택한 경우
 * 2   010 중간에 원소를 선택한 경우
 * 3   011 끝의 두 원소를 선택한 경우
 * ...
 * 8   111 모든 원소를 선택한 경우
 */
public class SubSetTest2 {
	static String[] datas = {"a","b","c","d"};
	static int N = datas.length;
	static int[] subset = new int[N];
	
	
	public static void main(String[] args) {
		
		long stime = System.currentTimeMillis();
		for(int i = 0, end = 2<<(N-1); i<end;i++) {//0부터 2의N승까지 반복 => 부분집합의 수
			//i 가 subset이므로 i 를 이진수로 표현
			for(int j = 0; j < N; j++) {
				if((1 << j & i) != 0) {
					subset[j] = 1;
				}
			}
			print();
			Arrays.fill(subset, 0);
		}
		long etime = System.currentTimeMillis();
		System.out.printf("%dms", etime=stime);
	}
	
	public static void print() {
		System.out.print("[ ");
		for(int i = 0; i<N; i++ ) {
			
			System.out.print(subset[i]+" ");
//			if(subset[i] == 1)
//				System.out.print(datas[i]+" ");
		}
		System.out.println("]");
	}
	
	

}
