
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class JO_1828 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] ch = new int[n][2];
		for(int i = 0; i < n; i++) {
			ch[i][0] = sc.nextInt();
			ch[i][1] = sc.nextInt();
		}
		// 최저온도 기준 정렬
		Arrays.sort(ch, new Comparator<int[]>(){
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[0] == o2[0]) {
					return o1[1]-o2[1];
				}else {
					return o1[0]-o2[0];
				}
			}
		});
		
		int min = ch[0][1];
		int cnt = 1;
		
		for(int i = 1; i < n; i++) {
			//기존 최저온도보다 낮다면
			if(ch[i][0] <= min) {
				//그 화학물질의 최고온도가 더 낮은경우 min값 교체
				if(ch[i][1] <= min) {
					min = ch[i][1];
				}
				
			}else {// 포함이 안되면 냉장고수+, 새로운 min값 설정
				cnt++;
				min = ch[i][1];
			}
		}
		System.out.println(cnt);

	}

}
