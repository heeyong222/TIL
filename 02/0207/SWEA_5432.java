package com.ssafy.test;

import java.util.Scanner;

public class SWEA_5432 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc = 1; tc <= T; tc++) {
			String s = sc.next();
			int scnt = 0;
			int result = 0;
//			for(int i = 0; i < s.length(); i++) {
////				System.out.println(s.charAt(i));
//				if(s.charAt(i) == '(') {
//					scnt += 1;
//					
//				}else if(s.charAt(i) == ')') {
//					if(s.charAt(i-1) == '(') {
//						scnt-=1;
//						result += scnt;	
////						System.out.println("result : "+result+" scnt : "+scnt);
//					}else if(s.charAt(i-1) == ')') {
//						scnt -= 1;
//						result += 1;
//					}
//					
//				}
//			}
			
			s = s.replace("()", "X");
//			System.out.println(s);
			for(int i = 0; i < s.length();i++) {
				if(s.charAt(i)== '(') {
					scnt += 1;
				}else if(s.charAt(i) == ')') {
					scnt-=1;
					result += 1;
				}else if(s.charAt(i) == 'X') {
					result += scnt;
				}
//				System.out.println(result);
			}
			System.out.println("#"+tc+" "+result);
		}
	}

}
