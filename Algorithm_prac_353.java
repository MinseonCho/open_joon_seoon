package test;

import java.awt.Point;
import java.util.*;

public class Algorithm_prac_353 {

	public static int n, l, r; // l <= �α����� <= r
	public static int[][] graph = new int[50][50];
	public static Queue<Point> que = new LinkedList<Point>();
	public static int[][] visited = new int[50][50];
	public static ArrayList<ArrayList<Point>> arrList = new ArrayList<>();
	public static int[] dx = { -1, 1, 0, 0 };
	public static int[] dy = { 0, 0, -1, 1 };
	public static int answer = 0;

	// ���� ã��
	public static void find(int x, int y) {
		ArrayList<Point> temp = new ArrayList<>();

		que.offer(new Point(x, y));
		temp.add(new Point(x, y));

		while (!que.isEmpty()) {
			Point now = que.poll();

			x = (int) now.getX();
			y = (int) now.getY();

			visited[x][y] = 1; // �湮ó��

			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];

				if (nx < 0 || nx >= n || ny < 0 || ny >= n)
					continue;
				if (visited[nx][ny] == 1)
					continue;
				int value = Math.abs(graph[x][y] - graph[nx][ny]);
				if (value >= l && value <= r) {
					que.offer(new Point(nx, ny));
					temp.add(new Point(nx, ny));
					visited[nx][ny] = 1; // �湮ó��
				}
			}

		}

		if (temp.size() != 1)
			arrList.add(temp);

	}

	// �α� �̵�
	public static void move() {

		for (int i = 0; i < arrList.size(); i++) {
			int sum = 0; // ���� �α��� ��
			int num = 0; // ���� ��
			ArrayList<Point> now = arrList.get(i);
			num = now.size();
			for (int j = 0; j < now.size(); j++) {
				sum += graph[(int) now.get(j).getX()][(int) now.get(j).getY()];
			}
			sum = sum / num;
			for (int j = 0; j < now.size(); j++) {
				graph[(int) now.get(j).getX()][(int) now.get(j).getY()] = sum;
			}
		}

		// �α� �̵� Ƚ�� ����
		answer++;

		// ���� ����Ʈ �ʱ�ȭ
		arrList.clear();
		visited = new int[50][50]; // �湮 �ʱ�ȭ
	}

	public static void print() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(graph[i][j] + " ");
			}
			System.out.println(" ");
		}

		System.out.println("-----------------------------");
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		l = sc.nextInt();
		r = sc.nextInt();

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				graph[i][j] = sc.nextInt();
			}
		}

		while (true) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (visited[i][j] == 0) {
						find(i, j);
					}
				}
			}
			// ���� ������ ������
			if (arrList.size() == 0)
				break;
			move();
		}

		System.out.println(answer);

	}

}
