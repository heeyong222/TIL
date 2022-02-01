import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class test1 {

	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int[] map = new int[26];
		String str = in.readLine();
		
		
		for(int i = 0; i < str.length(); i++) {
			map[str.charAt(i)-'A']++;
		}
		int maxidx = 0;
		int maxval = map[0];
		for(int i = 0; i < 26; i++) {
			if(maxval < map[i]) {
				maxidx = i;
				maxval = map[i];
			}
		}
		System.out.println((char)(maxidx+'A'));
	}

}
