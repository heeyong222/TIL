

import java.util.Scanner;

public class FactorialTest {
	static int N=10;
	public static int fac1(int n) {
		if(n == N) {
			return n;
		}
		return n*fac1(n+1);
	}
	public static int fac2(int n) {
		if(n == 1) {
			return 1;
		}
		return fac2(n-1)*n;
	}
	public static int fac3(int n) {
		if(n < N) {
			return n*fac3(n+1);
		}
		return n;
	}
	public static int fac4(int n) {
		if(n > 1) {
			return fac4(n-1)*n;
		}
		return 1;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("숫자를 입력하세요 : ");
		int num = sc.nextInt();
		N = num;
		System.out.println("fac1:"+fac1(1));
		System.out.println("fac2:"+fac2(N));
		System.out.println("fac3:"+fac3(1));
		System.out.println("fac4:"+fac4(N));
	}

}
