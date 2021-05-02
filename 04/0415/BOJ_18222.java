package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_18222 {
	public static long solve(long x) {
		long tmp = 1;
		while(tmp * 2 < x) tmp *= 2;
		return x-tmp;
	}
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		long n = Long.parseLong(in.readLine());
		int cnt = 0;
		while(n != 0) {
			cnt++;
			n = solve(n);
		}
		if(cnt % 2 == 1) System.out.println(0);
		else System.out.println(1);
	}

}
