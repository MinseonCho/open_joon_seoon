package test;

import java.util.Scanner;

public class Baekjoon_1074 {

	static int r,c;
	static int cnt=0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n;
		n=sc.nextInt();
		r=sc.nextInt();
		c=sc.nextInt();
		
		sc.close();
		recursion((int) Math.pow(2, n),0,0);
		
		
		
	}
	
	public static void recursion(int len, int x, int y) {
		
		if(x==r && y==c) { 
			System.out.println(cnt);
			System.exit(0);
		}
		if(len==1) {
			cnt++;
			return;
		}
		if(!(x <= r && r < len + x && y <= c && c < len + y)) {
			cnt += len*len;
			return; //이 분단엔 없으니 들르는 수 더해주고 빠져나가기
		}
			
		recursion(len/2,x,y);
		recursion(len/2,x,y+len/2);
		recursion(len/2,x+len/2,y);
		recursion(len/2,x+len/2,y+len/2);
		
			
	}

}
