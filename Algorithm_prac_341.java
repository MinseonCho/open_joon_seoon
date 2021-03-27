package test;

import java.util.*;

public class Algorithm_prac_341 {

	public static int n, m;
	public static int max = 0;
	public static int[][] graph, temp;
	public static int[] dx = { -1, 1, 0, 0 };
	public static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();

		graph = new int[n][m];
		temp = new int[n][m];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				graph[i][j] = sc.nextInt();
			}
		}

		dfs(0);

		System.out.println(max);
	}

	public static void dfs(int count) {

		if (count == 3) {
			for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    temp[i][j] = graph[i][j];
                }
            }
			
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (temp[i][j] == 2) {
						virus(i,j);
					}
				}
			}
			
			max = Math.max(max, getSum());
			return;
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {

				if (graph[i][j] == 0) {
					graph[i][j] = 1;
					count++;
					dfs(count);
					graph[i][j] = 0;
					count--;
				}

			}
		}

	}

	public static void virus(int x, int y) {
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx < 0 || nx >= n || ny < 0 || ny >= m)
				continue;

			if (temp[nx][ny] == 0) {
				temp[nx][ny] = 2;
				virus(nx, ny);
			}
		}
	}

	// 안전 영역 개수 반환
	public static int getSum() {
		int result = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (temp[i][j] == 0)
					result++;
			}
		}

		return result;
	}

}
