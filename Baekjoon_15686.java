package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Baekjoon_15686 {

	static int[][] map;
	static ArrayList<Point> house;
	static ArrayList<Point> chicken;
	static int N,M;
	static boolean[] visited;
	static int[] output;
	static int result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 
        String[] str = br.readLine().split(" ");
        N = Integer.parseInt(str[0]);
        M = Integer.parseInt(str[1]);
		map = new int[N][N];
		chicken = new ArrayList<Point>();
		house = new ArrayList<Point>();
		result = Integer.MAX_VALUE;
		
		//Start input

        for (int i = 0; i < N; i++) {
            str = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(str[j]);
                if (map[i][j] == 1) {
                    //1�϶��� ��� list�� �߰�
                    house.add(new Point(i, j));
                } else if (map[i][j] == 2) {
                    //2�϶��� ġŲ list�� �߰�
                    chicken.add(new Point(i, j));
                }
            }
        }
		//input end
		
		//ġŲ �� ������ ���� �迭 visited, output
		visited = new boolean[chicken.size()];
		output = new int[chicken.size()];
		
		//ġŲ�� ����
		for(int r=0; r<chicken.size(); r++) {
			visited[r] = true;
			selection(r,0);
			visited[r] = false;
		}
		System.out.println(result);
	}
	
	//ġŲ�� ����Ǽ� ���ϴ� �޼ҵ�
	public static void selection(int st, int dep) {
		output[dep] = st +1;
		
		for(int i=st; i<chicken.size(); i++) {
			if(visited[i])
				continue;
			visited[i] = true;
			selection(i,dep +1);
			visited[i] = false;
		}
		//ġŲ���� ���õǾ��� ���
		if(dep == M - 1) {
			int sum =0; 
			int currentM = 0;
			
			for(int i=0; i<house.size(); i++) {
				int min = Integer.MAX_VALUE;
				for(int j=0; j<M; j++) {
					currentM = calculate(house.get(i), chicken.get(output[j] -1));
					min = Math.min(min,  currentM);
				}
				
				//�ּҰ��� ��� ���Ѵ�
				sum = sum + min;
			}
			
			result = Math.min(sum,result); //���ո��� �ּҰ� ��
		}
	}
	

	public static int calculate(Point d1, Point d2) {
		return Math.abs(d1.x - d2.x) + Math.abs(d1.y - d2.y);
	}

}

class Point {
	int x;
	int y;
	
	Point(int x, int y){
		this.x = x;
		this.y = y;
	}
}