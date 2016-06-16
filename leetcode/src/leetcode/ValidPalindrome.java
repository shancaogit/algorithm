package leetcode;

public class ValidPalindrome {
	public boolean isPalindrome(String s) {
		if (s == null || s.equals(""))
			return true;
		s = s.toLowerCase();
		int l = 0;
		int r = s.length() - 1;
		while (l < r) {
			while (l < r && !((s.charAt(l) >= 'a' && s.charAt(l) <= 'z') || (s.charAt(l) >= '0' && s.charAt(l) <= '9'))) {
				l++;
			}
			while (l < r && !((s.charAt(r) >= 'a' && s.charAt(r) <= 'z') || (s.charAt(r) >= '0' && s.charAt(r) <= '9'))) {
				r--;
			}
			if (s.charAt(l) != s.charAt(r)) {
				return false;
			}
			l++;
			r--;
		}
		return true;
	}
}
