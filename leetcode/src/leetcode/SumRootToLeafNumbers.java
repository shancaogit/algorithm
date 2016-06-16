package leetcode;

public class SumRootToLeafNumbers {
	int total = 0;

	public int sumNumbers(TreeNode root) {
		if (root == null)
			return 0;
		traverse(root, 0);
		return total;
	}

	private void traverse(TreeNode node, int sum) {
		if (node.left != null)
			traverse(node.left, sum * 10 + node.val);
		if (node.right != null)
			traverse(node.right, sum * 10 + node.val);
		if (node.left == null && node.right == null)
			total = total + sum * 10 + node.val;
	}
}
