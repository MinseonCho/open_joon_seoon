package test;

import java.util.*;

// �� 327p
class Snake {
	int sec;
	char direction;

	public Snake(int sec, char direction) {
		this.sec = sec;
		this.direction = direction;
	}
}

public class Algorithm_prac_no31 {

	private static int[][] matrix;
	private static ArrayList<Snake> direction = new ArrayList<>();
	private static ArrayList<Poin> snake = new ArrayList<>();
	private static int[] x_ = { -1, 0, 1, 0 }; // ��(0), ��(1), ��(2) , ��(3)
	private static int[] y_ = { 0, 1, 0, -1 };
	private static int dir = 1; // ó���� ������ �ٶ󺸰� ����
	private static int answer = 0; // �귯���� ��
	private static int x = 1, y = 1; // ���� ���۰� ��

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt(); // ������ ũ��
		matrix = new int[n + 1][n + 1];

		int k = sc.nextInt(); // ��� ����
		for (int i = 0; i < k; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			matrix[x][y] = -1; // ��� ��ġ ��Ŵ
		}

		int l = sc.nextInt(); // ���� ���� ��ȯ Ƚ��
		for (int i = 0; i < l; i++) {
			int s = sc.nextInt();
			char d = sc.next().charAt(0);
			direction.add(new Snake(s, d));
		}
		matrix[x][y] = 1; // �� �ʱ� ��ġ ����
		snake.add(new Poin(x, y));

		while (true) {
			// ������ ��ĭ ������
			int tmp_x = x + x_[dir];
			int tmp_y = y + y_[dir];

			// �����ΰ� ���� �ƴ϶��
			if (tmp_x <= n && tmp_x > 0 && tmp_y <= n && tmp_y > 0 && matrix[tmp_x][tmp_y] != 1) {
				x = tmp_x;
				y = tmp_y;
				snake.add(new Poin(x, y));
				// ��ġ�� ���� ����� �ִٸ�
				if (matrix[x][y] == -1) {
					matrix[x][y] = 1;
				} else {
					matrix[x][y] = 1;
					matrix[snake.get(0).x][snake.get(0).y] = 0;
					snake.remove(0);

				}

			} else {
				// ����
				answer++;
				break;
			}
			// �ش� �ʿ� ������ �ٲ���ϴ��� �˻�
			answer++;
			if (!direction.isEmpty() && answer == direction.get(0).sec) {
				if (direction.get(0).direction == 'D') { // ���������� ���� ȸ��
					dir++;
					if (dir > 3)
						dir = 0;
				} else { // �������� ���� ȸ��
					dir--;
					if (dir < 0)
						dir = 3;
				}
				direction.remove(0);
			}
		}

		System.out.println(answer);

	}

}
