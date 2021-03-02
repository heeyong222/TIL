
import java.util.Comparator;
import java.util.PriorityQueue;

public class HeapTest {

	public static void main(String[] args) {
//		PriorityQueue<Integer> queue = queue = new PriorityQueue<>(); // min값으로 구성할떄
		PriorityQueue<Integer> queue = queue = new PriorityQueue<>(new Comparator<Integer>() {
			public int compare(Integer o1, Integer o2) {
				return Integer.compare(o2, o1);
			}
		});//max값으로 heap 구성할때
		
		queue.offer(3);
		queue.offer(1);
		queue.offer(10);
		queue.offer(4);
		queue.offer(2);
		
		while(!queue.isEmpty()) {
			System.out.println(queue.poll());
		}
		
	}

}
