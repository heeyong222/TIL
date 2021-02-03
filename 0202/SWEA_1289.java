

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1289 {

	public static void main(String[] args) throws Exception{
		
		System.setIn(new FileInputStream("res/swea/d3/1289_원재의메모복구하기.txt"));
		
//		System.setIn(new FileInputStream("res/swea/d3/test.txt"));
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		
		int T = Integer.parseInt(in.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			char[] input = in.readLine().toCharArray();
//			char[] tmp = new char[input.length];
			int cnt = 0;
//			for (int i = 0; i < input.length; i++) {
//				tmp[i] = '0';
//				
//			}
			if(input[0] == '1') {
				cnt += 1;
			}
			for(int i =0; i<input.length-1;i++) {
				if(input[i] != input[i+1]) {
					cnt += 1;
				}
			}
			System.out.println("#"+tc+" "+cnt);
			
		}
	}

}
