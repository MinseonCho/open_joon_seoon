package test;

import java.util.Scanner;

public class Algorithm_prac_no7 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int result = 1;
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[][] map = new int[N][M];
		boolean[][] visited = new boolean[N][M];

		int x = sc.nextInt();
		int y = sc.nextInt();

		int way = sc.nextInt(); // 0 : �� , 1 : ��, 2 : ��, 3 : ��


		// ���⿡ �ش��ϴ� ���� ĭ
		int[] dx = { 0, -1, 0, 1 };
		int[] dy = { -1, 0, 1, 0 };

		int[] next_way = { 3, 0, 1, 2 };

		int[] back_x = { 1, 0, -1, 0 };
		int[] back_y = { 0, -1, 0, 1 };

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		int count = 0;
		while (true) {

			int tx = x + dx[way];
			int ty = y + dy[way];

			//������ ���� ĭ�� �湮�� ���߰�, ������ ���
			if (!visited[tx][ty] && map[tx][ty] == 0) {
				visited[tx][ty] = true;
				x = tx;
				y = ty;
				way = next_way[way];
				count = 0;
				result++;
			} else {
				//������ ���� ĭ�� �湮�� �߰ų� �ٴ��� ���
				count++;
				way = next_way[way];
			}

			//�ѹ����� ���Ҵµ� �׸��� �� �ٴٰų� �湮���� ���
			if (count == 4) {
				count = 0;
				int tmp_x = back_x[way];
				int tmp_y = back_y[way];
				if (map[tmp_x][tmp_y] == 0) { //�ڿ��� ������ ���
					x += tmp_x;
					y += tmp_y;
				} else //�ڰ� �ٴ��� ���
					break;
			}

		}

		System.out.println("result = " + result);
	}

}
