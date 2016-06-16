package leetcode;

public class BalancedBinaryTree {
	public boolean isBalanced(TreeNode root) {
		BalancedTree bt = depth(root);
		return bt.isBalanced;
	}

	private BalancedTree depth(TreeNode root) {
		boolean isBalanced = false;
		if (root == null)
			return new BalancedTree(true, 0);
		if (root.left == null && root.right == null)
			return new BalancedTree(true, 1);
		BalancedTree lb = depth(root.left);
		if (!lb.isBalanced) {
			return new BalancedTree(false, -1);
		}
		BalancedTree rb = depth(root.right);
		if (!rb.isBalanced) {
			return new BalancedTree(false, -1);
		}
		isBalanced = Math.abs(lb.depth - rb.depth) <= 1;
		int depth = Math.max(lb.depth, rb.depth) + 1;
		return new BalancedTree(isBalanced, depth);
	}

	class BalancedTree {
		boolean isBalanced;
		int depth;

		public BalancedTree(boolean isBalanced, int depth) {
			this.isBalanced = isBalanced;
			this.depth = depth;
		}
	}
}
