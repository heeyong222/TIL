import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_3816 {
	static int res;
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb;
		int T = Integer.parseInt(in.readLine());
		for(int tc = 1; tc <= T; tc++) {
			sb = new StringBuilder();
			res = 0;
			st = new StringTokenizer(in.readLine());
			char[] a = st.nextToken().toCharArray();
			char[] b = st.nextToken().toCharArray();
			
			int[] apb = new int[26];
			for(int i = 0, l = a.length; i < l; i++) {
				apb[a[i]-'a']++;
			}
			
			for(int i = 0, l1 = a.length, l2 = b.length; i < l2-l1+1; i++) {
				int[] apb2 = new int[26];
				for(int j = i; j < l1+i; j++) {
					apb2[b[j]-'a']++;
				}
				boolean check = true;
				for(int k = 0; k<26; k++) {
					if(apb[k] != apb2[k]) {
						check = false;
						break;
					}
				}
				if(check) res++;
			}
			sb.append("#").append(tc).append(" ").append(res);
			System.out.println(sb);
			
		}
	}

}
