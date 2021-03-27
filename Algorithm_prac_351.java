package test;

import java.awt.Point;
import java.util.*;

public class Algorithm_prac_351 {

	public static int n;
	public static char[][] graph;
	public static ArrayList<Point> tch = new ArrayList<>();
	public static boolean flag = false;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		graph = new char[n][n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				char ch = sc.next().charAt(0);
				graph[i][j] = ch;
				if (ch == 'T')
					tch.add(new Point(i, j));
			}
		}
		
		dfs(0,0,0);
		
		if(flag) System.out.println("YES");
		else System.out.println("NO");
	}

	public static boolean check() {
		int[] dx = { -1, 1, 0, 0 };
		int[] dy = { 0, 0, -1, 1 };
		for (int i = 0; i < tch.size(); i++) {
			int x = (int) tch.get(i).getX();
			int y = (int) tch.get(i).getY();
			for (int j = 0; j < 4; j++) {
				int nx = x + dx[j];
				int ny = y + dy[j];
				while (nx < n && nx >= 0 && ny < n && ny >= 0) {
					if (graph[nx][ny] == 'O')
						break;
					else if (graph[nx][ny] == 'S')
						return false;

					nx += dx[j];
					ny += dy[j];
				}
			}
		}
		

		return true;
	}

	
	// 다시봐..!!!!! 이게 맞어 미친
	public static void dfs(int x, int y, int cnt) {
		
		if (cnt == 3) {
			if (check()) {
				flag = true;
			}
			return;
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				// X 표시에 cnt가 3이 될때까지 O 로 변환.
				// 3이되면 check하고 flag = true 일 때 종료,
				// flag = false이면 O로 바꿧던 곳 다시 X를 채우고 다음 칸 계속 검사
				if (graph[i][j] == 'X') {
					graph[i][j] = 'O';
					dfs(i, j, cnt + 1);
					graph[i][j] = 'X';
					
					if(flag) return;
				}
			}
		}

	}

}
