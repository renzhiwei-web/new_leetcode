package tree;

public class CountNodesEqualToAverageOfSubtree {
	//leetcode 2265 medium 2022/5/9
	// 首先容易想到使用简单的递归进行解题，
	// 但是想要存在大量重复的计算，想要使用前缀和思想，则必须使用自底向上的搜索，但此为简单的二叉树结构，由子节点无法快速的找到父节点
	int ans = 0, sum = 0, num = 0;
    public int averageOfSubtree(TreeNode root) {
    	dfs(root);
    	return ans;
    }
	private void dfs(TreeNode root) {
		// TODO Auto-generated method stub
		if (root == null) {
			return;
		}
		num = 0;//子树节点数量
		sum = 0;//子树节点和
		visit(root);//统计子树的节点数量和子树的节点的值和
		if (sum / num == root.val) {
			ans++;
		}
		dfs(root.left);
		dfs(root.right);
	}
	private void visit(TreeNode root) {
		// TODO Auto-generated method stub
		if (root == null) {
			return;
		}
		num++;
		sum += root.val;
		visit(root.left);
		visit(root.right);
	}
	
}
