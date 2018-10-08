package test;

import java.util.Scanner;

public class Baekjoon_1003 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] zero = new int[41];
		int[] one = new int[41];
		int numOfTestCase,testCase;
		numOfTestCase = sc.nextInt();
		zero[0] = 1;
		one[0] = 0;
		zero[1] = 0;
		one[1] = 1;
		
		for(int i=0; i<numOfTestCase; i++) {
			testCase = sc.nextInt();
			if(testCase == 0 || testCase ==1) {
				System.out.println(zero[testCase] + " " + one[testCase]);
			}
			else if(zero[testCase] != 0 && one[testCase] != 0) {
				System.out.println(zero[testCase] + " " + one[testCase]);
			}
			else {
				System.out.println(zeroCal(zero,testCase) + " " + oneCal(one,testCase));
			}

		}
		
		sc.close();

	}
	public static int zeroCal(int[] zero, int testCase) {
		
		if(testCase == 0 || testCase == 1) {
			return zero[testCase];
		}
		if(zero[testCase] != 0){
			return zero[testCase];
		}
		else {
			zero[testCase] = zeroCal(zero,testCase-1) + zeroCal(zero,testCase-2);
			return zero[testCase];
		}
	}
	
	public static int oneCal(int[] one, int testCase) {
		if(testCase == 0 || testCase == 1) {
			return one[testCase];
		}
		if(one[testCase] != 0){
			return one[testCase];
		}
		else {
			one[testCase] = oneCal(one,testCase-1) + oneCal(one,testCase-2);
			return one[testCase];
		}
	}
}
