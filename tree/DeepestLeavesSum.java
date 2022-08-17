package tree;

import java.util.ArrayDeque;
import java.util.Deque;

public class DeepestLeavesSum {
	// leetcode 1302 medium 2022/8/17
	// 使用层序遍历即可
    public int deepestLeavesSum(TreeNode root) {
    	Deque<TreeNode> queue = new ArrayDeque<>();
    	queue.offer(root);
    	int ans = 0;
    	while(!queue.isEmpty()) {
    		ans = 0;
    		int counts = queue.size();
    		for(int i = 0;i < counts;i++) {
	    		TreeNode tempNode = queue.poll();
	    		ans += tempNode.val;
	    		if (tempNode.left != null) {
					queue.offer(tempNode.left);
				}
	    		if (tempNode.right != null) {
					queue.offer(tempNode.right);
				}
    		}
    		
    		
    	}
    	return ans;
    }
}
