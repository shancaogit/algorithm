package hackranker;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MatrixRotation {
	public static void main(String[] args) {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT.
		 * Your class should be named Solution.
		 */
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		int r = in.nextInt();
		int matrix[][] = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				matrix[i][j] = in.nextInt();
			}
		}
		int loop = Math.min(n, m) / 2;
		int l = 0;
		List<Integer> lt = new ArrayList<Integer>();
		while (l < loop) {
			lt.clear();
			for (int i = l; i <= m - 1 - l; i++) {
				lt.add(matrix[l][i]);
			}
			for (int i = l + 1; i <= n - 2 - l; i++) {
				lt.add(matrix[i][m - 1 - l]);
			}
			for (int i = m - 1 - l; i >= l; i--) {
				lt.add(matrix[n - 1 - l][i]);
			}
			for (int i = n - 2 - l; i >= l + 1; i--) {
				lt.add(matrix[i][l]);
			}
			// System.out.println("#" + Arrays.toString(lt.toArray()) + "#");
			int count = lt.size();
			int shfit = r % count;
			if (shfit != 0) {
				int k = 0;
				for (int i = l; i <= m - 1 - l; i++) {
					int idx = (k + shfit) % count;
					matrix[l][i] = lt.get(idx);
					k++;
				}
				for (int i = l + 1; i <= n - 2 - l; i++) {
					int idx = (k + shfit) % count;
					matrix[i][m - 1 - l] = lt.get(idx);
					k++;
				}
				for (int i = m - 1 - l; i >= l; i--) {
					int idx = (k + shfit) % count;
					matrix[n - 1 - l][i] = lt.get(idx);
					k++;
				}
				for (int i = n - 2 - l; i >= l + 1; i--) {
					int idx = (k + shfit) % count;
					matrix[i][l] = lt.get(idx);
					k++;
				}
			}
			l++;
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
		in.close();
	}
}
