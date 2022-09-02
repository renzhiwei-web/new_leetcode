package tree;

public class LongestUnivaluePath {
	// leetcode 687 medium 2022/9/2
	// 由题意可得，在二叉树上求路径，可以通过将父节点的左右子树的路径和相加可得
	// 由于是树形结构，使用递归的思想
	private int maxL = 0;
	
    public int longestUnivaluePath(TreeNode root) {
    	if (root == null) {
			return 0;
		}
    	getMaxL(root,root.val);
    	return maxL;
    }

	private int getMaxL(TreeNode root, int val) {
		if (root == null) {
			return 0;
		}
		int left = getMaxL(root.left, root.val);
		int right = getMaxL(root.right, root.val);
		maxL = Math.max(maxL, left + right);
		if (root.val == val) {
			return Math.max(left, right) + 1;// 路径不能分叉，所以选取最长的路径
		}
		return 0;
	}
}
