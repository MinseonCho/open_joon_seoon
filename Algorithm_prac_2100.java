package test;

import java.util.*;

public class Algorithm_prac_2100 {
	public static int result = 0, n, c;
	public static int[] arr;

	// 특정 수 찾기 위한 이진 탐색 메소드
	public static boolean binary(int[] arr, int start, int end, int target) {
		int mid = (start + end) / 2;

		if (start > end)
			return false;

		if (arr[mid] == target)
			return true;
		if (arr[mid] < target)
			return binary(arr, mid + 1, end, target);
		else
			return binary(arr, start, mid - 1, target);
	}

	public static void binary_sort(int[] arr, int start, int end) {
		int mid = (start + end) / 2; // 중간 수

		if (start > end)
			return;

		int num = mid * (c - 1) + 1;
		if (num <= arr[arr.length - 1]) {
			int left = c - 2;
			int target = arr[0] + mid;
			// 공유기 설치
			while (left > 0) {
				if (binary(arr, 0, arr.length - 1, target))
					left--;
				target++;
				if (target > arr[arr.length - 1])
					break;
			}

			if (left == 0) {
				result = Math.max(result, mid);
				binary_sort(arr, mid + 1, end);
			}

		} else {
			binary_sort(arr, start, mid - 1);
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		c = sc.nextInt();
		arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}

		Arrays.sort(arr);

		// 가능한 최소거리, 최대거리
		int start = 1;
		int end = arr[n - 1] - arr[0];

		while (start <= end) {

			int mid = (start + end) / 2;
			// 이미 arr[0]에 설치했다고 가정 cnt = 1
			int value = arr[0];
			int cnt = 1;

			for (int i = 1; i < n; i++) {
				if (arr[i] >= value + mid) {
					cnt++;
					value = arr[i];
				}
			}

			if (cnt >= c) {
				result = Math.max(result, mid);
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}


		System.out.println(result);

	}

}
