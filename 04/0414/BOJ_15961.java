import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15961 {
	static int n, d, k, c, res;
	static int[] map;
	static int[] sushies;
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		res = 0;
		map = new int[n];
		sushies = new int[d+1];
		for(int i = 0; i < n; i++) {
			map[i]  = Integer.parseInt(in.readLine());
		}
		int start = 0;
		int end = k-1;
		//초기값 설정
		sushies[c] = 1;
		for(int i = 0; i < k; i++) {
			sushies[map[i]]++;
		}
		res = Math.max(res, cnt());
		int tmp = res;
//		System.out.println(res);
		for(int i = 0; i < n-1; i++) {
			
			if(--sushies[map[start]]==0) tmp--;
			start++;
			end = (end+1)%n;
			if(++sushies[map[end]] == 1) tmp++;
			res = Math.max(res, tmp);
			
		}
		System.out.println(res);

	}
	public static int cnt() {
		int cnt = 0;
		for(int i = 0; i < d+1; i++) {
//			System.out.print(sushies[i] + " ");
			if(sushies[i] != 0) cnt++;
		}
//		System.out.println();
		return cnt;
	}

}
