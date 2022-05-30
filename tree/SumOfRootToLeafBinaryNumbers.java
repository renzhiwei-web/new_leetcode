package tree;

public class SumOfRootToLeafBinaryNumbers {
	// leetcode 1022 simple 2022/5/30
	// 难点是如何将找到完整二进制数，再转成十进制数
    public int sumRootToLeaf(TreeNode root) {
    	return dfs(root , 0);
    }

	private int dfs(TreeNode root, int cur) {
		int ans = 0,ncur = (cur << 1) + root.val;
		if (root.left != null) {
			ans += dfs(root.left, ncur);
		}
		if (root.right != null) {
			ans += dfs(root.right, ncur);
		}
		return root.left == null && root.right == null ? ncur : ans;
	}
}
