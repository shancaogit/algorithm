package leetcode;

import java.util.HashSet;

public class ContainsDuplicateII {
	public boolean containsNearbyDuplicate(int[] nums, int k) {
		HashSet<Integer> set = new HashSet<>();
		if (nums == null || nums.length < 2)
			return false;
		if (k >= nums.length) {
			k = nums.length - 1;
		}
		for (int i = 0; i <= k; i++) {
			if (set.contains(nums[i]))
				return true;
			set.add(nums[i]);
		}
		for (int i = k + 1; i < nums.length; i++) {
			set.remove(nums[i - k - 1]);
			if (set.contains(nums[i])) {
				return true;
			}
			set.add(nums[i]);
		}
		return false;
	}
}
