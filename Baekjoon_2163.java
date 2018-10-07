package test;

import java.util.Scanner;

public class Baekjoon_2163 {
	

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int dp[][] = new int[301][301];
		int n,m;
		n=sc.nextInt();
		m=sc.nextInt();
		sc.close();
		
		
		System.out.println(dp(n,m,dp));
		
		
	}
	
	public static int dp(int n, int m, int[][] dp) {
		
		if(dp[n][m] > 0) //�̹� ���� ���� �ִ� ��� 
			return dp[n][m];
		if(n==1 && m==1)  //���� �ʿ䰡 ���� ���
			return 0;
		if(n==1) //���η� �� �ɰ����� ���η� �ɰ���
			dp[n][m] = dp(n,m/2,dp) + dp(n, m-m/2,dp) + 1;
		else//���η� �ɰ���
			dp[n][m] = dp(n/2,m,dp) + dp(n-n/2, m,dp) + 1;
		
		return dp[n][m];
		
	}

}
