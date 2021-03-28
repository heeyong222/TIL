

import java.util.Scanner;

public class dptest2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int[] map = new int[n+1];
		map[1] = 2;
		map[2] = 5;
		for(int i = 3; i <= n; i++) {
			map[i] = map[i-1]*2 + map[i-2];
		}
		System.out.println(map[n]);

	}

}
