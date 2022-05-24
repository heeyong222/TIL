package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_GOM_A {
    // 백준 곰곰컵 A번 - 치킨댄스를 추는 곰곰이를 본 임스
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();


        int total = Integer.parseInt(in.readLine());
        st = new StringTokenizer(in.readLine());

        int coke = Integer.parseInt(st.nextToken());
        int beer = Integer.parseInt(st.nextToken());

        int cnt = 1;
        while(true){

            if(total < 1 || (coke < 2 && beer < 1)) break;
            total -= 1;
            if(coke >= 2){
                coke -= 2;
            }else{
                beer -= 1;
            }

            cnt++;
        }
        System.out.println(cnt-1);

    }
}
