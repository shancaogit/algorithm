package leetcode;

public class ReverseInteger {
	public int reverse(int x) {
		int y = 0;
		int t = 0;
		while (x != 0) {
			t = y * 10 + x % 10;

			if ((t - x % 10) / 10 != y) {
				return 0;
			} else {
				y = t;
			}
			x = x / 10;
		}
		return y;
	}
}
