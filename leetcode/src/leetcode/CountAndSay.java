package leetcode;

public class CountAndSay {
	public String countAndSay(int n) {
		if (n <= 0)
			return null;

		String result = "1";
		int i = 1;
		int count = 0;
		while (i < n) {
			StringBuilder sb = new StringBuilder();
			count = 1;
			char c = result.charAt(0);
			for (int j = 1; j < result.length(); j++) {
				char curr = result.charAt(j);
				if (c == curr) {
					count++;
				} else {
					sb.append(count);
					sb.append(c);
					c = curr;
					count = 1;
				}
			}
			sb.append(count);
			sb.append(c);
			result = sb.toString();
			i++;
		}

		return result;
	}
}
