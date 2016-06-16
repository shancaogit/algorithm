package leetcode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {
	public List<String> binaryTreePaths(TreeNode root) {
		List<String> lt = new ArrayList<>();
		if (root == null)
			return lt;
		String s = String.valueOf(root.val);
		if (root.left == null && root.right == null)
			lt.add(s);
		if (root.left != null) {
			traverse(root.left, lt, s);
		}
		if (root.right != null) {
			traverse(root.right, lt, s);
		}
		return lt;
	}

	private void traverse(TreeNode node, List<String> lt, String prefix) {
		if (node == null)
			return;
		String s = prefix + "->" + node.val;
		if (node.left == null && node.right == null) {
			lt.add(s);
			return;
		}
		if (node.left != null) {
			traverse(node.left, lt, s);
		}
		if (node.right != null) {
			traverse(node.right, lt, s);
		}
	}
}
