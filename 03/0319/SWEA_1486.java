import java.util.Scanner;
public class SWEA_1486 {

	static int res; //최소값 구하기
	static int N, B; // 인원수,선반높이
	static int[] map;
	public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
	    int TC = sc.nextInt();
	    for(int t =1; t <= TC; t++) {
	        res = Integer.MAX_VALUE; //초기화
	        N = sc.nextInt();
	        B = sc.nextInt();
	        map = new int[N];
	        for(int i = 0 ; i < N; i++) {
	            map[i] = sc.nextInt();
	        }
	        //한명씩 한명씩 보면서, 선택, 선택안함, 키 합치기
	//            키합이 기준치(B)
	            dfs(0,0);
	
	            System.out.println("#" + t + " " + res);
	        }
	
	}
	
	private static void dfs(int idx, int sum) {
	//        최적화
	//        if(sum >= B) {
	//            res = Math.min(res, sum - B);
	//            return;
	//        }
	//        키는 양수 +  16  17+ 
	        if(idx == N) {
	            int d = sum - B;
	            if(d < 0) {
	                return;
	            }
	            res = Math.min(res, d);
	            return;
	        }
	//        현재 위치의 사람의 키 선택함
	//        sum += map[idx]; //백트래킹
	
	        dfs(idx + 1, sum + map[idx] );
	//        sum -= map[idx];
	//        현재 위치의 사람의 키 선택 안함
	        dfs(idx + 1, sum );
	    }

}