package test;

import java.util.Scanner;

public class Baekjoon_10809 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String s;
		s= sc.nextLine();
		
		sc.close();
		
		int[] a = new int[26];
		int[] array_word = new int[s.length()];
		for(int i=0; i<array_word.length; i++) {
			array_word[i] = (int)(s.charAt(i))-97;
		}
		for(int i=0; i<a.length; i++) {
			a[i] = -1;
		}
		
		for(int i=0; i<s.length(); i++) {
			
			if(a[array_word[i]] == -1)
				a[array_word[i]] = i;
			else
				continue;
		}
		
		for(int i=0; i<a.length; i++) {
			System.out.print(a[i] + " ");
		}
		
		
		
		
	}

}
