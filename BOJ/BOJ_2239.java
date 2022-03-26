package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BOJ_2239 {

    static int[][] map;
    static StringBuilder sb;
    static List<Pos> empty = new ArrayList<>();
    static boolean done;
    public static class Pos{
        int x,y;
        public Pos(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        map = new int[9][9];
        sb = new StringBuilder();

        for(int i = 0; i < 9; i++){
            String tmp = in.readLine();
            for(int j = 0; j < 9; j++){
                map[i][j] = tmp.charAt(j) - '0';
                if(map[i][j] == 0) empty.add(new Pos(i,j));
            }
        }
        dfs(0);

    }

    public static void dfs(int d){
        if(d == empty.size()){
            done = true;
            for(int i = 0; i < 9; i++){
                for(int j = 0; j < 9; j++){
                    System.out.print(map[i][j]);
                }
                System.out.println();
            }
        }
        if(done) return;
        Pos p = empty.get(d);
        for(int k = 1; k <= 9; k++){
            if(map[p.x][p.y] == 0 && check(p.x,p.y,k)){
                map[p.x][p.y] = k;
                dfs(d+1);
                map[p.x][p.y] = 0;
            }
        }
    }
    public static boolean check(int x, int y, int val) {
        for (int i = 0; i < 9; i++) {
            if (y != i && map[x][i] == val)
                return false;
            if (x != i && map[i][y] == val)
                return false;
        }
        int xRange, yRange;
        if (x % 3 == 0)
            xRange = x - 2;
        else
            xRange = x - x % 3 + 1;
        if (y % 3 == 0)
            yRange = y - 2;
        else
            yRange = y - y % 3 + 1;

        for (int i = xRange; i < xRange + 3; i++) {
            for (int j = yRange; j < yRange + 3; j++) {
                if (x != i && y != j && map[i][j] == val) {
                    return false;
                }
            }
        }
        return true;
    }
}
