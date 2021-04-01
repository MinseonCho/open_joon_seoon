package test;

import java.util.*;
// 정렬된 배열에서 특정 수의 개수 구하기

public class Algorithm_prac_367 {

	public static int n, target, left, right;
	public static int[] arr = new int[1000000];

	public static void leftCheck(int start, int end) {
		int mid = (start + end) / 2;
		if (start <= end) {
			if (arr[mid] >= target) {
				leftCheck(start, mid - 1);
			} else if (arr[mid] < target) {
				leftCheck(mid + 1, end);
			}
		} else {
			left = arr[start] == target ? start : 0;
		}
	}

	public static void rightCheck(int start, int end) {
		int mid = (start + end) / 2;
		if (start <= end) {
			if (arr[mid] <= target)
				rightCheck(mid + 1, end);
			else if (arr[mid] > target)
				rightCheck(start, mid - 1);
		} else {
			right = arr[end] == target ? end : 0;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		target = sc.nextInt();
//		arr = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}

		leftCheck(0, n - 1);
		rightCheck(0, n - 1);

		if (left == 0 && right == 0)
			System.out.println(-1);
		else System.out.println(right - left + 1);
	}

}
