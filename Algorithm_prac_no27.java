package test;

import java.util.*;

// ���ڿ� ������ 322p

public class Algorithm_prac_no27 {
	private static String s;
	private static ArrayList<Character> data = new ArrayList<>();
	private static int num;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		s = sc.next();
		num = 0;

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) < 58 && s.charAt(i) > 46) {
				// 0~9 �� ���
				num += s.charAt(i) - '0';
			} else {
				// ���ĺ� �빮���� ���
				data.add(s.charAt(i));
			}
		}

		Collections.sort(data);
		String result = "";
		for (int i = 0; i < data.size(); i++) {
			result += data.get(i);
		}
		
		result += num;

		System.out.println(result);
	}

}
