package leetcode;

public class FindMinInRotatedSortedArrayII {
	public int findMin(int[] num) {
		return min(num, 0, num.length - 1);
	}

	public int min(int[] array, int l, int r) {
		if (l == r)
			return array[l];
		int i = (l + r) >> 1;
		if (i == l)
			return array[l] < array[r] ? array[l] : array[r];
		if (array[l] < array[i]) {
			if (array[r] < array[i]) {
				return min(array, i, r);
			} else {
				return array[l];
			}
		} else if (array[l] == array[i]) {
			if (array[r] >= array[i]) {
				int a = min(array, l, i);
				int b = min(array, i, r);
				return a > b ? b : a;
			} else {
				return min(array, i, r);
			}
		} else {
			return min(array, l, i);
		}
	}
}
