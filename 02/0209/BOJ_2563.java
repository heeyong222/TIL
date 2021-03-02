

import java.util.Scanner;

public class BOJ_2563 {
	static boolean[][] check;
	static int x;
	static int y;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		check = new boolean[100][100];
		int T = sc.nextInt();
		int ans = 0;
		for(int tc = 0; tc<T; tc++) {
			x = sc.nextInt();
			y = sc.nextInt();
//			System.out.println(x+","+y);
			for(int i = x-1; i < x+9; i++) {
				for(int j = y-1; j < y+9; j++) {
					check[i][j] = true;
				}
			}
		}
		for(int i = 0; i < 100; i++) {
			for(int j = 0; j < 100; j++) {
				if(check[i][j] == true)
					ans += 1;
			}
		}
		System.out.println(ans);

	}

}
