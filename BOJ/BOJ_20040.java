package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_20040 {
    static int[] p;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        p = new int[n];
        for(int i = 0; i < n; i++){
            p[i] = i;
        }

        int res = 0;
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(in.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            if(findSet(x) != findSet(y)) {
                union(x,y);
            }else {
                res = i+1;
                break;
            }
        }

        System.out.println(res);

    }

    public static int findSet(int x){
        if(p[x] == x) return x;
        else return p[x] = findSet(p[x]);
    }
    public static void union(int x, int y){
        if(x < y) p[findSet(y)] = p[findSet(x)];
        else p[findSet(x)] = p[findSet(y)];
    }
}
