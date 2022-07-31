package tree;

import java.util.ArrayDeque;
import java.util.Deque;

public class MaximumLevelSumOfABinaryTree {
	// leetcode 1161 medium 2022/7/31
	// ���������뵽ʹ�ù�����������㷨
    public int maxLevelSum(TreeNode root) {
    	Deque<TreeNode> queue = new ArrayDeque<TreeNode>();
    	queue.add(root);
    	int max = Integer.MIN_VALUE;
    	int ans = 0;
    	int level = 0;
    	while(!queue.isEmpty()) {
    		int i = 0,size = queue.size();
    		int sum = 0;
    		level++;
    		while(i < size) {
    			TreeNode node = queue.pollFirst();
    			sum += node.val;
    			if (node.left != null) {
					queue.addLast(node.left);
				}
    			if (node.right != null) {
					queue.addLast(node.right);
				}
    			i++;
    		}
    		if (sum > max) {
				max = sum;
				ans = level;
			}
    	}
    	return ans;
    }
}
