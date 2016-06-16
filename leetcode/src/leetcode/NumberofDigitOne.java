package leetcode;

public class NumberofDigitOne {
	public int countDigitOne(int num) {
		if (num <= 0) {
			return 0;
		}
		if (num < 10) {
			return 1;
		}
		int input = num / 10;
		int len = 1;
		int k = 1;

		while (input != 0) {
			input = input / 10;
			k = k * 10;
			len++;
		}
		int count = 0;
		int val = 0;
		for (int i = len; i > 0; i--) {
			val = num / k % 10;
			if (val == 1) {
				count += (i - 1) * (k / 10) + num % k + 1;
			} else if (val > 1) {
				count += k + val * (i - 1) * (k / 10);
			}
			k = k / 10;
		}
		return count;
	}
}
