package leetcode;

public class MoveZeros {
	public void moveZeroes(int[] nums) {
		if (nums == null || nums.length <= 1)
			return;
		int k = 0;
		if (nums[0] == 0) {
			k = 1;
		}
		for (int i = 1; i < nums.length; i++) {
			nums[i - k] = nums[i];
			if (nums[i] == 0) {
				k++;
			}
		}
		for (int i = nums.length - 1; i > nums.length - 1 - k; i--) {
			nums[i] = 0;
		}
	}
}
