package com.ssafy.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class rc{
	int r;
	int c;
	rc(int r, int c){
		this.r = r;
		this.c = c;
	}
}

public class BOJ_15686 {
	static int n;
	static int m;
	static int[][] map;
	static ArrayList<rc> chicken;
	static ArrayList<rc> home;
	static boolean[] selected;
	static int answer = 9999;
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(in.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][n];
		chicken = new ArrayList<rc>();
		home = new ArrayList<rc>();
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for(int j = 0; j < n; j++) {
				int tmp = Integer.parseInt(st.nextToken());
				map[i][j] = tmp;
				if(tmp == 1) {
					home.add(new rc(i,j));
				}else if(tmp == 2) {
					chicken.add(new rc(i,j));
				}
			}
		}
		selected = new boolean[chicken.size()];
		combination(0,0);
		System.out.println(answer);
		
		

	}
	
	private static void combination(int idx, int start) {
		if(start == m) {
			int sum = 0;
//			for(int i = 0; i < chicken.size(); i++) {
//				System.out.print(selected[i]+" ");
//			}
//			System.out.println();
			for(int i = 0; i < home.size(); i++) {
				int min = 9999;
				for(int j = 0; j < chicken.size(); j++) {
					if(selected[j] == true) {
						min = Math.min(min, Math.abs(home.get(i).r-chicken.get(j).r)+Math.abs(home.get(i).c - chicken.get(j).c));
					}
				}
				sum = sum+min;
			}
			answer = Math.min(answer, sum);
			return;
		}
		
		for(int i = idx; i < chicken.size(); i++) {
			if(selected[i] == false) {
				selected[i] = true;
				combination(i, start+1);
				selected[i] = false;
			}
		}
	}

}
