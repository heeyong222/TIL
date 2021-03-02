

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_1158 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int n = sc.nextInt();
		int k = sc.nextInt();
		Queue<Integer> q = new LinkedList<Integer>();
		for(int i = 1; i <= n; i++) {
			q.offer(i);
		}
		System.out.print("<");
		
		while(!q.isEmpty()) {
			for(int j = 0; j < k-1; j++) {
				q.offer(q.poll());
			}
			if(q.size() == 1) {
				System.out.print(q.poll()+">");
				break;
			}
			System.out.print(q.poll()+", ");
			
		}

	}

}
