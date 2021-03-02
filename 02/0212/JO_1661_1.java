package com.ssafy.test;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class JO_1661_1 {
	static int map[][];
	static boolean visited[][];
	static int n, m, x, y, x1, y1, row, col;
	static String tmp;
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,1,0,-1};
	static Stack<Point> s;
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(in.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(in.readLine());
		y = Integer.parseInt(st.nextToken())-1;
		x = Integer.parseInt(st.nextToken())-1;
		y1 = Integer.parseInt(st.nextToken())-1;
		x1 = Integer.parseInt(st.nextToken())-1;
					

		map = new int[n][m];
		visited = new boolean[n][m];

		
		for(int i = 0; i < n; i++) {
			tmp = in.readLine();
			for(int j = 0; j < m; j++) {
				map[i][j] = tmp.charAt(j)-'0';
			}
		}
		
		dfs(x,y);

		System.out.println(map[x1][y1]);
	}
	
	public static void dfs(int r, int c) {
//		for(int i = 0; i < n; i++) {
//			for(int j = 0; j < m; j++) {
//				
//			}
//		}
//		visited[r][c] = true;
		if((r == x1 && c == y1) || (map[x1][y1] != 0 && (map[r][c] > map[x1][y1]))) {
//			visited[r][c] = false;
			return;
		}
		for(int i = 0; i < 4; i++) {
			
			row = r + dx[i];
			col = c + dy[i];
			
			if(row >= 0 && row < n && col >= 0 && col < m && (map[row][col] == 0 || map[row][col] > 1) ) {
				if(row == x1 && col == y1) {
					
					if(map[row][col] == 0) {
						map[row][col] = map[r][c]+1;
						break;
					}else {
						map[row][col] = Math.min(map[row][col], map[r][c]+1);
						break;
					}
					
				}
				map[row][col] = map[r][c]+1;
				dfs(row,col);
			}
		}
//		visited[r][c] = false;
	}
	
	

}
