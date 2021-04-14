package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
class pos{
	int x, y;
	pos(int x, int y){
		this.x = x;
		this.y = y;
	}
}
public class BOJ_2564 {
	static int r, c, dgx, dgy, res;
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		st = new StringTokenizer(in.readLine());
		r = Integer.parseInt(st.nextToken());// 가로
		c = Integer.parseInt(st.nextToken());// 세로
		int n = Integer.parseInt(in.readLine());
		pos[] map = new pos[n];
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(in.readLine());
			map[i] = new pos(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		st = new StringTokenizer(in.readLine());
		dgx = Integer.parseInt(st.nextToken());
		dgy = Integer.parseInt(st.nextToken());
		for(pos p : map) {
			res += cal(dgx, dgy, p.x, p.y);
		}
		sb.append(res);
		System.out.println(sb);
	}
	
	public static int cal(int loca, int a, int locb, int b) {
		if(loca == locb) {
			return Math.abs(a-b);
		}else if(loca == 1) {
			if(locb == 3) {
				return a+b;
			}else if(locb == 4){
				return r-a+b;
			}else {
				return Math.min(a+b, 2*r-a-b)+c;
			}
		}else if(loca == 2) {
			if(locb == 3) {
				return c-b+a;
			}else if(locb == 4){
				return r-a+c-b;
			}else {
				return Math.min(a+b, 2*r-a-b)+c;
			}
		}else if(loca == 3) {
			if(locb == 1) {
				return a+b;
			}else if(locb == 2){
				return c-a+b;
			}else {
				return Math.min(a+b, 2*c-a-b)+r;
			}
		}else if(loca == 4) {
			if(locb == 1) {
				return r-b+a;
			}else if(locb == 2){
				return c-a+r-b;
			}else {
				return Math.min(a+b, 2*c-a-b)+r;
			}
		}
		return 0;
	}

}
