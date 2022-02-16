package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_15654 {

    static int n, m;
    static int[] arr;
    static boolean[] v;
    static int[] result;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];
        v = new boolean[n];
        result = new int[n];

        st = new StringTokenizer(in.readLine());
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        dfs(0);
        System.out.print(sb.toString());

    }
    public static void dfs(int a){
        if(a == m){
            for(int i = 0; i < m; i++){
                sb.append(result[i]).append(" ");
            }

            sb.append("\n");
            return;
        }

        for(int i = 0; i < n; i++){
            if(!v[i]) {
                v[i] = true;
                result[a] = arr[i];
                dfs(a+1);
                v[i] = false;
            }
        }
    }
}
