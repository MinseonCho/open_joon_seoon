package test;

import java.util.Arrays;
import java.util.Scanner;

//���谡 ��� 311p

public class Algorithm_prac_no20 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] data = new int[n];
		for (int i = 0; i < n; i++) {
			data[i] = sc.nextInt();
		}

		int cnt = 0; // �� �׷��� ��

		Arrays.sort(data);

		int t = 1; // ���� �׷쿡 ���Ե� ���谡�� ��
		for (int i = 0; i < n; i++) {
			if (t >= data[i]) {
				cnt++;
				t = 1;
				continue;
			}
			t++;
		}

		System.out.println("result = " + cnt);
	}

}
