package leetcode;

public class LongestSubstringWithoutRepeatingCharacters {
	public int lengthOfLongestSubstring(String s) {
		if (s == null || "".equals(s))
			return 0;

		byte[] bytes = s.getBytes();
		int[] map = new int[255];

		int len = 0;
		int maxLen = 0;
		int lastIdx = 1;

		for (int i = 0; i < bytes.length; i++) {
			int currIdx = i + 1;
			if (map[128 + bytes[i]] >= lastIdx) {
				lastIdx = map[128 + bytes[i]] + 1;
			}
			len = currIdx - lastIdx + 1;
			map[128 + bytes[i]] = currIdx;
			if (maxLen < len) {
				maxLen = len;
			}

		}

		return maxLen;
	}
}
