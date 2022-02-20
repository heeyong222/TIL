package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_9663 {
    static int n, res;
    static boolean[][] v;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));


        n = Integer.parseInt(in.readLine());
        v = new boolean[n][n];

        dfs(0);

        System.out.println(res);
    }

    public static void dfs(int d){
        if(d == n){
            res++;
            return;
        }
        for(int i = 0; i < n; i++){
            if(!chkStatus(d, i)) continue;
            v[d][i] = true;
            dfs(d+1);
            v[d][i] = false;
        }
    }

    public static boolean chkStatus(int a, int b){
        for(int i = a; i >=0; i--){
            if(v[i][b]) return false;
        }
        int nx = a-1;
        int ny = b-1;
        while(nx >= 0 && ny >= 0){
            if(v[nx][ny]) return false;
            nx--;
            ny--;
        }
        nx = a-1;
        ny = b+1;
        while(nx >= 0 && ny < n){
            if(v[nx][ny]) return false;
            nx--;
            ny++;
        }
        return true;
    }
}
