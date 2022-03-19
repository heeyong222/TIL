package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2467 {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(in.readLine());

        long[] map = new long[n];
        st = new StringTokenizer(in.readLine());
        for(int i = 0; i < n; i++) map[i] = Long.parseLong(st.nextToken());

        int l = 0;
        int r = n-1;

        int lp = 0;
        int rp = 0;
        long res = Long.MAX_VALUE;

        while(l < r){
            long total = map[l] + map[r];
            if(res >= Math.abs(total)){
                res = Math.abs(total);
                lp = l;
                rp = r;
            }
            if(total >= 0){
                r--;
            }else{
                l++;
            }

        }
        sb.append(map[lp]).append(" ").append(map[rp]);
        System.out.println(sb.toString());
    }
}
