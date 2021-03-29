

public class PaintAPT {

	public static void main(String[] args) {
		int N = 8;
		
		int[] apt = new int[N+1];
		apt[1] = 2;
		apt[2] = 3;
		
		for(int i = 3; i<=N; i++) {
			apt[i] = apt[i-1]+apt[i-2];
		}
		System.out.printf("%d : %d\n", N, apt[N]);
	}

}
