import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_21771 {
    public static void main(String[] args)throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());

        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        char[][] map = new char[r][c];

        st = new StringTokenizer(in.readLine());
        int rg = Integer.parseInt(st.nextToken());
        int rp = Integer.parseInt(st.nextToken());
        int cg = Integer.parseInt(st.nextToken());
        int cp = Integer.parseInt(st.nextToken());
        int total = cg*cp;
        int pilcnt = 0;
        for(int i = 0; i < r; i++){
            String str = in.readLine();
            for(int j = 0; j < c; j++){
                map[i][j] = str.charAt(j);
                if(map[i][j] == 'P'){
                    pilcnt++;
                }
            }
        }

        if(pilcnt == total){
            System.out.println(0);
        }else{
            System.out.println(1);
        }
    }
}

