package tree;

import java.util.ArrayDeque;
import java.util.Deque;

public class MaximumBinaryTree {
    // leetcode 654 medium 2022/8/20
	// 首先想到使用递归模拟
	public TreeNode constructMaximumBinaryTree1(int[] nums) {
    	return func(new TreeNode(),nums,0,nums.length);
    }

	private TreeNode func(TreeNode root, int[] nums, int left, int right) {
		if (left == right) {
			return null;
		}
		int max = -1; // 因为最小值为0
		int maxIndex = -1;;
		for(int i = left;i < right;i++) {
			if (nums[i] > max) {
				max = nums[i];
				maxIndex = i;
			}
		}
		root.val = max;
		root.left = func(new TreeNode(), nums, left, maxIndex);
		root.right = func(new TreeNode(), nums, maxIndex + 1, right);
		return root;
	}
	
	// 使用单调栈来进行
	public TreeNode constructMaximumBinaryTree(int[] nums) {
		Deque<TreeNode> deque = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            TreeNode node = new TreeNode(nums[i]);
            while(!deque.isEmpty()) {
                TreeNode topNode = deque.peekLast();
                // 如果栈顶元素大于待插入的元素，则栈顶元素直接入栈 且 栈顶元素的右子节点为待插入元素
                // 如果栈顶元素小于待插入的元素，则栈顶元素出栈，且 待插入元素的左子节点为栈顶元素
                if (topNode.val > node.val) {
                    deque.addLast(node);
                    topNode.right = node;
                    break;
                } else {
                    deque.removeLast(); // 出栈操作
                    node.left = topNode;
                }
            }
            if (deque.isEmpty()) deque.addLast(node);
        }
        return deque.peek();
	}
}
