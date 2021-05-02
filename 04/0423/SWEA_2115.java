import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_2115 {
	static int n, m, c, res;
	static int[][] map;
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = null;
		int T = Integer.parseInt(in.readLine());
		for(int tc = 1; tc  <= T; tc++) {
			st = new StringTokenizer(in.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			map = new int[n][n];
			
			for(int i = 0; i < n; i++) {
				st = new StringTokenizer(in.readLine());
				for(int j = 0; j < n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			res = 0;
			find();
			sb = new StringBuilder();
			sb.append("#" + tc + " " + res);
			System.out.println(sb);
			
		}
		

	}
	public static int cal(int x1, int y1, int x2, int y2) {
		int tmp1 = 0;
		int total1 = 0;
		for(int j = y1; j < y1+m; j++) {
			tmp1 += map[x1][y1];
		}
		if(tmp1 <= c) {
			for(int j = y1; j < y1+m; j++) {
				total1 += map[x1][y1] * map[x1][y1];
			}
		}else {
			
		}
		int tmp2 = 0;
		int total2 = 0;
		for(int j = y2; j < y2+m; j++) {
			tmp2 += map[x2][y2];
		}
		if(tmp2 <= c) {
			for(int j = y2; j < y2+m; j++) {
				total2 += map[x2][y2] * map[x2][y2];
			}
		}else {
			
		}
		
		return total1+total2;
	}
	public static void find() {
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n-m+1; j++) {
				//같은 행에 일꾼2가 채집할 수 있는 경우
				if(j+m <= n-m+1) {
					for(int k = j+m; k < n-m+1; k++) {
						System.out.println("i : "+ i + " j : "+ j + " k :" +i+" l :"+k);
						System.out.println(cal(i,j,i,k));
						res = Math.max(res, cal(i,j,i,k));
					}
				}
				for(int k = i+1; k < n; k++) {
					for(int l = 0; l < n-m+1; l++) {
						System.out.println("i : "+ i + " j : "+ j + " k :" +k+" l :"+l);
						System.out.println(cal(i,j,k,l));
						res = Math.max(res, cal(i,j,k,l));
					}
				}
			}
		}
	}

}
