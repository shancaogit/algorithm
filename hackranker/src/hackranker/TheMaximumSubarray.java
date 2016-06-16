package hackranker;

import java.util.Scanner;

public class TheMaximumSubarray {
	public static void main(String[] args) {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT.
		 * Your class should be named Solution.
		 */
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for (int ti = 0; ti < t; ti++) {
			in.nextLine();
			int n = in.nextInt();
			in.nextLine();
			int[] array = new int[n];
			for (int ni = 0; ni < n; ni++) {
				array[ni] = in.nextInt();
			}

			int max = 0;
			int tmp = 0;
			int sum = 0;
			int maxItem = Integer.MIN_VALUE;
			for (int i = 0; i < n; i++) {
				if (array[i] > maxItem)
					maxItem = array[i];
				if (array[i] > 0)
					sum += array[i];
				tmp += array[i];
				if (tmp < 0)
					tmp = 0;
				if (tmp > max)
					max = tmp;
			}
			if (maxItem < 0) {
				max = maxItem;
				sum = maxItem;
			}
			System.out.println(max + " " + sum);
		}
		in.close();
	}
}
