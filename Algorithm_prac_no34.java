package test;

import java.util.Scanner;

public class Algorithm_prac_no34 {

	public static int solution(int n, int[] weak, int[] dist) {
		int answer = 0;
		int[] data = new int[n];
		for (int num : weak)
			data[num] = 1; // ���� �κ� -1

		// �� ���� �˻�, �� ���� �˻� .... dist.length���� �˻����
		for (int i = 1; i <= dist.length; i++) {
			for (int j = 0; j + i <= dist.length; j++) {
				for (int start : weak) { // ������ �ٸ���
					int tmp = dist[j];
					while (tmp > 0) {

						if (data[start] == -1) {
							data[start] = 0;
						}
						if (!data.toString().contains("-1")) {
							answer = i;
							break;
						}
						start++;
						tmp--;
						if (start >= n)
							start = 0; // ������ ���� �ٽ� �ε��� 0����
					}
					if (answer != 0)
						break;
				}
				if (answer != 0)
					break;
			}
			data = new int[n];
			for (int num : weak)
				data[num] = 1;
			if (answer != 0)
				break;
		}

		return answer; // ��� ������ �����ϱ� ���� ������ �ϴ� ģ�� ���� �ּڰ�
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt(); // �ܺ��� ����
		int[] weak = { 1, 5, 6, 10 }; // ��� ������ ��ġ
		int[] dist = { 1, 2, 3, 4 }; // �� ģ���� 1�ð� ���� �̵��� �� �ִ� �Ÿ�

		System.out.println(solution(n, weak, dist));

	}

}
