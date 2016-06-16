package hackranker;

import java.util.Scanner;

public class TheCoinChangeProblem {
	public static void main(String[] args) {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT.
		 * Your class should be named Solution.
		 */
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		int[] c = new int[m];
		for (int i = 0; i < m; i++) {
			c[i] = in.nextInt();
		}
		in.close();

		// f(c, m, n) = f(c, m-1, n) + f(c, m, n-c[m-1])
		// f(c, i, j) i>0 && j=0 f(c, i, j) =1
		// f(c, i, j) i=0 && j>0 f(c, i, j) =0

		long[][] table = new long[m + 1][n + 1];
		for (int i = 1; i <= m; i++) {
			table[i][0] = 1;
		}
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				table[i][j] = table[i - 1][j];
				if (j - c[i - 1] >= 0) {
					table[i][j] = table[i][j] + table[i][j - c[i - 1]];
				}
			}
		}
		System.out.println(table[m][n]);
		in.close();
	}
}
