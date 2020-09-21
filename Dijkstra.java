package test;

import java.util.*;

class Node implements Comparable<Node> {

	private int index;
	private int distance;

	public Node(int index, int distance) {
		this.index = index;
		this.distance = distance;
	}

	public int getIndex() {
		return this.index;
	}

	public int getDistance() {
		return this.distance;
	}

	@Override
	public int compareTo(Node o) {
		if (this.distance < o.distance)
			return -1;

		return 1;
	}

}

public class Dijkstra {

	public static final int INF = (int) 1e9; // ������ �ǹ��ϴ� ������ 10���� ����

	// ����� ���� N ������ ���� M ���� ��� ��ȣ start
	// ����� ������ �ִ� 100,000 ����� ����
	public static int n, m, start;

	// �� ��忡 ����Ǿ� �ִ� ����忡 ���� ������ ��� �迭
	public static ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();

	// �ִܰŸ� ���̺� �����
	public static int[] d = new int[100001];

	public static void dijsatra(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(start, 0));
		d[start] = 0;
		while (!pq.isEmpty()) {
			// ���� �ִ� �Ÿ��� ª�� ��忡 ���� ���� ������
			Node node = pq.poll();
			int dist = node.getDistance(); // ���� �������� ���
			int now = node.getIndex(); // ���� ���
			// ���� ��尡 �̹� ó���� ���� �ִ� ����� ����
			if (d[now] < dist)
				continue;
			// ���� ���� ����� �ٸ� ������ ������ Ȯ��
			for (int i = 0; i < graph.get(now).size(); i++) {
				int cost = d[now] + graph.get(now).get(i).getDistance();
				if (cost < d[graph.get(now).get(i).getIndex()]) {
					d[graph.get(now).get(i).getIndex()] = cost;
					pq.offer(new Node(graph.get(now).get(i).getIndex(), cost));
				}
			}

		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		m = sc.nextInt();
		start = sc.nextInt();

		// �׷��� �ʱ�ȭ
		for (int i = 0; i <= n; i++) {
			graph.add(new ArrayList<Node>());
		}

		// ��� ���� ������ �Է¹ޱ�
		for (int i = 0; i < m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			// a���� b�� ���� ����� c��� �ǹ�
			graph.get(a).add(new Node(b, c));
		}

		Arrays.fill(d, INF);

		dijsatra(start);

		for (int i = 1; i <= n; i++) {
			if (d[i] == INF)
				System.out.println("INFINITY");
			else
				System.out.println(d[i]);
		}
	}

}
