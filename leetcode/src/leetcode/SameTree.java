package leetcode;

public class SameTree {
	public boolean isSameTree(TreeNode p, TreeNode q) {
		if (p == q)
			return true;
		if (p == null || q == null)
			return false;
		if (p.val != q.val)
			return false;
		if (!isSameTree(p.left, q.left) || !isSameTree(p.right, q.right)) {
			return false;
		}
		return true;
	}
}
