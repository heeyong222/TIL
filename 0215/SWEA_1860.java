import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_1860 {

	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(in.readLine());
		for(int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(in.readLine(), " ");
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			boolean check = true;
			int[] p = new int[n];
			st = new StringTokenizer(in.readLine(), " ");
			for(int i = 0; i < n; i++) {
				p[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(p);
			
			for(int i = 0; i < n; i++) {		
				if(p[0] < m || (p[i]/m)*k - (i+1) < 0) {
					check = false;
					break;
				}
			}
			if(check == true) {
				System.out.println("#"+tc+" Possible");
			}else {
				System.out.println("#"+tc+" Impossible");
			}
			
		}

	}

}
