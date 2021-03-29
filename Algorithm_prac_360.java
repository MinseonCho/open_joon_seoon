package test;

import java.util.*;

public class Algorithm_prac_360 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}

		Arrays.sort(arr);

		int mid = arr.length / 2 - 1;

		System.out.println(arr[mid]);

	}
}
