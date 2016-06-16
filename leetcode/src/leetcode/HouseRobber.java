package leetcode;

public class HouseRobber {
	public int rob(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;
		if (nums.length == 1)
			return nums[0];
		if (nums.length == 2)
			return max(nums[0], nums[1]);
		int f2 = nums[0];
		int f1 = max(nums[0], nums[1]);
		int tmp = 0;
		for (int i = 2; i < nums.length; i++) {
			tmp = f1;
			f1 = max(f2 + nums[i], f1);
			f2 = tmp;
		}
		return f1;
	}

	public int max(int a, int b) {
		return a > b ? a : b;
	}
}
