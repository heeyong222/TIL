import java.util.Scanner;

public class BOJ_2839 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int cnt = 0;
		while(true) {
			if(n % 5 == 0) {
				System.out.println(cnt + n / 5);
				break;
			}
			n-=3;
			cnt+=1;
			if(n < 0) {
				System.out.println(-1);
				break;
			}
		}

	}

}
