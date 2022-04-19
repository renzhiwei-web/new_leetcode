package tree;

import java.util.LinkedList;
import java.util.Queue;

public class SumOfLeftLeaves {
	// leetcode 404 simple 2022/4/19
	// 层序遍历
	public int sumOfLeftLeaves1(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        int ans = 0;
        queue.offer(root);
        while(!queue.isEmpty()) {
        	TreeNode pNode = queue.poll();
        	if(pNode.left != null) {
        		if (isLeafNode(pNode.left)) {
        			ans += pNode.left.val;
				}
        		queue.offer(pNode.left);
        	}
        	if (pNode.right != null) {
        		queue.offer(pNode.right);
			}
        }
        return ans;
    }
	
	private boolean isLeafNode(TreeNode node) {
		if(node.left == null && node.right == null) {
			return true;
		}
		return false;
	}
	
	// 深度遍历
	public int sumOfLeftLeaves2(TreeNode root) {
		return root != null ? dfs(root) : 0;
	}

	private int dfs(TreeNode node) {
		int ans = 0;
		if(node.left != null) {
			if(isLeafNode(node.left)) {
				ans += node.left.val;
			}else {
				ans += dfs(node.left);
			}
		}
		
		if (node.right != null) {
			ans += dfs(node.right);
		}
		return ans;
	}
}
