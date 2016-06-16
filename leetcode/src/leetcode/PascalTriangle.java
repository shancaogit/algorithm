package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalTriangle {
	public List<List<Integer>> generate(int numRows) {
		List<List<Integer>> lt = new ArrayList<>();
		if (numRows <= 0)
			return lt;
		lt.add(Arrays.asList(1));

		for (int i = 1; i < numRows; i++) {
			List<Integer> pre = lt.get(lt.size() - 1);
			List<Integer> curr = new ArrayList<>();
			curr.add(1);
			for (int j = 1; j < pre.size(); j++) {
				curr.add(pre.get(j - 1) + pre.get(j));
			}
			curr.add(1);
			lt.add(curr);
		}
		return lt;
	}
}
