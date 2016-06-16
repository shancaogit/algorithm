package leetcode;

public class RemoveElement {
	public int removeElement(int[] nums, int val) {
		if (nums == null || nums.length == 0)
			return 0;
		int l = 0;
		int r = nums.length - 1;
		int count = 0;
		while (l < r) {
			while (l < r && nums[l] != val) {
				l++;
			}
			while (l < r && nums[r] == val) {
				r--;
				count++;
			}
			if (l < r) {
				nums[l] = nums[r];
				count++;
				l++;
				r--;
			}
		}
		if (l == r && nums[r] == val) {
			count++;
		}
		return nums.length - count;
	}
}
