package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2206 {

    static int n, m;
    static boolean v[][][];
    static int[][] map;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};

    public static class Dir{
        int x, y, cnt, isbreak;

        public Dir(int x, int y, int cnt, int isbreak){
            this.x = x;
            this.y = y;
            this.cnt = cnt;
            this.isbreak = isbreak;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];


        for(int i = 0; i < n; i++){
            String tmp = in.readLine();
            for(int j = 0; j < m; j++){
                map[i][j] = Integer.valueOf(tmp.charAt(j)) - '0';
            }
        }
        v = new boolean[n][m][2];
        System.out.println(bfs(0,0));
    }

    public static int bfs(int x, int y){
        Queue<Dir> q = new LinkedList<>();
        v[x][y][0] = true;
        v[x][y][1] = true;
        q.add(new Dir(x,y,1,0));
        while(!q.isEmpty()){

            Dir dir = q.poll();
            // 목적지라면 return
            if(dir.x == n-1 && dir.y == m-1) return dir.cnt;

            for(int i = 0; i < 4; i++){
                int nx = dir.x + dx[i];
                int ny = dir.y + dy[i];
                // 범위 초과 체크
                if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;

                if(map[nx][ny] == 0){
                    // 벽 X
                    if(!v[nx][ny][dir.isbreak]){
                        v[nx][ny][dir.isbreak] = true;
                        q.add(new Dir(nx, ny, dir.cnt+1, dir.isbreak));
                    }
                }else if(map[nx][ny] == 1){
                    // 벽
                    if(!v[nx][ny][1] && dir.isbreak == 0){
                        v[nx][ny][1] = true;
                        q.add(new Dir(nx, ny, dir.cnt + 1, 1));
                    }
                }
            }

        }

        return -1;
    }
}
