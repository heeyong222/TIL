
import java.util.Scanner;

public class DigitTest1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int[] check = new int[10];
		int num = 1;
		
		while(num != 0) {
			num = sc.nextInt();
			if(num != 0 &&num < 10) {
				check[0]++;
			}else if(num >= 10 && num < 20) {
				check[1]++;
			}else if(num >= 20 && num < 30) {
				check[2]++;
			}else if(num >= 30 && num < 40) {
				check[3]++;
			}else if(num >= 40 && num < 50) {
				check[4]++;
			}else if(num >= 50 && num < 60) {
				check[5]++;
			}else if(num >= 60 && num < 70) {
				check[6]++;
			}else if(num >= 70 && num < 80) {
				check[7]++;
			}else if(num >= 80 && num < 90) {
				check[8]++;
			}else if(num >= 90 && num < 100) {
				check[9]++;
			}
		}
		for(int i= 0; i < check.length ; i++) {
			if(check[i] != 0) {
				System.out.println(i + " : " + check[i] + "개");
				
				}
		}

	}

}
