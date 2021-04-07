import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_3307_1 {

	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(in.readLine());
		for(int tc = 1; tc<= T; tc++) {
			int n = Integer.parseInt(in.readLine());
			int[] arr = new int[n];
			int[] lis = new int[n];
			st = new StringTokenizer(in.readLine());
			for(int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			int max = 0;
			for(int i = 0; i < n; i++) {
				lis[i] = 1;
				for(int j = 0; j < i; j++) {
					if(arr[j] < arr[i] && lis[i] < lis[j]+1) lis[i] = lis[j]+1;
				}
				if(max < lis[i]) max = lis[i];
			}
			System.out.println("#" + tc + " "+ max);
		}
	}

}
