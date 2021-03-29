package test;

import java.util.*;

class Scores implements Comparable<Scores> {
	private String name;
	private int kor, eng, math;

	public Scores(String name, int kor, int eng, int math) {
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}

	public int getKor() {
		return this.kor;
	}

	public int getEng() {
		return this.eng;
	}

	public int getMath() {
		return this.math;
	}

	public String getName() {
		return this.name;
	}

	@Override
	public int compareTo(Scores other) {
		if (this.kor == other.kor && this.eng == other.eng && this.math == other.math) {
            return this.name.compareTo(other.name);
        }
        if (this.kor == other.kor && this.eng == other.eng) {
        	System.out.println(this.math + " " + other.math);
        	System.out.println( Integer.compare(other.math, this.math));
            return Integer.compare(other.math, this.math);
        }
        if (this.kor == other.kor) {
            return Integer.compare(this.eng, other.eng);
        }
        return Integer.compare(other.kor, this.kor);
	}
}

public class Algorithm_prac_359 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Scores> arrList = new ArrayList<Scores>();

		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			arrList.add(new Scores(sc.next(), sc.nextInt(), sc.nextInt(), sc.nextInt()));
		}

		Collections.sort(arrList);

		for (Scores score : arrList) {
			System.out.println(score.getName());
		}
	}

}
