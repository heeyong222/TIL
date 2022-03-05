package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_9465 {

    static int[][] dp;
    static int[][] p;
    static int n;
    static int l;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(in.readLine());
        for(int i = 0; i < n; i++){
            l = Integer.parseInt(in.readLine());

            dp = new int[2][l+1];
            p = new int[2][l+1];

            StringTokenizer st = new StringTokenizer(in.readLine());
            for(int j = 1; j <= l; j++){
                p[0][j] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(in.readLine());
            for(int j = 1; j <= l; j++){
                p[1][j] = Integer.parseInt(st.nextToken());
            }
            dp[0][1] = p[0][1];
            dp[1][1] = p[1][1];

            for(int j = 2; j <= l; j++){
                dp[0][j] = Math.max(dp[1][j-1], dp[1][j-2]) + p[0][j];
                dp[1][j] = Math.max(dp[0][j-1], dp[0][j-2]) + p[1][j];

            }

            System.out.println(Math.max(dp[0][l], dp[1][l]));



        }


    }
}

