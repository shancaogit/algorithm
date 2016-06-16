package leetcode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeLevelOrderTraversalII {
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		List<List<Integer>> result = new ArrayList<>();
		if (root == null)
			return result;
		List<TreeNode> lt = new ArrayList<>();
		lt.add(root);
		int start = 0;
		int end = 1;
		List<Integer> idxs = new ArrayList<>();
		while (start < end) {
			idxs.add(start);
			int tmp = end;
			for (int i = start; i < tmp; i++) {
				TreeNode node = lt.get(i);
				if (node.left != null) {
					lt.add(node.left);
					end++;
				}
				if (node.right != null) {
					lt.add(node.right);
					end++;
				}
			}
			start = tmp;
		}
		end = lt.size();
		for (int i = idxs.size() - 1; i >= 0; i--) {
			List<Integer> vals = new ArrayList<>();
			for (int j = idxs.get(i); j < end; j++) {
				vals.add(lt.get(j).val);
			}
			end = idxs.get(i);
			result.add(vals);
		}
		return result;
	}
}
