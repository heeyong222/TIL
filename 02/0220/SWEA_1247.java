

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Pos{
	int r;
	int c;
	Pos(int r, int c){
		this.r = r;
		this.c = c;
	}
}
public class SWEA_1247 {
	static int cust;
	static int companyr, companyc, homer, homec;
	static boolean[] visited;
	static Pos[] custpos;
	static int result;
	static int min;
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(in.readLine());
		for(int tc = 1; tc<= T; tc++) {
			cust = Integer.parseInt(in.readLine());
			min = Integer.MAX_VALUE;
			result = 0;
			st = new StringTokenizer(in.readLine(), " ");
			companyr = Integer.parseInt(st.nextToken());
			companyc = Integer.parseInt(st.nextToken());
			homer = Integer.parseInt(st.nextToken());
			homec = Integer.parseInt(st.nextToken());
			visited = new boolean[cust];
			custpos = new Pos[cust];
			for(int i = 0; i < cust; i++) {
				custpos[i] = new Pos(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
				
			}
			
			bt(0,0,0);
			System.out.println("#"+tc+" "+min);
		}
		
	}
	public static void bt(int idx, int length, int result) {
		if(min <= result) return;
		if(length == cust) {
			result += Math.abs(custpos[idx].r-homer)+Math.abs(custpos[idx].c - homec);
			if(min > result) {
				min = result;
				return;
			}
		}
		if(length == 0) {
			for(int i = 0; i < cust; i++) {
				if(visited[i] == false) {
					visited[i] = true;
					result += Math.abs(custpos[i].r-companyr)+Math.abs(custpos[i].c - companyc);
//					System.out.println(i+" "+result);
					bt(i, length+1, result);
					result -= Math.abs(custpos[i].r-companyr)+Math.abs(custpos[i].c - companyc);
//					System.out.println(i+" "+result);
					visited[i] = false;
				}
			}
		}else {
			for(int i = 0; i < cust; i++) {
				if(visited[i] == false) {
					visited[i] = true;
					bt(i, length+1, result+Math.abs(custpos[idx].r-custpos[i].r) + Math.abs(custpos[idx].c-custpos[i].c));
					visited[i] = false;
				}
			}
		}
	}

}
