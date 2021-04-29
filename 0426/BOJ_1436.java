import java.util.Scanner;

public class BOJ_1436 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int i = 666, count = 0;

        for(;;i++){
            String compare = ""+i;
            if(compare.contains("666")){
                count++;
            }
            if(count==N){
                System.out.println(i);
                break;
            }
        }


    }
}
