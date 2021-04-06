import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_6730 {
	static int up, down;
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(in.readLine());
		for(int tc = 1; tc <= T; tc++) {
			up = down = 0;
			int n = Integer.parseInt(in.readLine());
			int[] arr = new int[n];
			st = new StringTokenizer(in.readLine());
			for(int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			int tmp = 0;
			for(int i = 0; i < n-1; i++) {
				tmp = arr[i]-arr[i+1];
				if(tmp >= 0) {
					up = Math.max(up, tmp);
				}else {
					down = Math.max(down, Math.abs(tmp));
				}
			}
			System.out.println("#"+tc+" "+down+" "+up);
		}

	}

}
