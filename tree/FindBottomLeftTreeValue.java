package tree;

import java.util.ArrayDeque;
import java.util.Deque;

public class FindBottomLeftTreeValue {
	// leetcode 513 medium 2022/6/22
	// 因为涉及到层次，所以首先想到广度优先搜索遍历算法，这里对bfs做个小改进，先遍历右子树，再遍历左子树
	
	// 深度优先搜索算法比较不容易想到，递归的过程中，用height记录当前的深度，只有在递归的最顶层才会执行最后的if语句
	int curVal = 0;
	int curHeight = 0;
	
    public int findBottomLeftValue(TreeNode root) {
    	dfs(root,0);
    	return curVal;
    }

	private void dfs(TreeNode root, int height) {
		// TODO Auto-generated method stub
		if (root == null) {
			return;
		}
		height++;
		dfs(root.left, height);
		dfs(root.right, height);
		
		if (height > curHeight) {
			curHeight = height;
			curVal = root.val;
		}
	}
	
	// 广度优先搜索算法
	public int findBottomLeftValue1(TreeNode root) {
		Deque<TreeNode> queue = new ArrayDeque<>();
		int ans = 0;
		if (root != null) {
			queue.add(root);
		}
		while(!queue.isEmpty()) {
			TreeNode node = queue.removeFirst();
			ans = node.val;
			if (node.right != null) {
				queue.add(node.right);
			}
			if (node.left != null) {
				queue.add(node.left);
			}
			
		}
		return ans;
	}
}
