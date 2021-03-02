import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Algo3 {
	static int tmp;
	
	public static void main(String[] args)throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(in.readLine());
		int M = Integer.parseInt(in.readLine());
		int[] totalcase = new int[N+1];// �� N�� ����ô�� �����ϴ� �迭 ����
		int answer = 9999;
		int cnt = 0; // N�� 2���� �ڸ�ũ��
		 tmp = N;
		while(tmp != 0) {
			tmp = tmp/2;
			cnt++;
		}
		st = new StringTokenizer(in.readLine());
		
		for(int i = 0; i<M; i++) {
			int tmp = Integer.parseInt(st.nextToken());
			for(int j = 0; j <= N; j++) {
				totalcase[j] = Math.max(totalcase[j], check(j, tmp, cnt));//����ô���� ��������ô���� ���ο� ����ô���� ���Ͽ� �� ū��			
			}
			
		}
		for(int i = 0; i <= N; i ++) {
//			System.out.println(i+"�� ô��: "+totalcase[i]);
			answer = Math.min(answer, totalcase[i]);
		}
		System.out.println(answer);

	}
	public static int check(int num1, int num2, int count) {
		int result = count;
		for(int i = 0; i < count; i++) {
			//bitmask�� ����Ͽ� �� �ڸ��� ���Ͽ� ���ڸ����� ���� ��� ����ô�� --
			if(((num1 & 1<<i) == (num2 & 1<<i)) || ((num1 & 1<<i) == 0 && (num2 & 1<<i) == 0)) {
				result--;

			}
		}
//		System.out.println(num1+","+num2+"��, result : " +result);
		return result;
		
	}

}
