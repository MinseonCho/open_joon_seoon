package test;

import java.util.*;

// ��հ� �� ��ġ 329p

class Build implements Comparable<Build> {
	private int x, y, type;

	public Build(int x, int y, int type) {
		this.x = x;
		this.y = y;
		this.type = type;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	@Override
	public int compareTo(Build o) {
		if (this.x < o.getX())
			return -1;
		else if (this.x == o.getX()) {
			if (this.y == o.getY()) {
				return this.type > o.getType() ? 1 : -1;
			} else
				return this.y > o.getY() ? 1 : -1;
		} else
			return 1;
	}

}

public class Algorithm_prac_no32 {

	private static int[][] build_frame = { { 0, 0, 0, 1 }, { 0, 1, 1, 1 }, { 1, 1, 0, 1 }, { 1, 2, 1, 1 },
			{ 3, 0, 0, 1 }, { 2, 1, 1, 1 }, { 2, 1, 0, 1 } };
	private static ArrayList<Build> list = new ArrayList<>();

	private static void solution() {
		for (int i = 0; i < build_frame.length; i++) {
			int[] data = build_frame[i];
			int x = data[0];
			int y = data[1];
			int a = data[2]; // 0 : ���, 1 : ��
			int b = data[3]; // 0 : ����, 1 : ��ġ

			if (b == 1) {
				// ��ġ��
				if (setup(x, y, a)) {
					list.add(new Build(x, y, a));
				}
			} else {
				delete(x, y, a);
			}
		}

		Collections.sort(list);
		for (Build o : list) {
			System.out.println(o.getX() + " " + o.getY() + " " + o.getType());
		}
	}

	private static boolean check() {
		Collections.sort(list);
		boolean result = true;
		for (Build tmp : list) {
			int x = tmp.getX();
			int y = tmp.getY();
			int a = tmp.getType();

			if (a == 0) { // ����� ��
				if (y == 0)
					continue;
				else {
					boolean flag = false; // ����� ������ true�� �ٲ�
					for (Build t : list) {
						if (t.getX() == x && t.getY() == y - 1 && t.getType() == a) { // �ؿ� ���������
							flag = true;
							break;
						}
						if ((t.getX() == x && t.getY() == y && t.getType() == 1)
								|| (t.getX() == x - 1 && t.getY() == y && t.getType() == 1)) { // �ؿ� ���� ������
							flag = true;
							break;
						}
					}
					if (flag)
						continue;
					else {
						result = false; // ����� �ٴڿ� ������ �ִ� �͵� �ƴϰ�, �Ʒ� ����� �ִ� �͵� �ƴϰ�, ���� �ִ� �͵� �ƴϸ� result = false;
						break;
					}
				}

			} else {
				// ���� ��
				boolean flag_b = false; // ���ʿ� ���� �ִ��� Ȯ��
				boolean flag = false; // ���ʿ� ���� �ִ��� ����
				boolean flag_p = false;
				for (Build t : list) {
					if (t.getX() == x - 1 && t.getY() == y && t.getType() == 1) { // ������ ���� ������
						if (flag_b) {
							// ����, �����ʿ� ��� ���� ������
							result = true;
							flag = true;
							break;
						} else {
							flag_b = true;
							continue;
						}
					}
					if (t.getX() == x + 1 && t.getY() == y && t.getType() == 1) { // �������� ���� ������
						if (flag_b) {
							// ����, �����ʿ� ��� ���� ������
							result = true;
							flag = true;
							break;
						} else {
							flag_b = true;
							continue;
						}
					}
					// �� ���� �Ʒ��� ����� �ϳ��� ������
					if ((t.getX() == x && t.getY() == y - 1 && t.getType() == 0)
							|| (t.getX() == x + 1 && t.getY() == y - 1 && t.getType() == 0)) {
						result = true;
						flag_p = true;
						break;
					}
				}

				if (!flag_p && !flag) {
					result = false;
					break;
				}
			}
		}

		return result;
	}

	private static boolean delete(int x, int y, int a) {
		boolean result = false;
		for (int i = 0; i < list.size(); i++) {
			int tmp_x = list.get(i).getX();
			int tmp_y = list.get(i).getY();
			int tmp_a = list.get(i).getType();
			if (tmp_x == x && tmp_y == y && tmp_a == a) {
				list.remove(i);
			}

		}

		if (!check()) {
			// �����Ұ��� �ٽ� �־�..
			list.add(new Build(x, y, a));
		}

		return result;
	}

	private static boolean setup(int x, int y, int a) {
		boolean result = false;
		if (a == 0) {
			// ��� ��ġ�� ���
			if (y == 0) // �ٴڿ� ��ġ�ϴ� ���
				result = true;
			else {
				for (Build tmp : list) {
					// ���� ��ġ �Ʒ��� ����� �ִ��� ���� �˻�
					if (tmp.getX() == x && tmp.getY() == y - 1 && tmp.getType() == 0) {
						result = true;
						break;
					}
					// �� ���� ������ �� �ִ��� Ȯ��
					if ((tmp.getX() == x - 1 && tmp.getY() == y && tmp.getType() == 1)
							|| (tmp.getX() == x && tmp.getY() == y && tmp.getType() == 1)) {
						result = true;
						break;
					}
				}
			}

		} else {
			// �� ��ġ�� ���
			int num = 0; // �� ����, 2�̸� true
			if (y == 0) {
				result = false;
			} else {
				for (Build tmp : list) {
					// ���ʿ� ����� �ϳ��� �ִ��� �˻�
					if (tmp.getX() == x && tmp.getY() == y - 1 && tmp.getType() == 0) {
						result = true;
						break;
					}
					if (tmp.getX() == x + 1 && tmp.getY() == y - 1 && tmp.getType() == 0) {
						result = true;
						break;
					}
					// ���ʿ� ���� �ִ��� �˻�
					if (tmp.getX() == x - 1 && tmp.getY() == y && tmp.getType() == 1) {
						num++;
					}
					if (tmp.getX() == x + 1 && tmp.getY() == y && tmp.getType() == 1) {
						num++;
					}
					if (num == 2) {
						result = true;
						break;
					} else
						continue;

				}
			}
		}
		return result;
	}

	public static void main(String[] args) {
		solution();
	}

}
