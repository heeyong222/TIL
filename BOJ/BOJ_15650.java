package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15650 {

    public static int n, m;
    public static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[m];

        dfs(1,0);

    }

    public static void dfs(int idx, int dep){

        if(dep == m){
            for(int a : arr){
                System.out.print(a + " ");
            }
            System.out.println();
            return;
        }


        for(int i = idx; i <= n; i++){
            arr[dep] = i;
            dfs(i+1, dep+1);
        }
    }


}
