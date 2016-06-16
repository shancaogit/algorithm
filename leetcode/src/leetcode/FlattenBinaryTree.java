package leetcode;

public class FlattenBinaryTree {
	public void flatten(TreeNode root) {
		if (root != null)
			flattenTree(root);
	}

	public TreeNode flattenTree(TreeNode node) {
		if (node.left == null && node.right == null)
			return node;
		TreeNode flattenLNode = null;
		TreeNode flattenRNode = null;
		if (node.right != null) {
			flattenRNode = flattenTree(node.right);
		}
		if (node.left != null) {
			flattenLNode = flattenTree(node.left);
			node.right = flattenLNode;
			node.left = null;
			while (flattenLNode.right != null) {
				flattenLNode = flattenLNode.right;
			}
			flattenLNode.right = flattenRNode;
		}
		return node;
	}
}
