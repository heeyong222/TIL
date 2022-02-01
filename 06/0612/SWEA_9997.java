import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_9997 {

	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb;
		int t = Integer.parseInt(in.readLine());
		for(int tc = 1; tc <= t; tc++) {
			sb = new StringBuilder();
			
			int tmp = Integer.parseInt(in.readLine());
			int h = tmp / 30;
			int m = (tmp%30) * 6 / 3;
			sb.append("#"+tc + " "+ h + " "+ m);
			System.out.println(sb);
			
		}

	}

}
