package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_14502 {


    static int dx[] = {0,1,0,-1};
    static int dy[] = {1,0,-1,0};
    static int map[][];
    static int n, m;
    static int res;
    public static class Dir{
        int x, y;
        Dir(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        res = 0;

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(in.readLine());
            for(int j = 0; j < m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        start(0);

        System.out.println(res);
    }
    public static void bfs(){
        Queue<Dir> q = new LinkedList<>();
        int[][] tmpmap = new int[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                tmpmap[i][j] = map[i][j];
                if(map[i][j] == 2) q.add(new Dir(i,j));
            }
        }

        while(!q.isEmpty()){
            Dir dir = q.poll();

            for(int i = 0; i < 4; i++){
                int nx = dir.x + dx[i];
                int ny = dir.y + dy[i];

                if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if(tmpmap[nx][ny] == 0){
                    q.add(new Dir(nx,ny));
                    tmpmap[nx][ny] = 2;
                }
            }
        }

        int cnt = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(tmpmap[i][j] == 0) cnt++;
            }
        }
//        System.out.println("res : "+ res);
        if(res < cnt) res = cnt;


    }
    public static void start(int cnt){
//        System.out.println("cnt : "+ cnt);
        if(cnt == 3){
//            System.out.println("!!! cnt : 3");
            bfs();
            return;
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
//                System.out.println("i : "+ i + " j : " + j + " cnt : "+ cnt);
                if(map[i][j] == 0){
                    map[i][j] = 1;
                    start(cnt+1);
                    map[i][j] = 0;
                }
            }
        }
    }

}
