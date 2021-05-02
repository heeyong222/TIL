import java.util.Scanner;

public class SWEA_1217 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n, m = 0;
		for(int tc = 1; tc <= 10; tc++) {
			int t = sc.nextInt();
			n = sc.nextInt();
			m = sc.nextInt();
			System.out.println("#" + tc + " "+ Math.round(Math.pow(n, m)));
		}

	}

}
