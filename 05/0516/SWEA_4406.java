import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_4406 {

	static char[] map = {'a', 'e', 'i', 'o', 'u'};
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		StringBuilder sb;
		String answer = "";
		for(int tc = 1; tc <= T; tc++) {
			sb = new StringBuilder();
			answer = "";
			String s = in.readLine();
			for(int i = 0; i < s.length(); i++) {
				if(check(s.charAt(i))) continue;
				answer += s.charAt(i);
			}
			sb.append("#" + tc + " "+ answer);
			System.out.println(sb);
			
		}
	}
	public static boolean check(Character a) {
		for(int i = 0; i < 5; i++) {
			if(a == map[i]) return true;
		}
		return false;
	}

}
