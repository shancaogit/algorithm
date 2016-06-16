package leetcode;

public class ExcelSheetColumnNumber {
	public int titleToNumber(String s) {
		if (s == null || "".equals(s))
			return 0;
		int num = 0;
		int k = 1;
		for (int i = s.length() - 1; i >= 0; i--) {
			char c = s.charAt(i);
			num = num + k * ((int) c - 64);
			k = 26 * k;
		}
		return num;
	}
}
