package leetcode;

public class LongestCommonPrefix {
	public String longestCommonPrefix(String[] strs) {
		if (strs == null || strs.length == 0)
			return "";
		int len = Integer.MAX_VALUE;
		String s = null;
		for (String str : strs) {
			if (len > str.length()) {
				len = str.length();
				s = str;
			}
		}
		char[] array = s.toCharArray();
		for (String str : strs) {
			if (len > 0) {
				for (int i = 0; i < len; i++) {
					if (str.charAt(i) != array[i]) {
						len = i;
						break;
					}
				}
			} else {
				return "";
			}
		}
		return String.copyValueOf(array, 0, len);
	}
}
