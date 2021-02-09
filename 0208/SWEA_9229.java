package com.ssafy.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_9229 {
	static int N; // 원소 개수
	static int R; // 조합할 개수
	static int M;
	static int[] snack; 
	static int answer;
	static int tmp;

	public static void main(String[] args) throws IOException  {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(in.readLine());
		for(int tc = 1; tc <= T; tc++) {
			answer = -1;
			st = new StringTokenizer(in.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(in.readLine(), " ");
			snack = new int[N];
			for(int i = 0; i < N; i++) {
				snack[i] = Integer.parseInt(st.nextToken());
			}
			
			combination(0,0);
			System.out.println("#"+tc+" "+answer);
	

		}
		
		
	}
	private static void combination(int idx, int start) {
		if(idx == 2) {//한개의 조합을 모두 만든 경우
			if(tmp <= M) {
				answer = Math.max(answer, tmp);
			}
			return;
		}
		
		for(int i = start; i < N; i++) {
			tmp += snack[i];		
			combination(idx+1, i+1);
			tmp -= snack[i];
		}
	}
}
