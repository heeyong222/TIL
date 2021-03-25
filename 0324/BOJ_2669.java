package BOJ;

import java.util.Scanner;

public class BOJ_2669 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean[][] map = new boolean[100][100];
		int a,b,c,d;
		int ans = 0;
		for(int l = 0; l < 4; l++) {
			a = sc.nextInt();
			b = sc.nextInt();
			c = sc.nextInt();
			d = sc.nextInt();
			for(int i = a; i < c;i++) {
				for(int j = b; j < d; j++) {
					map[i][j] = true;
				}
			}
		}
		for(int i = 0; i < 100; i++) {
			for(int j = 0; j < 100; j++) {
				if(map[i][j] == true) ans++;
			}
		}
		System.out.println(ans);

	}

}
