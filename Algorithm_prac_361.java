package test;

import java.util.*;

class Stages implements Comparable<Stages> {
	int stage;
	double fail;

	public Stages(int stage, double fail) {
		this.stage = stage;
		this.fail = fail;
	}

	@Override
	public int compareTo(Stages o) {
		if (this.fail == o.fail)
			return Integer.compare(this.stage, o.stage);
		return Double.compare(o.fail, this.fail);
	}
}

class Solutions {
	public int[] solution(int N, int[] stages) {
		int[] answer = new int[N];
		int num = stages.length; // ¸í ¼ö
		int[] arr = new int[N + 2];
		ArrayList<Stages> arrList = new ArrayList<>();

		for (int i = 0; i < stages.length; i++) {
			arr[stages[i]]++;
		}
		for (int i = 1; i < arr.length - 1; i++) {
			double tmp = arr[i] == 0 ? 0 : (double) arr[i] / (double) num;
			System.out.println(arr[i] + " " + num + " " + tmp);
			arrList.add(new Stages(i, tmp));
			num -= arr[i];
		}

		Collections.sort(arrList);
		for (int i = 0; i < arrList.size(); i++) {
			answer[i] = arrList.get(i).stage;
		}

		for (int i = 0; i < answer.length; i++) {
			System.out.println(answer[i]);
		}
		return answer;
	}
}

public class Algorithm_prac_361 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		Solutions sol = new Solutions();
		int[] stages = { 1,1,1,1,1,2 };
		sol.solution(4, stages);

	}

}
