package test;

import java.util.*;

public class Algorithm_prac_363 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		PriorityQueue<Integer> que = new PriorityQueue<>();
		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			que.offer(sc.nextInt());
		}

		int sum = 0;
		while (que.size() > 1) {
			int temp =  que.poll() + que.poll();
			sum += temp;
			que.offer(temp);
		}

	
		System.out.println(sum);
	}

}
