package test;

import java.util.*;

public class Algorithm_prac_349 {

	public static int[] num = new int[11];
	public static ArrayList<Character> oper = new ArrayList<>();
	public static int min = (int) 1e9, max = (int) -1e9;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			num[i] = sc.nextInt();
		}

		for (int i = 0; i < 4; i++) {
			int tmp = sc.nextInt();
			if (i == 0) {
				for (int j = 0; j < tmp; j++) {
					oper.add('+');
				}
			} else if (i == 1) {
				for (int j = 0; j < tmp; j++) {
					oper.add('-');
				}
			} else if (i == 2) {
				for (int j = 0; j < tmp; j++) {
					oper.add('*');
				}
			} else {
				for (int j = 0; j < tmp; j++) {
					oper.add('/');
				}
			}
		}
		
		int[] output = new int[oper.size()];
		boolean[] visited = new boolean[oper.size()];

		perm(output, visited, 0, oper.size(), oper.size());

	
		System.out.println(max);
		System.out.println(min);
	}

	static void calculate(int[] output) {
		int result = num[0];
		for (int i = 0; i < output.length; i++) {
			char o = oper.get(output[i]);

			switch (o) {
			case '+':
				result += num[i + 1];
				break;
			case '-':
				result -= num[i + 1];
				break;
			case '*':
				result *= num[i + 1];
				break;
			case '/':
				result /= num[i + 1];
				break;
			}

		}

		min = Math.min(min, result);
		max = Math.max(max, result);
	}

	static void perm(int[] output, boolean[] visited, int depth, int n, int r) {
		if (depth == r) {
			calculate(output);
			return;
		}

		for (int i = 0; i < n; i++) {
			if (visited[i] != true) {
				visited[i] = true;
				output[depth] = i;
				perm(output, visited, depth + 1, n, r);
				output[depth] = 0; // 이 줄은 없어도 됨
				visited[i] = false;
			}
		}
	}

}
