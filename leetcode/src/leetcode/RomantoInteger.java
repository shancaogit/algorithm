package leetcode;

public class RomantoInteger {
	public int romanToInt(String s) {
		if (s == null || s.equals(""))
			return 0;
		s = s.toUpperCase();
		int val[] = { 1, 5, 10, 50, 100, 500, 1000 };
		int sum = 0;
		int maxIdx = 0;
		for (int i = s.length() - 1; i >= 0; i--) {
			char c = s.charAt(i);
			int idx = 0;
			switch (c) {
			case 'I':
				idx = 0;
				break;
			case 'V':
				idx = 1;
				break;
			case 'X':
				idx = 2;
				break;
			case 'L':
				idx = 3;
				break;
			case 'C':
				idx = 4;
				break;
			case 'D':
				idx = 5;
				break;
			case 'M':
				idx = 6;
				break;
			}
			if (idx >= maxIdx) {
				sum = sum + val[idx];
				maxIdx = idx;
			} else {
				sum = sum - val[idx];
			}
		}
		return sum;
	}
}
