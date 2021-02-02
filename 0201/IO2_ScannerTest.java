

import java.util.Scanner;

public class IO2_ScannerTest {

	public static void main(String[] args) {
		
//		String s1 = "안 \n녕\n";
//		Scanner sc = new Scanner(s1);
//		System.out.print("읽은 문자열:"+sc.next());//유효문자가 나오기 전까지의 개행문자 pass, 구분자를 만나면 직전까지만 남아있기때문에 구분자가 남아있음
//		System.out.print(",읽은 문자열:"+sc.next());
//		System.out.print("\n=====================");
//		
//		String s2 = "안 녕\n";
//		Scanner sc2 = new Scanner(s2);
//		System.out.print("읽은 문자열:"+sc2.nextLine());//개행문자가 아니면 다 유효문자, 개행문자를 다 읽지만 개행문자를 떼고 출력 => 위치하고 있는곳에 개행문자 안남아있음
//		System.out.print("\n=====================");
		
		String s3 = "안 \n     녕\n";
		Scanner sc3 = new Scanner(s3);
		System.out.print("읽은 문자열:"+sc3.nextLine());
		System.out.print(",읽은 문자열:"+sc3.nextLine());
		System.out.print("\n=====================");
	}

}
