package test;

import java.util.*;

class Elements implements Comparable<Elements> {
	private int x, y;
	private int a; // 0 : 기둥 , 1 : 보

	public Elements(int x, int y, int a) {
		this.x = x;
		this.y = y;
		this.a = a;
	}

	public int getX() {
		return this.x;
	}

	public int getY() {
		return this.y;
	}

	public int getA() {
		return this.a;
	}

	@Override
	public int compareTo(Elements o) {
		if (this.x == o.x && this.y == o.y)
			return Integer.compare(this.a, o.a);
		else if (o.x == this.x)
			return Integer.compare(this.y, o.y);
		else
			return Integer.compare(this.x, o.x);
	}
}

public class Algorithm_prac_329 {

	public static int n;
	public static int[][] build_frame = { { 0, 0, 0, 1 }, { 2, 0, 0, 1 }, { 4, 0, 0, 1 }, { 0, 1, 1, 1 },
			{ 1, 1, 1, 1 }, { 2, 1, 1, 1 }, { 3, 1, 1, 1 }, { 2, 0, 0, 0 }, { 1, 1, 1, 0 }, { 2, 2, 0, 1 } };
	public static ArrayList<Elements> arrList = new ArrayList<Elements>();

	public static void main(String[] args) {

		for (int i = 0; i < build_frame.length; i++) {
			int[] info = build_frame[i];
			int x = info[0];
			int y = info[1];
			int a = info[2]; // 0 : 기둥 , 1 : 보
			int b = info[3]; // 0 : delete , 1 : set up

			// 설치
			if (b == 1) {
				// 기둥,보 모두 설치해보고 규칙에 안맞으면 다시 제거
				arrList.add(new Elements(x, y, a));
				if (!check_())
					arrList.remove(arrList.size() - 1);
			} else { // 삭제
				for (int j = 0; j < arrList.size(); j++) {
					Elements tmp = arrList.get(j);
					if (tmp.getX() == x && tmp.getY() == y && tmp.getA() == a) {
						arrList.remove(j);
						if (!check_())
							arrList.add(new Elements(tmp.getX(), tmp.getY(), tmp.getA()));
					}
				}
			}
		}

		Collections.sort(arrList);
		for (int i = 0; i < arrList.size(); i++) {
			System.out.println(arrList.get(i).getX() + " " + arrList.get(i).getY() + " " + arrList.get(i).getA());
		}
	}

	// 다 정상인지 검사
	public static boolean check_() {

		for (int i = 0; i < arrList.size(); i++) {
			int x = arrList.get(i).getX();
			int y = arrList.get(i).getY();
			int a = arrList.get(i).getA();

			// 기둥 세우기 위한 체크
			if (a == 0) {
				if (y == 0) // 바닥에 세워져 있으면
					continue;

				boolean flag = false;

				for (int j = 0; j < arrList.size(); j++) {
					int tx = arrList.get(j).getX();
					int ty = arrList.get(j).getY();
					int ta = arrList.get(j).getA();

					// 보가 있으면
					if (x - 1 == tx && y == ty && ta == 1)
						flag = true;
					else if (x == tx && y == ty && ta == 1)
						flag = true;
					else if (x == tx && y - 1 == ty && ta == 0) // 아래 기둥이 있으면
						flag = true;
				}
				if (!flag)
					return false;
			} else { // 보라면
				if (y == 0) // 바닥이면
					return false;

				boolean flag = false;
				boolean left = false;
				boolean right = false;
				for (int j = 0; j < arrList.size(); j++) {
					int tx = arrList.get(j).getX();
					int ty = arrList.get(j).getY();
					int ta = arrList.get(j).getA();

					// 기둥이 있으면
					if (x == tx && y - 1 == ty && ta == 0) 
						flag = true;
					else if (x + 1 == tx && y - 1 == ty && ta == 0)
						flag = true;
					else if (x - 1 == tx && y == ty && ta == 1)
						// 양쪽에 보가 있는지
						left = true;
					else if (x + 1 == tx && y == ty && ta == 1)
						right = true;

				}
				if (left && right)
					flag = true;

				if (!flag)
					return false;
			}
		}
		return true;
	}

}
