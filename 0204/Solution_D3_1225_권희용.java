package tmp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_D3_1225_권희용 {

	public static void main(String[] args) throws IOException {
		int T = 10;
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for(int tc = 1; tc <= T; tc++) {
			Queue<Integer> q = new LinkedList<Integer>();
			int num = Integer.parseInt(in.readLine());
			st = new StringTokenizer(in.readLine(), " ");
			for(int i = 0; i < 8; i++) {
				q.offer(Integer.parseInt(st.nextToken()));
			}
			top:
			while(true) {
				for(int i = 1; i <=5; i++) {
					int tmp = q.poll()-i;
					if(tmp <= 0) {
						q.offer(0);
						break top;
					}
					q.offer(tmp);
				}
			}
			System.out.print("#"+tc+" ");
			for(int i = 0; i < 8; i++) {
				System.out.print(q.poll()+" ");
			}
			System.out.println();
		}
	}

}
