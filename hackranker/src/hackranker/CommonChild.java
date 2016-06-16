package hackranker;

import java.util.Scanner;

public class CommonChild {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String s1 = in.nextLine();
		String s2 = in.nextLine();
		int n = s1.length();
		int m = s2.length();
		int[][] dp = new int[n][m];
		if (s1.charAt(0) == s2.charAt(0)) {
			dp[0][0] = 1;
		}
		if (n > 1 && s1.charAt(1) == s2.charAt(0)) {
			dp[1][0] = 1;
		}
		if (m > 1 && s1.charAt(0) == s2.charAt(1)) {
			dp[0][1] = 1;
		}
		for (int i = 1; i < n; i++) {
			for (int j = 1; j < m; j++) {
				if (s1.charAt(i) == s2.charAt(j)) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				} else {
					dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
				}
			}
		}
		System.out.println(dp[n - 1][m - 1]);
		in.close();
	}
}
