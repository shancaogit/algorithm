package leetcode;

public class IntegerBreak {
	public int integerBreak(int n) {
		if (n == 2)
			return 1;
		if (n == 3)
			return 2;
		int i = n % 3;
		if (i == 0) {
			return (int) Math.pow(3, n / 3);
		} else if (i == 2) {
			return (int) (2 * Math.pow(3, n / 3));
		} else {
			return (int) (4 * Math.pow(3, n / 3 - 1));
		}
	}
}
