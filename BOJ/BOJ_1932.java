package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1932 {

    static int n;


    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        n = Integer.parseInt(in.readLine());
        int map[][] = new int[n][n];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(in.readLine());
            for(int j = 0; j <= i; j++){

                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        for(int i = 1; i < n; i++){
            for(int j = 0; j <= i; j++){
                if(j-1 >= 0) map[i][j] += Math.max(map[i-1][j], map[i-1][j-1]);
                else map[i][j] += map[i-1][j];
            }
        }


        int result = -1;

        for(int i = 0; i < n; i++){
            if(result < map[n-1][i]) result = map[n-1][i];
        }

        System.out.println(result);
    }
}
