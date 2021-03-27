package test;

import java.awt.Point;
import java.util.*;

public class Algorithm_prac_353 {

	public static int n, l, r; // l <= 인구차이 <= r
	public static int[][] graph = new int[50][50];
	public static Queue<Point> que = new LinkedList<Point>();
	public static int[][] visited = new int[50][50];
	public static ArrayList<ArrayList<Point>> arrList = new ArrayList<>();
	public static int[] dx = { -1, 1, 0, 0 };
	public static int[] dy = { 0, 0, -1, 1 };
	public static int answer = 0;

	// 연합 찾기
	public static void find(int x, int y) {
		ArrayList<Point> temp = new ArrayList<>();

		que.offer(new Point(x, y));
		temp.add(new Point(x, y));

		while (!que.isEmpty()) {
			Point now = que.poll();

			x = (int) now.getX();
			y = (int) now.getY();

			visited[x][y] = 1; // 방문처리

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
					visited[nx][ny] = 1; // 방문처리
				}
			}

		}

		if (temp.size() != 1)
			arrList.add(temp);

	}

	// 인구 이동
	public static void move() {

		for (int i = 0; i < arrList.size(); i++) {
			int sum = 0; // 연합 인구의 총
			int num = 0; // 연합 수
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

		// 인구 이동 횟수 증가
		answer++;

		// 연합 리스트 초기화
		arrList.clear();
		visited = new int[50][50]; // 방문 초기화
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
			// 연합 국가가 없으면
			if (arrList.size() == 0)
				break;
			move();
		}

		System.out.println(answer);

	}

}
