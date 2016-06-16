package leetcode;

public class PlusOne {
	public int[] plusOne(int[] digits) {
		if (digits == null)
			return null;
		boolean shift = true;
		for (int i : digits) {
			if (i != 9) {
				shift = false;
				break;
			}
		}
		if (shift) {
			int[] array = new int[digits.length + 1];
			array[0] = 1;
			return array;
		} else {
			int[] array = new int[digits.length];
			int k = digits.length - 1;
			if (digits[k] == 9) {
				shift = true;
				while (k >= 0) {
					if (shift) {
						if (digits[k] == 9) {
							array[k] = 0;
						} else {
							array[k] = digits[k] + 1;
							shift = false;
						}
					} else {
						array[k] = digits[k];
					}
					k--;
				}
			} else {
				for (int i = 0; i < k; i++) {
					array[i] = digits[i];
				}
				array[k] = digits[k] + 1;
			}
			return array;
		}
	}
}
