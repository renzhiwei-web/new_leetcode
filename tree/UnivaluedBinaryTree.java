package tree;

public class UnivaluedBinaryTree {
	// leetcode 965 simple 2022/5/24
	// 简单模拟即可
    public boolean isUnivalTree(TreeNode root) {
    	if (root == null) {
			return true;
		}
    	int num = root.val;
    	return preSearch(root,num);
    }

	private boolean preSearch(TreeNode root, int num) {
		if (root == null) {
			return true;
		}
		if (root.val != num) {
			return false;
		}
		return preSearch(root.left,num) && preSearch(root.right,num);
	}
}
