package com.ssafy.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class SWEA_1223 {
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		Stack<Integer> num = new Stack<Integer>();
		Stack<Character> op = new Stack<Character>();
		for(int tc = 1; tc <= 10; tc++) {
			int N = Integer.parseInt(in.readLine());
			String s = in.readLine();
			int tmp1 = 0;
			int tmp2 = 0;
			int result;
			for(int i = 0; i<N; i++) {
				if(s.charAt(i) == '*') {
					op.push(s.charAt(i));					
				}else if( s.charAt(i) == '+') {
					op.push(s.charAt(i));
				}else {
					num.push(s.charAt(i)-'0');
					if(!op.isEmpty() && op.peek() == '*') {
						tmp2 = num.pop();
						tmp1 = num.pop();
						System.out.println("tmp2 : "+tmp2+"tmp1 : "+tmp1);
						num.push(tmp1*tmp2);
						op.pop();
					}
				}
				System.out.println(num.toString());
				System.out.println(op.toString());
			}
			while(!op.isEmpty()) {
				tmp2 = num.pop();
				tmp1 = num.pop();
				num.push(tmp1+tmp2);
				op.pop();
			}
			result = num.pop();
			System.out.println("#"+tc+" "+result);
		}
		
		
	}
}
