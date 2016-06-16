package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeZigzagLevelOrderTraversal {
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> lists = new ArrayList<List<Integer>>();
		if (root == null)
			return lists;
		Stack<TreeNode> left2Right = new Stack<>();
		Stack<TreeNode> right2Left = new Stack<>();
		right2Left.add(root);

		boolean right2LeftDirection = true;
		while (!(right2Left.isEmpty() && left2Right.isEmpty())) {
			List<Integer> lt = new ArrayList<>();
			if (right2LeftDirection) {
				while (!right2Left.isEmpty()) {
					TreeNode node = right2Left.pop();
					lt.add(node.val);
					if (node.left != null) {
						left2Right.add(node.left);
					}
					if (node.right != null) {
						left2Right.add(node.right);
					}
				}
				right2LeftDirection = false;
			} else {
				while (!left2Right.isEmpty()) {
					TreeNode node = left2Right.pop();
					lt.add(node.val);
					if (node.right != null) {
						right2Left.add(node.right);
					}
					if (node.left != null) {
						right2Left.add(node.left);
					}
				}
				right2LeftDirection = true;
			}
			lists.add(lt);
		}

		return lists;
	}
}
