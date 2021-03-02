

import java.util.Scanner;

public class IO3_ScannerTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("기수 : "+sc.nextInt());
//		System.out.println("이름 : "+sc.next());
		
		sc.nextLine();//의미없이 한번의 개행문자를 없애는 용도, 없으면 nextInt 후 엔터값이 바로 nextline에 들어가기때문에 프로그램 종료
		System.out.println("이름 : "+sc.nextLine());
	}

}
