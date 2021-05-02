import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_4014 {
	static int n, x;
	static int[][] map;
	static int res;
	static int cnt = 1;
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(in.readLine());
		for(int tc = 1; tc <= T; tc++) {
			res = 0;
			st = new StringTokenizer(in.readLine());
			n = Integer.parseInt(st.nextToken());
			x = Integer.parseInt(st.nextToken());
			map = new int[n][n];
			int[] test = new int[n];
			
			for(int i = 0; i < n; i++) {
				st = new StringTokenizer(in.readLine());
				for(int j = 0 ; j < n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					test[j] = map[i][j];
				}
				if(make(test)) {
//					System.out.println(i);
					res++;
				}
			}
			
			
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					test[j] = map[j][i];
				}
				if(make(test)) {
//					System.out.println(i);
					res++;
				}
			}
			System.out.println("#"+tc +" "+res);
		}
	}
	public static boolean make(int[] test) {
//		System.out.println("#"+cnt++);
		
		int tmp = 0;
		boolean[] ans = new boolean[test.length];
		for(int i = 0; i < n-1; i++) {
			if(test[i] != test[i+1]) {
				if(test[i]-test[i+1] == 1) {
//					System.out.println("1나옴");
					//뒷부분 확인
					tmp = test[i+1];
					for(int j = i+1; j <= i+x; j++) {
						
						if(j >= n) {
							return false;
						}
						if(test[j] != tmp || ans[j] == true) {
							return false;
						}
						
					}
					for(int j = i+1; j <= i+x; j++) {
						ans[j] = true;
					}
					
				}else if(test[i] - test[i+1] == -1) {
//					System.out.println("-1나옴");
					tmp = test[i];
					boolean flag = false;
					//앞부분 확인할 수 있으면 확인
					if(i - x + 1 >= 0) {
						flag = true;
						for(int j = i-x+1; j <i+1; j++) {
							if(test[j] != tmp || ans[j] == true) {
								flag = false;
								break;
							}
						}
						if(flag) {
							for(int j = i-x+1; j< i+1; j++) {
								ans[j] = true;
							}
						}
					}else {
						return false;
					}
					if(!flag) return false;
				}else {
					return false;
				}
				
			}
		}
		
		return true;
	}

}
