/*
Greedy
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_11399 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int res = 0;
        int t = Integer.parseInt(in.readLine());
        st = new StringTokenizer(in.readLine());
        int[] map = new int[t];
        for(int i = 0; i < t; i++){
            map[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(map);
        for(int i = 0; i < t; i++){
            for(int j = 0; j <= i; j++){
                res += map[j];
            }
        }
        System.out.println(res);
    }
}
