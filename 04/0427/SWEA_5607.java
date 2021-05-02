import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_5607 {
	static int mod = 1234567891;
	static int n, r;
	static long[] fac;
	public static void main(String[] args)throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = null;
		int T = Integer.parseInt(in.readLine());
		fac = new long[1000001];
		fac[0] = 1;
		for(int i = 1; i <= 1000000; i++) fac[i] = (fac[i-1]*i) % mod;
		
		
		
		for(int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(in.readLine());
			n = Integer.parseInt(st.nextToken());
			r = Integer.parseInt(st.nextToken());
			
			long tmp = (fac[r] * fac[n-r])% mod;
			sb = new StringBuilder();
			
			sb.append("#" + tc + " "+ (fac[n]*fm(tmp, mod-2)) % mod);
			System.out.println(sb);
		}

	}
	public static long fm(long num, int b) {
		if(b == 0) return 1;//r 이 0인경우
		long next = fm(num, b/2);
		long cal = (next*next)%mod;
		if(b % 2 == 0) return cal;
		else return (cal*num) % mod;
		
	}

}
