package leetcode;

public class LengthofLastWord {
	public int lengthOfLastWord(String s) {
		if (s == null || s.equals(""))
			return 0;

		int idx = s.length() - 1;
		while (idx >= 0) {
			char c = s.charAt(idx);
			if (c == ' ') {
				idx--;
			} else {
				break;
			}
		}
		if (idx < 0)
			return 0;
		int count = 0;
		while (idx >= 0) {
			char c = s.charAt(idx);
			if (c == ' ') {
				break;
			}
			count++;
			idx--;
		}
		return count;
	}
}
