import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_5568 {
	private static class p implements Comparable<p>{
		int age;
		String name;
		int cnt;
		public p(int age, String name, int cnt) {
			this.age = age;
			this.name = name;
			this.cnt = cnt;
		}
		@Override
		public int compareTo(p o) {
			if(this.age == o.age) return this.cnt-o.cnt;
			else return this.age-o.age;
		}
	}
	static int a;
	static String b;
	public static void main(String[] args)throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		int num = 0;
		StringTokenizer st = null;
		ArrayList<p> list = new ArrayList<p>();
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(in.readLine());
			a = Integer.parseInt(st.nextToken());
			b = st.nextToken();
			list.add(new p(a,b,num++));
			
		}
		Collections.sort(list);
		StringBuilder sb;
		for(p people:list) {
			sb = new StringBuilder();
			sb.append(people.age + " "+ people.name);
			System.out.println(sb.toString());
		}
	}

}
