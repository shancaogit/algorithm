package hackranker;

import java.util.Arrays;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/largest-permutation
 */
public class LargestPermutation {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();
		in.nextLine();
		int array[] = new int[n];
		for (int i = 0; i < n; i++) {
			array[i] = in.nextInt();
		}
		// algorithm here
		if (k >= array.length - 1) {
			Arrays.sort(array);
			for (int i = n - 1; i >= 0; i--) {
				System.out.print(array[i] + " ");
			}
		} else {
			algorithm(array, k);
			for (int i = 0; i < n; i++) {
				System.out.print(array[i] + " ");
			}
		}
		// System.out.println(Arrays.toString(array));
		in.close();
	}

	private static void algorithm(int[] array, int k) {
		int cnt = 0;
		int n = array.length;
		int idx = 0;
		while (cnt < k) {
			int end = idx + (k - cnt);
			for (int i = idx; i < end; i++) {
				int v = n - i;
				if (array[i] != v) {
					cnt++;
					for (int j = array.length - 1; j > i; j--) {
						if (array[j] == v) {
							array[j] = array[i];
							break;
						}
					}
					array[i] = v;
				}
			}
			if (k - cnt >= n - end - 1) {
				for (int i = n - 1; i > n - end; i--) {
					array[i] = n - i;
				}
				break;
			}
			idx = end;
		}
	}

}
