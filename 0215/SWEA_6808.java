

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_6808 {
	static int[] gyuy;
	static int[] iny;
	static boolean[] tmp;
	static boolean[] selected;
	static int result[];
	static int win, lose, gyu, inyoung;
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(in.readLine());
		for(int tc = 1; tc <= T; tc++) {
			gyuy = new int[9];
			iny = new int[9];
			selected = new boolean[10];
			tmp = new boolean[19];
			result = new int[9];
			win = 0;
			lose = 0;
			st = new StringTokenizer(in.readLine());
			for(int i = 0; i < 9; i++) {
				int tmpp = Integer.parseInt(st.nextToken());
				gyuy[i] = tmpp;
				tmp[tmpp] = true;
			}
			int idx = 0;
			for(int i = 1; i < 19; i++) {
				if(tmp[i] == false) {
					iny[idx++] = i;
				}
			}
			permutation(0);
			System.out.println("#"+tc+" "+win+" "+lose);
			
			
		}

	}
	private static void permutation(int idx) {
		
		
		if(idx == 9) { //순열의 요수를 다 생성		
			gyu = 0;
			inyoung = 0;
			for(int i = 0; i < 9; i++) {
				if(result[i] > gyuy[i]) {
					inyoung += result[i]+gyuy[i];
				}else {
					gyu += result[i]+gyuy[i];
				}
			}
			if(inyoung > gyu) {
				lose += 1;
			}else {
				win += 1;
			}
			
			return;
		}
		
		
		for(int i = 1; i <= 9; i++) {
			//증복 검사
			if(selected[i]) continue;
			//중복되지 않은 경우이므로
			result[idx] = iny[i-1];
			selected[i] = true;
			permutation(idx+1); //다음 요소 뽑으러
			selected[i] = false;
		}
	}

}
