package leetcode;

public class RemoveDuplicatesfromSortedArray {
	public int removeDuplicates(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;
		int num = nums[0];
		int count = 0;
		for (int i = 1; i < nums.length; i++) {
			if (num == nums[i]) {
				count++;
			} else {
				num = nums[i];
			}
			nums[i - count] = nums[i];
		}
		return nums.length - count;
	}
}
