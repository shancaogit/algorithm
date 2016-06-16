package leetcode;

public class Fibonacci {

	public int fibonacci(int n) {
		int f2 = 1;
		int f1 = 2;
		int f = n;
		for (int i = 3; i <= n; i++) {
			f = f1 + f2;
			f2 = f1;
			f1 = f;
		}
		return f;
	}
}
