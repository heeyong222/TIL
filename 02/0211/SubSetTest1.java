

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
public class SubSetTest1 {
	static String[] datas = {"a","b","c","d"};
	static int N = datas.length;
	static int[] subset = new int[N];
	
	
	public static void main(String[] args) {
		for(int i = 0; i < 2; i++) {
			subset[0] = i;//첫번째 요소
			for(int j = 0; j < 2; j++) {
				subset[1] = j; // 두번째 요소
				for(int k = 0; k<2; k++) {
					subset[2] = k; ///세번째 요소
					for(int l = 0; l < 2; l++) {
						subset[3] = l; //네번째 요소
						print();
					}
				}
			}
		}
		
	}
	
	public static void print() {
		System.out.print("[");
		for(int i = 0; i<N; i++ ) {
			
//			System.out.print(subset[i]);
			if(subset[i] == 1)
				System.out.print(datas[i]+" ");
		}
		System.out.print("]");
	}
	
	

}
