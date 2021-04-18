package tmp;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_2112_권희용 {
	static int d,w,k,res;
	static int[][] map;//기본 맵
	static int[][] tmpmap;//테스트 맵
	static int[] ab;// 각 행의 투약종류

	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb;
		int T = Integer.parseInt(in.readLine());
		for(int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(in.readLine());
			d = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			res = Integer.MAX_VALUE;
			map = new int[d][w];
			tmpmap = new int[d][w];
			ab = new int[d];
			for(int i = 0; i < d; i++) {
				st = new StringTokenizer(in.readLine());
				for(int j = 0; j < w; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			dfs(0,0);
			sb = new StringBuilder();
			sb.append("#"+tc+" "+res);
			System.out.println(sb);
		}
	}
	public static boolean check() {
		for(int i = 0; i < w; i++) {
			boolean flaggaro = false;
			for(int j = 0; j < d-k+1; j++) {
				
				boolean flagsero = true;
				
				for(int l = j+1; l < j+k; l++) {
					if(tmpmap[j][i] != tmpmap[l][i]) {
						flagsero = false;
						break;
					}
				}
				//k번 연속을 만족하면 더이상 탐색필요 x
				if(flagsero) {
					flaggaro = true;
					break;
				}
			}
			if(!flaggaro) return false;
		}
		return true;
	}
	public static void initmap() {
		for(int i = 0; i < d; i++) {
			for(int j = 0; j < w; j++) {
				tmpmap[i][j] = map[i][j];
			}
		}
	}
	public static void dfs(int idx, int cnt) {
		if(cnt >= res) return;
		if(idx == d) {
			initmap();
			for(int i = 0; i < d; i++) {
				if(ab[i] != 2) {
					for(int j = 0; j < w; j++) tmpmap[i][j] = ab[i];
				}
			}
			
			if(check()) res = Math.min(res, cnt);
			return;
		}
		
		//투약 안하는 경우
		ab[idx] = 2;
		dfs(idx+1, cnt);
		//A 투약 하는 경우
		ab[idx] = 0;
		dfs(idx+1, cnt+1);
		//B 투약 하는 경우
		ab[idx] = 1;
		dfs(idx+1, cnt+1);
	}

}
