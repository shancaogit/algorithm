package leetcode;

public class PathSum {
	public boolean hasPathSum(TreeNode root, int sum) {
		if (root == null)
			return false;
		if (root.left == null && root.right == null && root.val == sum)
			return true;
		int val = sum - root.val;
		return hasPathSum(root.left, val) || hasPathSum(root.right, val);
	}
}
