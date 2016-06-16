package leetcode;

public class ClimbingStairs {
	public int climbStairs(int n) {
		if (n <= 1)
			return 1;
		int n1 = 1;
		int n2 = 1;
		int total = 0;
		for (int i = 2; i <= n; i++) {
			total = n1 + n2;
			n2 = n1;
			n1 = total;
		}
		return total;
	}
}
