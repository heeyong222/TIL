

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_3499 {

	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb;
		Queue<String> tmp1 = new LinkedList<String>();
		Queue<String> tmp2 = new LinkedList<String>();
		
		int T = Integer.parseInt(in.readLine());
		for(int tc = 1; tc<= T; tc++) {
			sb = new StringBuilder();
			int N = Integer.parseInt(in.readLine());
			st = new StringTokenizer(in.readLine(), " ");
			for(int i = 0; i <(N+1)/2; i++) {
				tmp2.offer(st.nextToken());
			}
			for(int i = 0; i < N/2; i++) {
				tmp1.offer(st.nextToken());
			}
//			if(N%2 == 1) {
//				for(int i = 0; i<N/2+1; i++) {
//					tmp2.offer(tmp1.poll());
//				}
//			}else {
//				for(int i = 0; i<N/2; i++) {
//					tmp2.offer(tmp1.poll());
//				}
//			}
//			for(int i = 0; i<(N+1)/2; i++) {
//				tmp2.offer(tmp1.poll());
//			}
			for(int i = 0; i < N/2; i++) {
				sb.append(tmp2.poll()+" ");
				sb.append(tmp1.poll()+" ");
			}
			if(!tmp2.isEmpty())
				sb.append(tmp2.poll());
			System.out.println("#"+tc+" "+sb);
		}

	}

}
