package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<>();
		if (root == null)
			return result;
		Queue<TreeNode> st1 = new LinkedList<>();
		Queue<TreeNode> st2 = new LinkedList<>();
		st1.add(root);
		while (!st1.isEmpty() || !st2.isEmpty()) {
			if (!st1.isEmpty()) {
				List<Integer> lt = new ArrayList<>();
				while (!st1.isEmpty()) {
					TreeNode node = st1.poll();
					lt.add(node.val);
					if (node.left != null)
						st2.add(node.left);
					if (node.right != null)
						st2.add(node.right);
				}
				result.add(lt);
			} else {
				List<Integer> lt = new ArrayList<>();
				while (!st2.isEmpty()) {
					TreeNode node = st2.poll();
					lt.add(node.val);
					if (node.left != null)
						st1.add(node.left);
					if (node.right != null)
						st1.add(node.right);
				}
				result.add(lt);
			}
		}
		return result;
	}
}
