package tree;

public class BinaryTreeTilt {
	// leetcode 563 simple 2022/5/3
	// 容易想到使用递归来进行解题
    public int findTilt(TreeNode root) {
    	if (root == null) {
			return 0;
		}
    	return findTilt(root.left) + findTilt(root.right) + Math.abs(getSum(root.left) - getSum(root.right));
    }
    
    int getSum(TreeNode root) {
    	if (root == null) {
			return 0;
		}
    	return getSum(root.left) + getSum(root.right) + root.val;
    }
}
