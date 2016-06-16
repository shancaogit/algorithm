package leetcode;

public class ExcelSheetColumnTitle {
	String[] array = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S",
			"T", "U", "V", "W", "X", "Y", "Z" };

	public String convertToTitle(int n) {
		if (n <= 0)
			return null;
		StringBuilder sb = new StringBuilder();
		while (n != 0) {
			sb.append(array[(n - 1) % 26]);
			n = (n - 1) / 26;
		}
		String s = sb.toString();
		char array[] = new char[s.length()];
		for (int i = 0; i < s.length(); i++) {
			array[s.length() - 1 - i] = s.charAt(i);
		}
		return new String(array);
	}
}
