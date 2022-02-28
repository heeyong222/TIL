package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16953 {

    static long a,b;
    static Queue<Long> q = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());


        a = Long.parseLong(st.nextToken());
        b = Long.parseLong(st.nextToken());

        System.out.println(bfs());
    }
    public static long bfs(){
        int c = 0;
        q.add(a);
        while(!q.isEmpty()){
            int s = q.size();
            for(int i = 0; i < s; i++){
                long tmp = q.poll();
                if(tmp == b) return c+1;
                if(tmp*2 <= b) q.add(tmp*2);
                if(tmp * 10 + 1 <= b) q.add(tmp*10 + 1);
            }
            c++;
        }

        return -1;
    }
}
