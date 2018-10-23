package test;

import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] num = new int[3];
		int tmp;
		
		for(int i=0; i<3; i++) {
			num[i] = sc.nextInt();
		}
		
		sc.close();
		
		for(int i = num.length-1; i>0; i--) {
			for(int j = 0; j<i; j++) {
				if(num[j] > num[j+1]) {
					tmp = num[j];
					num[j] = num[j+1];
					num[j+1] = tmp;
				}
			}
		}
		
		System.out.println(num[1]);
		
	
			
	}

}

