package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16930 {

    static int n, m, k, sx, sy, ex, ey;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    static int[][] v;
    static char[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        map = new char[n+1][m+1];
        v = new int[n+1][m+1];

        for(int i = 1; i <= n; i++){
            String tmp = in.readLine();
            for(int j = 1; j <= m; j++){
//                System.out.println(tmp.charAt(j-1));
                map[i][j] = tmp.charAt(j-1);
            }
        }
        st = new StringTokenizer(in.readLine());
        sx = Integer.parseInt(st.nextToken());
        sy = Integer.parseInt(st.nextToken());
        ex = Integer.parseInt(st.nextToken());
        ey = Integer.parseInt(st.nextToken());

        bfs();

        if(v[ex][ey] == 0) System.out.println(-1);
        else System.out.println(v[ex][ey]);

    }
    public static void bfs(){

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{sx, sy});

        while(!q.isEmpty()){
            int[] now = q.poll();

            for(int i = 0; i < 4; i++){
                for(int j = 1; j <= k; j++){
                    int nx = now[0] + dx[i]*j;
                    int ny = now[1] + dy[i]*j;


                    if(nx >= 1 && ny >= 1 && nx <= n && ny <= m && map[nx][ny] == '.'){
                        if(v[nx][ny] == 0){
                            v[nx][ny] = v[now[0]][now[1]] + 1;
                            if(nx == ex && ny == ey) return;

                            q.add(new int[]{nx, ny});
                        }else if(v[nx][ny] <= v[now[0]][now[1]]){
                            break;
                        }
                    }else{
                        break;
                    }
                }
            }
        }


    }


}
