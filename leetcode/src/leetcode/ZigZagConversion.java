package leetcode;

public class ZigZagConversion {
	public String convert(String s, int numRows) {
		if (s == null || "".equals(s) || s.length() <= numRows || numRows <= 1)
			return s;

		byte[] str = s.getBytes();
		int len = str.length;
		byte[] newStr = new byte[len];
		newStr[0] = str[0];
		int rowNum = 0;
		int lastIdx = 0;
		int i = 1;
		int nextDist = 0;
		while (i < len) {
			if (rowNum == 0 || rowNum == numRows - 1) {
				nextDist = 2 * (numRows - 1);

			} else {
				if (lastIdx == rowNum) {
					nextDist = 2 * (numRows - 1 - rowNum);
				} else {
					nextDist = 2 * (numRows - 1) - nextDist;
				}
			}

			int nextIdx = lastIdx + nextDist;

			if (nextIdx < len) {
				newStr[i++] = str[nextIdx];
				lastIdx = nextIdx;
			} else if (rowNum < numRows) {
				rowNum++;
				newStr[i++] = str[rowNum];
				lastIdx = rowNum;
			}
		}
		return new String(newStr);
	}
}
