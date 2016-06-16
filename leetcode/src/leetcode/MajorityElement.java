package leetcode;

public class MajorityElement {
	public int majorityElement(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;
		int k = 0;
		int count = 1;
		for (int i = 1; i < nums.length; i++) {
			if (nums[k] == nums[i]) {
				count++;
			} else {
				count--;
			}
			if (count == 0) {
				k = i;
				count = 1;
			}
		}

		return nums[k];
	}
}
