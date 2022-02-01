import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 * 연속된 N개 구간에서 어떤 알파벳이 많이 등장하는가?
 */
public class test2 {
	static int maxcnt;
	static char maxchar;
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		
		String str = st.nextToken();
		int t = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i < str.length()-t; i++) {
			int map[] = new int[26];
			for(int j = 0; j < t; j++) {
				map[str.charAt(i+j)-'A']++;
			}
			check(map);
		}
		System.out.println(maxchar +" "+ maxcnt);

	}
	public static void check(int[] map) {
		for(int i = 0; i < 26; i++) {
			if(maxcnt < map[i]) {
				maxcnt = map[i];
				maxchar = (char)(i+'A');
			}
		}
	}

}
