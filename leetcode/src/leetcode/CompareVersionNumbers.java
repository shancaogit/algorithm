package leetcode;

public class CompareVersionNumbers {
	public int compareVersion(String version1, String version2) {
		if (version1.equals(version2))
			return 0;
		int idx1 = 0;
		int idx2 = 0;
		while (true) {
			long l1 = 0;
			long l2 = 0;
			if (idx1 < version1.length()) {
				int dotIdx1 = version1.indexOf('.', idx1);

				if (dotIdx1 == -1) {
					l1 = Long.parseLong(version1.substring(idx1, version1.length()));
					idx1 = version1.length();
				} else {
					l1 = Long.parseLong(version1.substring(idx1, dotIdx1));
					idx1 = dotIdx1 + 1;
				}
			}
			if (idx2 < version2.length()) {
				int dotIdx2 = version2.indexOf('.', idx2);
				if (dotIdx2 == -1) {
					l2 = Long.parseLong(version2.substring(idx2, version2.length()));
					idx2 = version2.length();
				} else {
					l2 = Long.parseLong(version2.substring(idx2, dotIdx2));
					idx2 = dotIdx2 + 1;
				}
			}
			if (l1 > l2)
				return 1;
			if (l1 < l2)
				return -1;
			if (idx1 == version1.length() && idx2 == version2.length())
				return 0;
		}
	}
}
