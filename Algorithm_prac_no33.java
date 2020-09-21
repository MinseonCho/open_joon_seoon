package test;

import java.util.*;

public class Algorithm_prac_no33 {

	private static ArrayList<Poin> chicken = new ArrayList<>(); // ġŲ�� ��ǥ
	private static ArrayList<Poin> house = new ArrayList<>(); // ġŲ�� ��ǥ

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt(); // �ִ� m���� ġŲ��

		// 0: ��ĭ, 1: ��, 2: ġŲ��
		for (int i = 1; i < n + 1; i++) {
			for (int j = 1; j < n + 1; j++) {
				int tmp = sc.nextInt();
				if (tmp == 2)
					chicken.add(new Poin(i, j));
				if (tmp == 1)
					house.add(new Poin(i, j));
			}
		}
		int answer = (int) 1e9;
		for (int w = 1; w < m + 1; w++) {
			Poin[] selected = new Poin[w]; // ���õ� m���� ġŲ������ ��ǥ
			int idx = w - 1;
			int start = 0;
			while (start + idx < chicken.size()) {
				int by = start + idx;
				int s = 0;
				for (; start < by; start++) {
					selected[s++] = chicken.get(start);
				}
				for (int i = by; i < chicken.size(); i++) {
					selected[w - 1] = chicken.get(i); // ������ Poin ����

					int min = (int) 1e9;
					int sum = 0;
					for (int j = 0; j < house.size(); j++) { // �Ͽ콺����
						int x = house.get(j).x;// �� ��ǥ x
						int y = house.get(j).y;// �� ��ǥ y
						for (int k = 0; k < w; k++) { // �� �Ͽ콺�� ���õ� ġŲ���� ��� �Ÿ� ���
							int value = Math.abs(x - selected[k].x) + Math.abs(y - selected[k].y);
							min = (value < min) ? value : min; // ���õ� ġŲ�� �� ���� ����� �Ÿ�
						}
						sum += min; // �� �� ġŲ�Ÿ��� ��
						min = (int) 1e9;
					}
					System.out.println("�? " + w + "  sum : " + sum);
					answer = (sum < answer) ? sum : answer; // ������ ġŲ�Ÿ� ���� �����ɷ�
				}
				start++;

			}
		}
		System.out.println(answer);
	}

}
