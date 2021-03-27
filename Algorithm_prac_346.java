package test;
import java.util.*;

class Solution {
	Stack<Character> st = new Stack<>();

	boolean check(String str) {
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);

			// ) 가 먼저 나오면 올바른 문자열이 아님
			if (st.isEmpty() && ch == ')')
				return false;

			if (ch == '(')
				st.push(ch);
			else {
				if (!st.isEmpty())
					st.pop();
			}
		}

		return true;
	}

	String divide(String p) {

		if (p == "")
			return "";

		int left = 0, right = 0;
		String u = "", v = "";

		// u와 v 로 나누기
		for (int i = 0; i < p.length(); i++) {
			if (p.charAt(i) == '(')
				left++;
			else
				right++;

			if (left == right) {
				u = p.substring(0, i + 1);
				v = p.substring(i + 1);
				break;
			}
		}

		if (check(u)) {
			return u + divide(v);
		} else {
			String tmp = "(" + divide(v) + ")";
			u = u.substring(1, u.length() - 1);
			for (int i = 0; i < u.length(); i++) {
				if (u.charAt(i) == '(')
					tmp += ')';
				else
					tmp += '(';
			}

			return tmp;
		}
	}

	public String solution(String p) {
		String answer = "";

		answer = divide(p);

		return answer;
	}
}

public class Algorithm_prac_346 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String str = sc.nextLine();

		Solution sol = new Solution();

		System.out.println(sol.solution(str));

	}

}
