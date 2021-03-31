import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class JO_1411 {

	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		int[] map = new int[n+1];
		map[1] = 1;
		map[2] = 3;
		for(int i = 3; i <= n; i++) {
			map[i] = (map[i-1] + map[i-2]*2) % 20100529;
		}
		System.out.println(map[n]);
	}

}
