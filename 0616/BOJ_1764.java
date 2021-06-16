import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1764 {
    static int d, b, total, dbcnt;
    static ArrayList<String> dblist;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());

        d = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        total = d + b;
        String[] list = new String[total];
        dblist = new ArrayList<>();
        for(int i = 0; i < total; i++){
            list[i] = in.readLine();
        }
        dbcnt = 0;
        Arrays.sort(list);
        for(int i = 0; i < total-1; i++){
            if(list[i].equals(list[i+1])){
                dbcnt++;
                dblist.add(list[i]);
            }
        }

        System.out.println(dbcnt);
        for(int i = 0; i < dblist.size(); i++){
            System.out.println(dblist.get(i));
        }

    }
}
