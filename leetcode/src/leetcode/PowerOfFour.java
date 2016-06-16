package leetcode;

public class PowerOfFour {
	public boolean isPowerOfFour(int num) {
		if (num <= 0)
			return false;
		int i = num & (num - 1);
		if (i == 0) {
			while (num > 1) {
				num = num >> 2;
			}
			if (num == 1)
				return true;
		}
		return false;
	}
}
