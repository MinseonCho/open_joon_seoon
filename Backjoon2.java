package test;

public class Backjoon2 {
	public static final int NUM_SIZE = 10001;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = new int[NUM_SIZE];
		
		for(int i = 1; i < NUM_SIZE; i++) {
			if(dCalculator(i) < 10001)
				arr[dCalculator(i)] = 1;
			else
				arr[0] = 0;
		}
		
		for(int i = 1; i < NUM_SIZE; i++) {
			if(arr[i] == 0)
				System.out.println(i);
		}

	}

	public static int dCalculator(int num) {
		int number = num; 
		int result = 0;
		
		while(number != 0) {
			result += number%10;
			number /= 10;
		}
		return result + num;
	}

}
