package com.ssafy.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_3109 {
	static int[] nx = {-1,0,1};
	static int[] ny = {1,1,1};
	static boolean[][] isVisited;
	static char[][] map;
	static int r;
	static int c;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(in.readLine()," ");
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		isVisited = new boolean[r][c];
		map = new char[r][c];
		int answer = 0;
		for(int i = 0; i < r; i++) {
			String str = in.readLine();
			for(int j = 0; j < c; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		
		for(int i = 0; i < r; i++) {
			if(pipe(i,0) == true) answer++;
		}
		System.out.println(answer);
		
		

	}
	
	public static boolean pipe(int x, int y) {
		isVisited[x][y] = true;
		if(y == c-1) return true;
		
		for(int i = 0; i < 3; i++) {
			int nextx = x + nx[i];
			int nexty = y + ny[i];
			if(nextx >= 0 && nextx < r && nexty >= 0 && nexty < c && isVisited[nextx][nexty] == false && map[nextx][nexty] == '.') {
				if(pipe(nextx, nexty) == true) return true;
			}
		}
		return false;
	}

}
