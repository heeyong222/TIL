import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_3307 {

	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(in.readLine());
		for(int tc = 1; tc <= T; tc++) {
			int n = Integer.parseInt(in.readLine());
			
			int[] arr = new int[n];
			int[] lis = new int[n];
			st = new StringTokenizer(in.readLine());
			for(int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			int size = 0;
			lis[size++] = arr[0];
			for(int i = 1; i < n; i++) {
				int tmp = Math.abs(Arrays.binarySearch(lis,  0, size, arr[i]))-1;
				lis[tmp] = arr[i];
				
				if(tmp == size) ++size;
			}
			
			System.out.println("#"+tc+" "+size);
		}
		

	}

}
