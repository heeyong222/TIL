import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_3431 {
	static int l, u, x, res;
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(in.readLine());
		for(int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(in.readLine());
			l = Integer.parseInt(st.nextToken());
			u = Integer.parseInt(st.nextToken());
			x = Integer.parseInt(st.nextToken());
			
			if(x > u) {
				res = -1;
			}else if( x >= l && x <= u) {
				res = 0;
			}else {
				res = l-x;
			}
			System.out.println("#"+tc+" "+res);
		}

	}

}
