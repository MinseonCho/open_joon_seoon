package test;

import java.util.*;

// 백준 2839 설탕배달

public class Algorithm_prac_2839 {

	public static int n;
	public static int[] arr = new int[5001];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();

		Arrays.fill(arr, (int) 1e9);

		arr[3] = 1;
		arr[5] = 1;

		for (int i = 6; i <= n; i++) {

			if (arr[i - 3] != (int) 1e9)
				arr[i] = Math.min(arr[i - 3] + 1, arr[i]);

			if (arr[i - 5] != (int) 1e9)
				arr[i] = Math.min(arr[i - 5] + 1, arr[i]);
		}

		int result = arr[n] != (int) 1e9 ? arr[n] : -1;
		
		System.out.println(result);

	}

}
