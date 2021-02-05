package tmp;

import java.io.InputStreamReader;
import java.util.Stack;
import java.io.BufferedReader;
import java.io.IOException;

public class Solution_D4_1218_권희용 {

	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		
		
		
		for(int tc = 1; tc <= 10; tc++) {
			int T = Integer.parseInt(in.readLine());
			String s = in.readLine();
			Stack<Character> stack = new Stack<Character>();
			
			for(int i = 0; i < T; i++) {
				char c = s.charAt(i);
				if(stack.isEmpty()) {
					stack.push(c);
					continue;
				}
				if((stack.peek() == '(' && c == ')') || (stack.peek() == '[' && c == ']') || (stack.peek() == '{' && c == '}') || (stack.peek() == '<' && c == '>')) {
					stack.pop();
				}else {
					stack.push(c);
				}
			}
			if(stack.isEmpty()) {
				System.out.println("#"+tc+" "+1);
				continue;
			}
			System.out.println("#"+tc+" "+0);
		}

	}

}
