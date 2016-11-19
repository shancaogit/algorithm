package hackranker;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/longest-increasing-subsequent
 */
public class LongestIncreasingSubsequent {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		in.nextLine();
		int array[] = new int[n];
		for (int i = 0; i < n; i++) {
			array[i] = in.nextInt();
		}
		// algorithm here
		long result = longestIncreasingSubsequent(array);
		System.out.println(result);
		in.close();
	}

	/**
	 * O(n*log(n)) approach
	 */
	private static long longestIncreasingSubsequent(int[] array) {

		int[] ceiling = new int[array.length];

		int len = 1;
		ceiling[0] = array[0];
		for (int i = 1; i < array.length; i++) {
			if (array[i] < ceiling[0]) {
				ceiling[0] = array[i];
			} else if (array[i] > ceiling[len - 1]) {
				ceiling[len++] = array[i];
			} else {
				ceiling[binarySearchIdx(ceiling, 0, len - 1, array[i])] = array[i];
			}

		}
		return len;
	}

	private static int binarySearchIdx(int[] ceiling, int l, int r, int k) {
		while (l < r) {
			int m = l + (r - l) / 2;
			if (ceiling[m] >= k)
				r = m;
			else
				l = m + 1;
		}
		return r;
	}

	/**
	 * O(n^2) approach
	 */
	protected static long getLongestIncreasingSubsequent(int[] array) {
		int[] len = new int[array.length];

		int max = 1;
		len[0] = 1;
		for (int i = 1; i < array.length; i++) {
			len[i] = 1;
			for (int j = i - 1; j >= 0; j--) {
				if (array[i] > array[j]) {
					int k = len[j] + 1;
					if (k > len[i]) {
						len[i] = k;
					}
				}
			}
			if (len[i] > max) {
				max = len[i];
			}
		}
		return max;
	}
}
