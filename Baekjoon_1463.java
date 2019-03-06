package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon_1463 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] dp = new int[n+1];
		dp[1] = 0;
		
		
		for(int i=2; i <= n; i++) {
			if(i==2) {dp[i] = 1; continue;}
			if(i==3) {dp[i] = 1; continue;}
			if(i%3 != 0 && i%2 != 0) {
				dp[i] = dp[i-1] +1;
				continue;
			}
			if(i%3 == 0 && i%2 ==0) {
				dp[i] = Math.min(dp[i/3] + 1, Math.min(dp[i-1]+1, dp[i/2]+1));
				continue;
			}
			if(i%3 ==0) {
				dp[i] = Math.min(dp[i/3] + 1,dp[i-1]+1);
				continue;
			}
			if(i%2 ==0) {
				dp[i] = Math.min(dp[i-1]+1, dp[i/2]+1);
				continue;
			}
			
		}

		System.out.println(dp[n]);
	
	}
	
}
