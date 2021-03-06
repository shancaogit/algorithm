package leetcode;

public class UglyNumber {
	public boolean isUgly(int num) {
		if (num <= 0)
			return false;
		while (num > 1) {
			int tmp = num;
			if (num % 2 == 0)
				num = num / 2;
			if (num % 3 == 0)
				num = num / 3;
			if (num % 5 == 0)
				num = num / 5;
			if (tmp == num) {
				return false;
			}
		}
		return true;
	}
}
