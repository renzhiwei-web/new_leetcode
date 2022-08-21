package tree;

import java.util.ArrayDeque;
import java.util.Deque;

public class MaximumBinaryTree {
    // leetcode 654 medium 2022/8/20
	// �����뵽ʹ�õݹ�ģ��
	public TreeNode constructMaximumBinaryTree1(int[] nums) {
    	return func(new TreeNode(),nums,0,nums.length);
    }

	private TreeNode func(TreeNode root, int[] nums, int left, int right) {
		if (left == right) {
			return null;
		}
		int max = -1; // ��Ϊ��СֵΪ0
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
	
	// ʹ�õ���ջ������
	public TreeNode constructMaximumBinaryTree(int[] nums) {
		Deque<TreeNode> deque = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            TreeNode node = new TreeNode(nums[i]);
            while(!deque.isEmpty()) {
                TreeNode topNode = deque.peekLast();
                // ���ջ��Ԫ�ش��ڴ������Ԫ�أ���ջ��Ԫ��ֱ����ջ �� ջ��Ԫ�ص����ӽڵ�Ϊ������Ԫ��
                // ���ջ��Ԫ��С�ڴ������Ԫ�أ���ջ��Ԫ�س�ջ���� ������Ԫ�ص����ӽڵ�Ϊջ��Ԫ��
                if (topNode.val > node.val) {
                    deque.addLast(node);
                    topNode.right = node;
                    break;
                } else {
                    deque.removeLast(); // ��ջ����
                    node.left = topNode;
                }
            }
            if (deque.isEmpty()) deque.addLast(node);
        }
        return deque.peek();
	}
}
