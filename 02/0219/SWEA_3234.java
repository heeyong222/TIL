package com.ssafy.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_3234 {
	static int[] choo;
	static boolean[] check;
	static int answer;
	static int n;
	static int total;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(in.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			answer = 0;
			total = 0;
			n = Integer.parseInt(in.readLine());
			st = new StringTokenizer(in.readLine());
			choo = new int[n];
			check = new boolean[n];
			for(int i = 0; i < n; i++) {
				choo[i] = Integer.parseInt(st.nextToken());
				total += choo[i];
			}
			
			pm(0,0,0);
			System.out.println("#"+tc+" "+answer);
		}

	}
	public static int fac(int num) {
		int result = 1;
		for(int i = 1; i <= num; i++) {
			result *= i;
		}
		return result;
	}
	
	public static void pm(int idx, int left, int right) {
		if(idx == n) {
			answer++;
//			System.out.println(left+" "+right);
			return;
		}
		
		if(total-left <= left) {
			answer += fac(n-idx) * Math.pow(2, n-idx);
			return;
		}
		
		for(int i = 0; i < n; i++) {
			if(check[i]) continue;
			
			check[i] = true;
			pm(idx+1, left+choo[i], right);
			if(left >= right+choo[i]) {
				pm(idx+1, left, right+choo[i]);	
			}
			check[i] = false;
		}
	}

}
