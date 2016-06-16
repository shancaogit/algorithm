package leetcode;

public class BadVersion {
	public int firstBadVersion(int n) {
		int l = 1;
		int r = n;
		while (l < r) {
			int mid = (r - l) / 2 + l;
			if (isBadVersion(mid)) {
				r = mid;
			} else {
				l = mid + 1;
			}
		}
		return l;
	}

	// fake method 
	public boolean isBadVersion(int n) {
		return n>=3 ;
	}
}
