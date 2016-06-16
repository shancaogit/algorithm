package leetcode;

import java.util.Set;

public class WordBreak {
	public boolean wordBreak(String s, Set<String> wordDict) {
		if (s == null || s.equals(""))
			return false;
		boolean flags[] = new boolean[s.length() + 1];
		int maxWordLen = 0;
		for (String word : wordDict) {
			if (word.length() > maxWordLen) {
				maxWordLen = word.length();
			}
		}
		flags[0] = true;
		for (int i = 1; i <= s.length(); i++) {
			int idx = i - maxWordLen;
			idx = idx > 0 ? idx : 0;
			for (int j = i - 1; j >= idx; j--) {
				if (flags[j] && wordDict.contains(s.substring(j, i))) {
					flags[i] = true;
				}
			}
		}
		return flags[s.length()];
	}
}
