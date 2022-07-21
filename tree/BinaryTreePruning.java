package tree;

public class BinaryTreePruning {
	// leetcode 814 medium 2022/7/21
	// 首先由于是二叉树题目，想到使用递归来解题
	// 最关键的步骤是：当前节点是没有子节点，且值为0时，返回null
    public TreeNode pruneTree(TreeNode root) {
    	if (root == null) {
			return null;
		}
    	root.left = pruneTree(root.left);
    	root.right = pruneTree(root.right);
    	if (root.left == null && root.right == null && root.val == 0) {
			return null;
		}
    	return root;
    }
}
