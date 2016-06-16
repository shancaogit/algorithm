package leetcode;

public class LongestPalindromicSubstring {
	public String longestPalindrome(String s) {
		if (s == null || s.equals("") || s.length() == 1)
			return s;
		byte[] str = s.getBytes();
		int length = str.length;
		int maxLen = 0;
		int start = 0;
		int end = 0;
		for (int i = 0; i < length - 1; i++) {
			int[] startEnd = findLongestPalindrome(str, i, i);
			if (startEnd[1] - startEnd[0] > maxLen) {
				start = startEnd[0];
				end = startEnd[1];
				maxLen = startEnd[1] - startEnd[0];
			}
			// System.out.println("One :  : " +Arrays.toString(startEnd) +
			// " Length: " + maxLen + " start: " + start + " end: " + end);
			startEnd = findLongestPalindrome(str, i, i + 1);
			if (startEnd[1] - startEnd[0] > maxLen) {
				start = startEnd[0];
				end = startEnd[1];
				maxLen = startEnd[1] - startEnd[0];
			}
			// System.out.println("Two : " +Arrays.toString(startEnd) +
			// " Length: " + maxLen + " start: " + start + " end: " + end);
		}
		return s.substring(start, end + 1);
	}

	private int[] findLongestPalindrome(byte[] str, int i, int j) {
		int start = i;
		int end = i;
		if (str[i] == str[j]) {
			end = j;
			while (i > 0 && j < str.length - 1 && str[--i] == str[++j]) {
				start = i;
				end = j;
			}
		}
		return new int[] { start, end };
	}
}
