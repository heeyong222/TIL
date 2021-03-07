import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1966 {
    static int n,ans,cnt,total;
    static Queue<Integer> q ;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(in.readLine());
        for(int tc = 0; tc<T; tc++){
            q = new LinkedList<Integer>();
            cnt = 0;
            total = 1;
            int num = 0;
            int tmp;
            st = new StringTokenizer(in.readLine());
            n = Integer.parseInt(st.nextToken());
            ans = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(in.readLine());
            for(int i = 0; i < n; i++){
                tmp = Integer.parseInt(st.nextToken());

                q.offer(tmp);

            }
            while(true){

                System.out.print(q.toString());
                System.out.println("num: "+num);
                System.out.println(total);
                if(check(q.peek())){
                    if(q.peek() == num){
                        System.out.println(total);
                    }
                    q.poll();
                    n -= 1;
                    total++;
                }else{

                    q.offer(q.poll());
                }
            }

        }
    }
    public static boolean check(int num){
        boolean a = true;
        for(int i = 0; i < q.size(); i++){
            if(q.peek() <= num){
                q.offer(q.poll());
            }else{
                q.offer(q.poll());
                a = false;
            }
        }
        return a;
    }
}
