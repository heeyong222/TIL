import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1541 {

	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), "-");
		int res = Integer.MAX_VALUE;
		while(st.hasMoreTokens()) {
			int tmp = 0;
			
			StringTokenizer st2 = new StringTokenizer(st.nextToken(), "+");
			
			while(st2.hasMoreTokens()) {
				tmp += Integer.parseInt(st2.nextToken());
			}
			
			if(res == Integer.MAX_VALUE) res = tmp;
			else res -= tmp;
			
		}
		System.out.println(res);
		
		
	}

}
