package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2491 {

	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		int[] map = new int[n];
		StringTokenizer st = new StringTokenizer(in.readLine());
		for(int i = 0; i < n; i++) {
			map[i] = Integer.parseInt(st.nextToken());
		}
	
		int tmp = 1;
		int answer = 2;
		for(int i = 0; i < n-1; i++) {
			if(map[i] <= map[i+1]) {
				tmp++;
			}
			else {
				answer = Math.max(answer, tmp);
				tmp = 1;
			}
		}
		
		tmp = 1;
		for(int i = 0; i < n-1; i++) {
			if(map[i] >= map[i+1]) {
				tmp++;
			}
			else {
				answer = Math.max(answer, tmp);
				tmp = 1;
			}
		}
		System.out.println(answer);
	}

}
