package com.ssafy.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class SWEA_4012 {
	static boolean[] selected;
	static int[][] map;
	static int n;
	static int answer;
	static ArrayList<Integer> select1 = new ArrayList<Integer>();
	static ArrayList<Integer> select2 = new ArrayList<Integer>();
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(in.readLine());
		for(int tc = 1; tc<=T; tc++) {
			n = Integer.parseInt(in.readLine());
			map = new int[n][n];
			selected = new boolean[n];
			answer = Integer.MAX_VALUE;
			for(int i = 0; i < n; i++) {
				st = new StringTokenizer(in.readLine());
				for(int j = 0; j < n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			combination(0,0);
			System.out.println("#"+tc+" "+answer);
			
		}

	}
	
	public static void combination(int idx, int cnt) {
		if(cnt == n/2) {
//			for(int i = 0; i < n; i++) {
//				System.out.print(selected[i] + " ");
//			}
//			System.out.println();
			select1.clear();
			select2.clear();
			for(int  i = 0; i < n; i++) {
				if(selected[i] == true) {
					select1.add(i);
				}else {
					select2.add(i);
				}
			}
			answer = Math.min(answer, cal());
			return;
		}
		for(int i = idx ; i < n; i++) {
			if(!selected[i]) {
				selected[i] = true;
				combination(i+1,cnt+1);
				selected[i] = false;
				
				
			}
				
			
		}
	}
	public static int cal() {
		int sum = 0;
		int sum2 = 0;
		for(int i = 0; i < select1.size()-1; i++) {
			for(int j = i; j < select2.size(); j++) {
				
				sum += map[select1.get(i)][select1.get(j)];
				sum += map[select1.get(j)][select1.get(i)];
				sum2 += map[select2.get(i)][select2.get(j)];
				sum2 += map[select2.get(j)][select2.get(i)];
				
				
			}
		}
		
		return Math.abs(sum-sum2);
	}
	

}
