package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalTriangleII {
	public List<Integer> getRow(int rowIndex) {
		List<Integer> row = new ArrayList<>(rowIndex);
		if (rowIndex < 0)
			return row;
		if (rowIndex == 0)
			return Arrays.asList(1);
		int n = rowIndex + 1;
		row.add(1);
		int mid = n / 2;
		for (int i = 1; i <= mid; i++) {
			long val = (long) row.get(i - 1) * (n - i);
			row.add((int) (val / i));
		}
		for (int i = mid + 1; i < n; i++) {
			row.add(row.get(n - i - 1));
		}
		return row;
	}
}
