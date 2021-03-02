import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Algo2_¼­¿ï_8_±ÇÈñ¿ë {

	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		st = new StringTokenizer(in.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int tmp1, tmp2, tmp3 = 0;
		int cnt = 0;
		for(int tc = 0; tc<N; tc++) {
			st = new StringTokenizer(in.readLine(), " ");
			tmp1 = Integer.parseInt(st.nextToken());
			tmp2 = Integer.parseInt(st.nextToken());
			tmp3 = Integer.parseInt(st.nextToken());
			if((tmp1+tmp2+tmp3) >= s && tmp1 >= m && tmp2 >= m && tmp3 >= m) {
				cnt++;
				sb.append(tmp1+" ");
				sb.append(tmp2+" ");
				sb.append(tmp3+" ");
				
			}
		}
		System.out.println(cnt);
		System.out.println(sb);
		

	}

}
