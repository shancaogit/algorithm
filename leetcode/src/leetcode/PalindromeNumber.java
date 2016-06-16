package leetcode;

public class PalindromeNumber {
	public boolean isPalindrome(int x) {
		if (x < 0)
			return false;
		int revNum = 0;
		int num = x;
		while (num != 0) {
			int tmp = revNum * 10 + num % 10;
			if ((tmp - num % 10) / 10 != revNum)
				return false;
			revNum = tmp;
			num = num / 10;
		}
		return revNum == x;
	}
}
