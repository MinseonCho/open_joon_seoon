package test;

import java.util.*;

// ���ڿ� ���� 323p

public class Algorithm_prac_no28 {

	private static String s;
	private static int results;

	private static int compress(String s) {
		int half = s.length() / 2;
		results = s.length();
		String news = "";

		for (int i = 1; i < half + 1; i++) {
			int cnt = 1; // ������ ���ڿ��� ������ ��� ++
			String compressed = "";
			String prev = s.substring(0, i);

			// ������ŭ ������Ű�� ���� ���ڿ��� ��
			for (int j = i; j < s.length(); j += i) {
				String sub = "";
				for (int k = j; k < j + i; k++) {
					if (k < s.length())
						sub += s.charAt(k);
				}

				if (prev.equals(sub))
					cnt++;
				else {
					compressed += (cnt > 1) ? cnt + prev : prev;
					sub = "";
					for (int k = j; k < j + i; k++) {
						if (k < s.length())
							sub += s.charAt(k);
					}
					prev = sub;
					cnt = 1;
				}
			}

			compressed += (cnt > 1) ? cnt + prev : prev;
			results = Math.min(results, compressed.length());
		}


		return results;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		s = sc.next();

		System.out.println(compress(s));
	}

}
