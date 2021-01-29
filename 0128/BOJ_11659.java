import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ_11659 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] array;

        int n = sc.nextInt();
        int m = sc.nextInt();
//        int n = Integer.parseInt(st.nextToken());
//        int m = Integer.parseInt(st.nextToken());

        array = new int[n+1];
//        st = new StringTokenizer(br.readLine());

        for(int i = 1; i < n+1; i++) {
//            array[i] = array[i-1]+Integer.parseInt(st.nextToken());

        }

        for(int i = 0; i < m; i++){
//            st = new StringTokenizer(br.readLine());
//            int start = Integer.parseInt(st.nextToken());
//            int end = Integer.parseInt(st.nextToken());
            int start = sc.nextInt();
            int end = sc.nextInt();
            int result = array[end] - array[start-1];
            System.out.println(result);
        }
    }
}
