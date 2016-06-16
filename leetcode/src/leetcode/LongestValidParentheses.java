package leetcode;

import java.util.Stack;

public class LongestValidParentheses {
	public int longestValidParentheses(String s) {
		if (s == null || s.length() == 0)
			return 0;
		Stack<Integer> st = new Stack<>();
		int max = 0;
		int start = -1;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == '(') {
				st.push(i);
			} else if (c == ')') {
				if (st.isEmpty()) {
					start = i;
				} else {
					st.pop();
					if (st.empty() == true) {
						max = Math.max(i - start, max);
					} else {
						max = Math.max(i - st.peek(), max);
					}
				}

			}
		}
		return max;
	}
}
