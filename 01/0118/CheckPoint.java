package com.java.first;

import java.util.Scanner;

public class CheckPoint {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		int total = m+100-n;
		System.out.println("비만수치는 "+total+"입니다.");
		if(total > 0) {
			System.out.println("당신은 비만이군요");
		}
	}

}
