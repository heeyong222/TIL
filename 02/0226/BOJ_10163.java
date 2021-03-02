import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10163 {
    static int x,y,w,h;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(in.readLine());
        int[][] map = new int[101][101];
        int cnt = 1;
        for(int t = 0; t < n; t++){
            st = new StringTokenizer(in.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            for(int i = x; i <x+w; i++){
                for(int j = y; j < y+h; j++){
                    map[i][j] = cnt;
                }
            }
            cnt++;
        }
        for(int p = 1; p <= n; p++){
            int answer = 0;
            for(int i = 0; i < 101; i++){
                for(int j = 0; j < 101; j++){

                    if(map[i][j] == p) answer++;
                }

            }
            System.out.println(answer);
        }


    }
}
