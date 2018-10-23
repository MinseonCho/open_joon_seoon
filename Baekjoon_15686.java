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
                    //1일때는 사람 list에 추가
                    house.add(new Point(i, j));
                } else if (map[i][j] == 2) {
                    //2일때는 치킨 list에 추가
                    chicken.add(new Point(i, j));
                }
            }
        }
		//input end
		
		//치킨 집 선택을 위한 배열 visited, output
		visited = new boolean[chicken.size()];
		output = new int[chicken.size()];
		
		//치킨집 선택
		for(int r=0; r<chicken.size(); r++) {
			visited[r] = true;
			selection(r,0);
			visited[r] = false;
		}
		System.out.println(result);
	}
	
	//치킨집 경우의수 구하는 메소드
	public static void selection(int st, int dep) {
		output[dep] = st +1;
		
		for(int i=st; i<chicken.size(); i++) {
			if(visited[i])
				continue;
			visited[i] = true;
			selection(i,dep +1);
			visited[i] = false;
		}
		//치킨집이 선택되었을 경우
		if(dep == M - 1) {
			int sum =0; 
			int currentM = 0;
			
			for(int i=0; i<house.size(); i++) {
				int min = Integer.MAX_VALUE;
				for(int j=0; j<M; j++) {
					currentM = calculate(house.get(i), chicken.get(output[j] -1));
					min = Math.min(min,  currentM);
				}
				
				//최소값일 경우 더한다
				sum = sum + min;
			}
			
			result = Math.min(sum,result); //조합마다 최소값 비교
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