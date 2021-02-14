import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Algo1_¼­¿ï_8_±ÇÈñ¿ë {

	public static void main(String[] args)throws IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(in.readLine());
		boolean[] ans;
		for(int tc = 1; tc<=T; tc++) {
			st = new StringTokenizer(in.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			int a, b = 0;
			ans = new boolean[N+1];
			ans[x] = true;
			for(int i = 0; i < k; i++) {
				st = new StringTokenizer(in.readLine());
				a = Integer.parseInt(st.nextToken());
				b = Integer.parseInt(st.nextToken());
				if(ans[a] == true) {
					ans[a] = false;
					ans[b] = true;
				}else if(ans[b] == true) {
					ans[b] = false;
					ans[a] = true;
				}
			}
			
			for(int i = 1; i < N+1; i++) {
				if(ans[i] == true) {
					System.out.println("#"+tc+" "+i);
				}
			}
		}
	}

}
