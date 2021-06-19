import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class BOJ_1181 {

	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(in.readLine());
		String[] l = new String[n];
		int maxlen = 0;
		for(int i = 0; i < n; i++) {
			
			l[i] = in.readLine();
			if(l[i].length() > maxlen) {
				maxlen = l[i].length();
			}
		}
		Arrays.sort(l);
		ArrayList<String> al = new ArrayList<>();
		for(int i = 0; i < n-1; i++) {
			if(l[i].equals(l[i+1])) continue;
			al.add(l[i]);
		}
		al.add(l[n-1]);
		
		for(int i = 1; i <= maxlen; i++) {
			for(int j = 0; j < al.size(); j++) {
				if(al.get(j).length() == i) {
					System.out.println(al.get(j));
				}
			}
		}

		
	}

}
