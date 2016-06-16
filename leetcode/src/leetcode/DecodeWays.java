package leetcode;

public class DecodeWays {
	public int numDecodings(String s) {
		if (s == null || !s.matches("\\d+") || s.startsWith("0")) {
			return 0;
		}
		int len = s.length();
		int[] a = new int[len];
		int[] b = new int[len];
		for (int i = 0; i < len; i++) {
			if (s.charAt(i) != '0') {
				a[i] = 1;
				if (i + 1 < len) {
					int num = Integer.parseInt(s.substring(i, i + 2));
					if (num <= 26) {
						b[i + 1] = 1;
					}
				}
			}
		}
		int count = 0;
		if (len == 1) {
			return a[0];
		} else if (len == 2) {
			if (a[1] == 0)
				return b[1];
			else
				return a[0] + b[1];
		} else {

			int f2 = a[0];
			int f1 = a[1] == 0 ? b[1] : (a[0] + b[1]);
			for (int i = 2; i < len; i++) {
				if (a[i] == 0 && b[i] == 0) {
					return 0;
				} else if (a[i] == 0 && b[i] == 1) {
					count = f2;

				} else if (a[i] == 1 && b[i] == 0) {
					count = f1;
				} else {
					count = f1 + f2;
				}
				f2 = f1;
				f1 = count;
			}
		}
		return count;
	}
}
