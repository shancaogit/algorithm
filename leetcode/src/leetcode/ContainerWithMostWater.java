package leetcode;

public class ContainerWithMostWater {
	public int maxArea(int[] height) {
		if (height == null || height.length <= 1)
			return 0;
		int l = 0;
		int r = height.length - 1;
		int max = 0;
		while (l < r) {
			int tmp = (r - l) * Math.min(height[l], height[r]);
			if (tmp > max)
				max = tmp;
			if (height[l] > height[r]) {
				int currHeight = height[r];
				while (r > 0 && height[r] <= currHeight) {
					r--;
				}
			} else {
				int currHeight = height[l];
				while (l < height.length - 1 && height[l] <= currHeight) {
					l++;
				}
			}
		}
		return max;
	}
}
