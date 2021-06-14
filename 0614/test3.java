import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class test3 {
	static int cnt = 0;
	static String str;
	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		str = in.readLine();
		dfs(0);
		
	}
	public static void dfs(int idx) {
		if(idx == str.length()*2) return;
		if(idx >= str.length()) {
			System.out.print(str.charAt(str.length()-idx-1));
		}else {
			System.out.print(str.charAt(idx));
		}
		dfs(idx+1);
	}
}
