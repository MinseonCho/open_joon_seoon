package test;

import java.util.Arrays;
import java.util.Scanner;

public class Algorithm_prac_9095 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		
		int[] dp = new int[12];
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;

		for (int i = 4; i < dp.length; i++) {
			dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
		}
		

		for (int i = 0; i < n; i++) {
			System.out.println(dp[arr[i]]);
		}
	}

}
