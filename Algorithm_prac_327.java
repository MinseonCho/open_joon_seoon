package test;

import java.awt.Point;
import java.util.*;

class Direction {
	private int time;
	private char dir;

	public Direction(int time, char dir) {
		this.time = time;
		this.dir = dir;
	}

	public int getTime() {
		return time;
	}

	public char getDir() {
		return dir;
	}
}

public class Algorithm_prac_327 {

	public static int n, k, l;
	public static ArrayList<Point> apple = new ArrayList<Point>();
	public static ArrayList<Point> snake = new ArrayList<Point>();
	public static ArrayList<Direction> way = new ArrayList<Direction>();
	// �� �� �� ��
	public static int[] dx = { -1, 0, 1, 0 };
	public static int[] dy = { 0, 1, 0, -1 };
	public static int dir = 1; // �ʱ⿡ ������(��) ��������
	public static int sec = 0; // ��

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt(); // �� ũ��
		k = sc.nextInt(); // ����� ����

		// ��� ��ġ �Է¹ޱ�
		for (int i = 0; i < k; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();

			apple.add(new Point(x, y));
		}

		l = sc.nextInt();
		// ���� ��ȯ ���� �Է¹ޱ�
		for (int i = 0; i < l; i++) {
			int time = sc.nextInt();
			char dir = sc.next().charAt(0);
			way.add(new Direction(time, dir));
		}

		// �Է� ����

		snake.add(new Point(1, 1));
		while (true) {

			int len = snake.size();
			int nx = snake.get(len - 1).x + dx[dir];
			int ny = snake.get(len - 1).y + dy[dir];

			// ���� ���̸�
			if (nx > n || nx <= 0 || ny > n || ny <= 0) {
				// sec++;
				break;
			}

			// ������ ���� ���� �ִ� ���̸�
			for (int i = 0; i < snake.size(); i++) {
				if (snake.get(i).getX() == nx && snake.get(i).getY() == ny) {
					System.out.println(++sec);
					return;
				}
			}

			// �� ��ĭ ����
			snake.add(new Point(nx, ny));
			boolean flag = false;

			for (int i = 0; i < apple.size(); i++) {
				// ������ ���� ����� ������
				if (apple.get(i).getX() == nx && apple.get(i).getY() == ny) {
					flag = true;
					apple.remove(i); // ���� ��� ����
					break;
				}
			}

			if (!flag)
				snake.remove(0);

			sec++;
			// �ش��ϴ� ����� ������
			if (way.size() > 0 && way.get(0).getTime() == sec) {
				int time = way.get(0).getTime();
				char turn = way.get(0).getDir();
				way.remove(0);

				// ���������� 90�� ȸ��
				if (turn == 'D') {
					dir++;
					if (dir > 3)
						dir = 0;
				} else {
					// �������� 90�� ȸ��
					dir--;
					if (dir < 0)
						dir = 3;
				}
			}

		}

		System.out.println(++sec);

	}

}
