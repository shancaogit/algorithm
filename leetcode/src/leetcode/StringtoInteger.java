package leetcode;

public class StringtoInteger {
	public int myAtoi(String str) {
		if (str == null)
			// throw new java.lang.IllegalArgumentException();
			return 0;
		str = str.trim();
		if (str.equals(""))
			// throw new java.lang.IllegalArgumentException();
			return 0;
		int start = 0;
		boolean negative = false;
		if (str.charAt(0) == '+') {
			start = 1;
		}
		if (str.charAt(0) == '-') {
			start = 1;
			negative = true;
		}
		int result = 0;
		int tmp = 0;
		for (int i = start; i < str.length(); i++) {
			char c = str.charAt(i);
			if (c >= '0' && c <= '9') {
				int k = (int) c - 48;
				if (negative) {
					tmp = result * 10 - k;
				} else {
					tmp = result * 10 + k;
				}
				if (tmp / 10 == result) {
					result = tmp;
				} else {
					// throw new java.lang.IllegalArgumentException();
					return negative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
				}
			} else {
				// throw new java.lang.IllegalArgumentException();
				return result;
			}
		}

		return result;
	}
}
