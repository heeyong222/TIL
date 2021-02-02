

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1244 {

	public static void main(String[] args) throws FileNotFoundException, IOException{
//		System.setIn(new FileInputStream("res/swea/d3/BOJ_1244.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine())+1;
		int[] swc = new int[N];
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		for(int i = 1; i < N; i++) {
			swc[i] = Integer.parseInt(st.nextToken());
		}
		int stu = Integer.parseInt(in.readLine());
		for(int i =0; i < stu; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int s = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());
			
			//남자인경우
			if(s == 1) {
				int k = 1;
				while(true) {
					if(num * k >= N)
						break;
					if(swc[num*k] == 1) {
						swc[num*k] = 0;
					}else {
						swc[num*k] = 1;
					}
					k++;
				}
				
			}else if(s == 2) {
				//여자인경우
				int k = 1;
				while(true) {
					if(num-k < 1 || num+k >= N)
						break;
					if(swc[num-k] != swc[num+k])
						break;
					k++;
				}
				k -= 1;
				for(int j = num-k; j<= num+k; j++) {
					if(swc[j] == 1) {
						swc[j] = 0;						
					}
					else {
						swc[j] = 1;
					}
				}
			}
			
//			System.out.println(Arrays.toString(swc));
			
		}
		for(int i = 1; i < N; i++) {
			System.out.print(swc[i] + " ");
			if(i % 20 == 0)
				System.out.println();
		}
	}

}
