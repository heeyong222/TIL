package com.ssafy.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_5215 {
	static int[] taste;
	static int[] cal;
	static int N;
	static int calLimit;
	static boolean[] isSelected;
	static int answer;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(in.readLine());
		
		
		for(int tc = 1; tc <= T; tc++ ) {
			answer = 0;
			st = new StringTokenizer(in.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			calLimit = Integer.parseInt(st.nextToken());
			taste = new int[N];
			cal = new int[N];
			isSelected = new boolean[N];
			//점수, 칼로리 배열 선언
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(in.readLine(), " ");
				taste[i] = Integer.parseInt(st.nextToken());
				cal[i] = Integer.parseInt(st.nextToken());
			}
			generateSubset(0);
			System.out.println("#"+tc+" "+answer);
			
			
		}

	}
	
	private static void generateSubset(int cnt) {
		if(cnt == N) {
			int totalcal = 0;
			int totaltaste = 0;
			for(int i = 0; i<N; i++) {
				if(isSelected[i]) {
					totalcal += cal[i];		
					totaltaste += taste[i];
				}
			}
			if(totalcal <= calLimit && totaltaste >= answer)
				answer = totaltaste;
			return;
		}
		// 선택
		isSelected[cnt] = true;
		generateSubset(cnt+1);
		// 비선택
		isSelected[cnt] = false;
		generateSubset(cnt+1);
		
	}

}
