package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BOJ_2635 {
	static int n;
	static int answer;
	static int result;
	public static void main(String[] args)throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(in.readLine());
		int max = 0;
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = n; i >= n / 2; i--) {
            ArrayList<Integer> numberList = new ArrayList<>();
            numberList.add(n);
            int tempN = n;
            int number = i;
            while (true) {
                if (tempN < 0) break;
                int t = tempN;
                if (number >= 0) numberList.add(number);
                tempN = number;
                number = t - tempN;
            }
            if (max < numberList.size()) {
                max = numberList.size();
                result = numberList;
            }
        }
        System.out.println(max);
        for(int n : result) {
        	System.out.print(n+" ");
        }
	}

}
