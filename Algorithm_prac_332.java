package test;

import java.util.*;
// ġŲ �Ÿ�

class Position {
	private int x;
	private int y;

	public Position(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return this.x;
	}

	public int getY() {
		return this.y;
	}
}

class Combination {
	private int n;
	private int r;
	private int[] now;
	private ArrayList<ArrayList<Position>> arrList;

	public Combination(int n, int r) {
		this.n = n;
		this.r = r;
		this.now = new int[r];
		this.arrList = new ArrayList<ArrayList<Position>>();
	}

	public void combination(ArrayList<Position> arr, int depth, int index, int target) {
		if (depth == r) {

			ArrayList<Position> tmp = new ArrayList<>();
			for (int i = 0; i < now.length; i++) {
				tmp.add(arr.get(now[i]));
				System.out.print(now[i] + " ");
			}
			System.out.println(" ");
			arrList.add(tmp);
			return;
		}

		if (target == n)
			return;
		now[index] = target;
		combination(arr, depth + 1, index + 1, target + 1); // Ÿ���� ���� �ܿ�
		combination(arr, depth, index, target + 1); // Ÿ���� �Ȼ��� ���
	}

	public ArrayList<ArrayList<Position>> getArrayList() {
		return this.arrList;
	}

}

public class Algorithm_prac_332 {

	public static int n, m; // ġŲ���� ���� �ִ� M��
	public static ArrayList<Position> home = new ArrayList<>();
	public static ArrayList<Position> store = new ArrayList<>();

	// ���õ� ġŲ���� ��� �������� ġŲ�Ÿ��� ��
	public static int getSum(ArrayList<Position> stores) {
		int result = 0;
		for (int i = 0; i < home.size(); i++) {
			int hx = home.get(i).getX();
			int hy = home.get(i).getY();

			int tmp = (int) 1e9;
			for (int j = 0; j < stores.size(); j++) {
				int cx = stores.get(j).getX();
				int cy = stores.get(j).getY();

				tmp = Math.min(tmp, Math.abs(hx - cx) + Math.abs(hy - cy));
			}

			result += tmp;
		}
		return result;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		m = sc.nextInt();

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				int tmp = sc.nextInt();
				if (tmp == 1)
					home.add(new Position(i, j));
				if (tmp == 2)
					store.add(new Position(i, j));
			}
		}

		// �Է� ��

		Combination cb = new Combination(store.size(), m);
		cb.combination(store, 0, 0, 0);
		ArrayList<ArrayList<Position>> candidates = cb.getArrayList();

		int min = (int) 1e9;
		for (int i = 0; i < candidates.size(); i++) {
			min = Math.min(min, getSum(candidates.get(i)));
		}
		System.out.println(min);
	}

}
