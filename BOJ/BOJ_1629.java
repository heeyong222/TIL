package BOJ;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1629 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        long c = Long.parseLong(st.nextToken());
        if(b == 1) {
            System.out.println(a % c);
            return;
        }

        System.out.println(cal(a,b,c));

    }

    public static long cal(long a, long b, long c){
        // modular formule  : (a*b)%c = (a%c*b%c)%c

        if(b == 1) {
//            System.out.println(a % c);
            return (a % c);
        }
        long tmp = cal(a, b/2, c);

        if(b%2 == 1) return (tmp * tmp % c) * a % c;

        return tmp * tmp % c;

    }
}