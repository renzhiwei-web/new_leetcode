package tree;

import java.util.ArrayDeque;
import java.util.Deque;

public class MaximumDepthOfNAryTree {
	// leetcode 559 simple 2022/5/2
	// 与求二叉树深度相同
	// 深度优先遍历
    public int maxDepth(Node root) {
        int ans = 0;
        if (root == null) {
			return ans;
		}
        for(Node node : root.children) {
        	ans = Math.max(ans, maxDepth(node));
        }
        return ans + 1;
    }
    
    // 广度优先遍历,重点学习这种思想
    public int maxDepth1(Node root) {
    	int ans = 0;
    	Deque<Node> queue = new ArrayDeque<>();
    	if (root == null) {
			return ans;
		}
    	queue.add(root);
    	while(!queue.isEmpty()) {
    		int size = queue.size();
    		while (size-- > 0) {
				Node temp = queue.pollFirst();
				for(Node node : temp.children) {
					queue.addLast(node);
				}
			}
    		ans++;
    	}
    	return ans;
    }
}
