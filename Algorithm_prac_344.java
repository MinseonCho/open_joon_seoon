package test;

import java.util.*;

class Spread implements Comparable<Spread> {
	private int x;
	private int y;
	private int sec;
	private int number;

	public Spread(int x, int y, int sec, int number) {
		this.x = x;
		this.y = y;
		this.sec = sec;
		this.number = number;
	}

	public int getX() {
		return this.x;
	}

	public int getY() {
		return this.y;
	}

	public int getSec() {
		return this.sec;
	}

	@Override
	public int compareTo(Spread o) {
		return Integer.compare(this.number, o.number);
	}

}

public class Algorithm_prac_344 {

	public static int n, k, s, x, y; // k : 바이러스의 종류
	public static int[][] graph;
	public static int[] dx = { -1, 1, 0, 0 };
	public static int[] dy = { 0, 0, -1, 1 };
	public static Queue<Spread> que = new LinkedList<Spread>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		k = sc.nextInt();

		graph = new int[n][n];
		ArrayList<Spread> forsort = new ArrayList<Spread>();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				graph[i][j] = sc.nextInt();
				if (graph[i][j] != 0)
					forsort.add(new Spread(i, j, 0, graph[i][j]));
			}
		}

		s = sc.nextInt();
		x = sc.nextInt();
		y = sc.nextInt();

		Collections.sort(forsort);

		for (int i = 0; i < forsort.size(); i++) {
			que.offer(forsort.get(i));
		}

		spread();

		System.out.println(graph[x - 1][y - 1]);
	}

	public static void spread() {
		while (!que.isEmpty()) {
			Spread now = que.poll();
			if (now.getSec() == s)
				return;
			for (int i = 0; i < 4; i++) {
				int nx = now.getX() + dx[i];
				int ny = now.getY() + dy[i];

				if (nx >= n || nx < 0 || ny >= n || ny < 0)
					continue;
				if (graph[nx][ny] == 0) {
					graph[nx][ny] = graph[now.getX()][now.getY()]; // 비어있으면 바이러스 번식
					que.offer(new Spread(nx, ny, now.getSec() + 1, now.getSec()));
				}
			}
		}

	}

}
