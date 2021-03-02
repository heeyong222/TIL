
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.MappedByteBuffer;
import java.util.StringTokenizer;

public class BOJ_16935 {
	static int[][] map;
	static int n;
	static int m;
	static int p;
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(in.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		p = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for(int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(in.readLine(), " ");
		for(int i = 0; i < p; i++) {
			int num = Integer.parseInt(st.nextToken());
			
			map = op(num);
		}
		
		for(int i = 0; i<n; i++) {
			for(int j = 0; j < m; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
		
		
		
	}
	
	public static int[][] op(int num){
		int[][] tmp;

		if(num == 1) {
			tmp = new int[n][m];
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < m; j++) {
					tmp[n-i-1][j] = map[i][j];
				}
			}
			return tmp;
		}else if(num == 2) {
			tmp = new int[n][m];
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < m; j++) {
					tmp[i][m-j-1] = map[i][j];
				}
			}
			return tmp;
		}else if(num == 3) {
			tmp = new int[m][n];
			int tmp1;
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < m; j++) {
					tmp[j][n-i-1] = map[i][j];
				}
			}
			tmp1 = n;
			n = m;
			m = tmp1;		
			return tmp;
		}else if(num == 4) {
			tmp = new int[m][n];
			int tmp1;
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < m; j++) {
					tmp[m-j-1][i] = map[i][j];
				}
			}
			tmp1 = n;
			n = m;
			m = tmp1;	
			return tmp;
		}else if(num == 5) {
			tmp = new int[n][m];
			for(int i = 0; i < n/2; i++) {
				for(int j = 0; j < m/2; j++) {
					tmp[i][m/2+j] = map[i][j];
				}
			}
			for(int i = 0; i < n/2; i++) {
				for(int j = m/2; j < m; j++) {
					tmp[i+n/2][j] = map[i][j];
				}
			}
			for(int i = n/2; i < n; i++) {
				for(int j = m/2; j < m; j++) {
					tmp[i][j-m/2] = map[i][j];
					
				}
			}
			for(int i = n/2; i < n; i++) {
				for(int j = 0; j < m/2; j++) {
					tmp[i-n/2][j] = map[i][j];
				}
			}
			return tmp;
		}else if(num == 6) {
			tmp = new int[n][m];
			for(int i = 0; i < n/2; i++) {
				for(int j = 0; j < m/2; j++) {
					tmp[i+n/2][j] = map[i][j];
				}
			}
			for(int i = 0; i < n/2; i++) {
				for(int j = m/2; j < m; j++) {
					tmp[i][j-m/2] = map[i][j];
				}
			}
			for(int i = n/2; i < n; i++) {
				for(int j = m/2; j < m; j++) {
					tmp[i-n/2][j] = map[i][j];
					
				}
			}
			for(int i = n/2; i < n; i++) {
				for(int j = 0; j < m/2; j++) {
					tmp[i][j+m/2] = map[i][j];
				}
			}
			return tmp;
		}
		tmp = new int[n][m];
		return tmp;
	
	}
	

}
