package leetcode;

public class RotateArray {
	public void rotate(int[] nums, int k) {
		if (nums == null || nums.length == 0) {
			return;
		}
		if (k % nums.length == 0)
			return;
		int[] result = new int[nums.length];
		int idx = nums.length - k % nums.length;
		int j = 0;
		for (int i = idx; i < nums.length; i++) {
			result[j++] = nums[i];
		}
		for (int i = 0; i < idx; i++) {
			result[j++] = nums[i];
		}
		for (int i = 0; i < nums.length; i++) {
			nums[i] = result[i];
		}
	}
}
