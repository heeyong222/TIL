

import java.util.LinkedList;
import java.util.Queue;

public class Q1_QueueAPITest {

	public static void main(String[] args) {
		
//		LinkedList<String> queue= new LinkedList<String>();
		Queue<String> queue = new LinkedList<String>();//->링크드리스트에 있는기능들을 큐에 정의된것들로만 제한
		//^ 객체를 담는 그릇역할
		System.out.println(queue.isEmpty()+"//"+queue.size());
		queue.offer("김태희");//add가 있지만 queue는 offer, 뺄떄는 poll 사용
		queue.offer("유이니");
		queue.offer("노히진");
		queue.offer("변수문");
		queue.offer("최우선");
		
		System.out.println(queue.isEmpty()+"//"+queue.size());
		System.out.println(queue.peek());
		System.out.println(queue.isEmpty()+"//"+queue.size());
		
		while(!queue.isEmpty()) {
			System.out.println(queue.poll());
		}
		System.out.println(queue.poll());
	}

}
