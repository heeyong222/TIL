

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class JO_1141 {

	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		Stack<Integer> stack = new Stack<Integer>();
		Stack<Integer> sub = new Stack<Integer>();
		int  T = Integer.parseInt(in.readLine());
		
		int[] tmp = new int[T];
		int[] ans = new int[T];
		int result = 0;
		for(int i = 0; i < T; i++) {
			tmp[i] = Integer.parseInt(in.readLine());
		}
		stack.push(tmp[T-1]);
		for(int i = T-2; i>=0; i--) {
			System.out.println(stack.toString());
			int cnt = 0;
			int cow = tmp[i];
//			System.out.println("stack.peek : "+stack.peek()+"cow : "+cow);
			top:
			if(stack.peek() < cow) {
				while(!stack.isEmpty() && stack.peek() < cow) {
					sub.push(stack.pop());
					cnt++;
					
				}
				if(stack.isEmpty()) {
					while(!sub.isEmpty()) {
						stack.push(sub.pop());
					}
					stack.push(cow);
					ans[i] = cnt;
					break top;
				}
//				if(stack.peek() == cow) {
//					ans[i] = cnt-1;//15345
//					stack.push(cow);
//					break top;
//				}
				while(!sub.isEmpty()) {
					stack.push(sub.pop());
				}
				ans[i] = cnt;//15345
				stack.push(cow);
				
			}else if(stack.peek() >= cow) {
					ans[i] = 0;//543
					stack.push(cow);
					
			}
			
		}
		for(int i = T-1; i >=0; i--) {
//			System.out.println(ans[i]);
			result += ans[i];
		}
		System.out.println(result);
	}

}
