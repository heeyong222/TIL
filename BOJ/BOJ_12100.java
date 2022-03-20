package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_12100 {

    static int res;
    static int t;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        t = Integer.parseInt(in.readLine());
        int map[][] = new int[t][t];
        for(int i = 0; i < t; i++){
            st = new StringTokenizer(in.readLine());
            for(int j = 0; j < t; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, map);
        System.out.println(res);

    }

    public static void dfs(int idx, int[][] tmpmap){
        if(idx == 5){
            res = Math.max(res, cal(tmpmap));
            return;
        }

        up(idx, duplicate(tmpmap));
        down(idx, duplicate(tmpmap));
        left(idx, duplicate(tmpmap));
        right(idx, duplicate(tmpmap));


    }
    static int cal(int[][] map) {
        int max = 0;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                max = Math.max(max, map[i][j]);
            }
        }
        return max;
    }
    public static void up(int cnt, int[][] tmpmap) {
        for (int i = 0; i < tmpmap.length; i++) {
            int row = 0;
            int block = 0;
            for (int j = 0; j < tmpmap.length; j++) {
                if (tmpmap[j][i] != 0) {
                    if (block == tmpmap[j][i]) {
                        tmpmap[row - 1][i] = block * 2;
                        block = 0;
                        tmpmap[j][i] = 0;
                    } else {
                        block = tmpmap[j][i];
                        tmpmap[j][i] = 0;
                        tmpmap[row][i] = block;
                        row++;
                    }
                }
            }
        }
        dfs(cnt + 1, tmpmap);
    }

    public static void down(int cnt, int[][] tmpmap) {
        for (int i = 0; i < tmpmap.length; i++) {
            int row = tmpmap.length - 1;
            int block = 0;
            for (int j = tmpmap.length - 1; j >= 0; j--) {
                if (tmpmap[j][i] != 0) {
                    if (block == tmpmap[j][i]) {
                        tmpmap[row + 1][i] = block * 2;
                        block = 0;
                        tmpmap[j][i] = 0;
                    } else {
                        block = tmpmap[j][i];
                        tmpmap[j][i] = 0;
                        tmpmap[row][i] = block;
                        row--;
                    }
                }
            }
        }
        dfs(cnt + 1, tmpmap);
    }

    public static void left(int cnt, int[][] tmpmap) {
        for (int i = 0; i < tmpmap.length; i++) {
            int col = 0;
            int block = 0;
            for (int j = 0; j < tmpmap.length; j++) {
                if (tmpmap[i][j] != 0) {
                    if (block == tmpmap[i][j]) {
                        tmpmap[i][col - 1] = block * 2;
                        block = 0;
                        tmpmap[i][j] = 0;
                    } else {
                        block = tmpmap[i][j];
                        tmpmap[i][j] = 0;
                        tmpmap[i][col] = block;
                        col++;
                    }
                }
            }
        }
        dfs(cnt + 1, tmpmap);
    }

    public static void right(int cnt, int[][] tmpmap) {
        for (int i = 0; i < tmpmap.length; i++) {
            int col = tmpmap.length - 1;
            int block = 0;
            for (int j = tmpmap.length - 1; j >= 0; j--) {
                if (tmpmap[i][j] != 0) {
                    if (block == tmpmap[i][j]) {
                        tmpmap[i][col + 1] = block * 2;
                        block = 0;
                        tmpmap[i][j] = 0;
                    } else {
                        block = tmpmap[i][j];
                        tmpmap[i][j] = 0;
                        tmpmap[i][col] = block;
                        col--;
                    }
                }
            }
        }
        dfs(cnt + 1, tmpmap);
    }




    public static int[][] duplicate(int[][] tmpmap) {
        int[][] map = new int[tmpmap.length][tmpmap.length];
        for (int i = 0; i < tmpmap.length; i++) {
            for (int j = 0; j < tmpmap.length; j++) {
                map[i][j] = tmpmap[i][j];
            }
        }
        return map;
    }

}
