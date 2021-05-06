import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;

public class BOJ_3584 {
	static int n, a, b, res1, res2;
	static int[] parent;
	static ArrayList<Integer> list1;
	static ArrayList<Integer> list2;
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(in.readLine());
		for(int tc = 1 ;tc <= T; tc++) {
			res1 = 0;
			res2 = 0;
			n = Integer.parseInt(in.readLine());
			parent = new int[n+1];
			for(int i = 0; i < n-1; i++) {
				st = new StringTokenizer(in.readLine());
				a = Integer.parseInt(st.nextToken());
				b = Integer.parseInt(st.nextToken());
				parent[b] = a;
			}
			st = new StringTokenizer(in.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
//			for(int i = 0; i < n+1; i++) {
//				System.out.print(parent[i]+" ");
//			}
//			System.out.println();
			find(a,b);
			System.out.println(res1);
		}

	}
	public static void find(int a, int b) {
		findparents(a,b);
		int alevel = list1.size()-1;
		int blevel = list2.size()-1;
		while(true) {
			if(alevel < 0 || blevel < 0) break;
//			System.out.println("#"+alevel + " "+ blevel);
//			System.out.println(list1.get(alevel) + " "+ list2.get(blevel));
			if(list1.get(alevel) == list2.get(blevel)) {
				alevel -= 1;
				blevel -= 1;
			}else {
				break;
			}
		}
//		res1 = list1.get(alevel+1);

	}
	public static void findparents(int a,int b){
		int tmp = parent[a];
		list1 = new ArrayList<Integer>();
		list1.add(a);
		if(tmp != 0) list1.add(tmp);
		
		while(parent[tmp] != 0) {
			tmp = parent[tmp];
			list1.add(tmp);
		}
		tmp = parent[b];
		list2 = new ArrayList<Integer>();
		list2.add(b);
		if(tmp != 0) list2.add(tmp);
		while(parent[tmp] != 0) {
			tmp = parent[tmp];
			list2.add(tmp);
		}
	}

}
