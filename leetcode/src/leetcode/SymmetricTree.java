package leetcode;

public class SymmetricTree {
	public boolean isSymmetric(TreeNode root) {
		if (root == null)
			return true;
		if (root.left == null && root.right == null)
			return true;
		if (root.left == null || root.right == null)
			return false;
		return isSymmetric(root.left, root.right);

	}

	public boolean isSymmetric(TreeNode left, TreeNode right) {
		if (left == null && right == null)
			return true;
		if (left == null || right == null)
			return false;
		if (left.val != right.val)
			return false;
		if (isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left)) {
			return true;
		} else {
			return false;
		}
	}
}
