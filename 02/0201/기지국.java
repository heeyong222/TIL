
import java.util.Scanner;
//XXXXXXXXX
//XXXHXXXXX
//XXHAHXXHX
//XXHHXXXXX
//XXXXXXXXX
//XXAHHXXXX
//XXHXXHAHX
//XXAHXXHXX
//XXHXHXXXX
//XXXXXXXXX
public class 기지국 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int tc = 1; tc <= T; tc++) {
            int N = sc.nextInt();//맵의 크기.
            char[][] map = new char[N][N];
            //행만큼 반복을 하면서
            for(int i = 0; i < N; i++) {
                String str = sc.next();
                //열만큼 반복을 하면서.
                for(int j = 0; j < N; j++) {
                    //map에 줏어 담자.
                    map[i][j] = str.charAt(j);
                }
            }
            //기지국 찾자.
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    if(map[i][j] == 'A' || map[i][j] == 'B' || map[i][j] == 'C') {
                        //기지국이다!
                        //기지국 커버 범위 안의 집들을 X로 바꿔버리자.

                    	//'A'가 65이므로
                        for(int k = 1; k <= map[i][j]-'A' +1; k++) {
                        	if(i-k >= 0 && map[i-k][j] == 'H')
                        		map[i-k][j] = 'X';
                        	if(i+k < N && map[i+k][j] == 'H')
                        		map[i+k][j] = 'X';
                        	if(j-k >= 0 && map[i][j-k] == 'H')
                        		map[i][j-k] = 'X';
                        	if(j+k < N && map[i][j+k] == 'H')
                        		map[i][j+k] = 'X';
                        }
                    }
                }
            }
            int ans = 0;
            for(int i = 0; i < N; i++) {
            	for(int j = 0; j < N; j++) {
            		if(map[i][j] == 'H')
            			ans++;
            	}
            }
            
            System.out.println("#"+tc+" "+ans);
            
        }
    }
}