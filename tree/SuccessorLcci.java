package tree;

import java.util.ArrayDeque;
import java.util.Deque;

public class SuccessorLcci {
	// leetcode 2562 medium 2022/5/16
	// 首先容易想到使用中序遍历解题
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
    	Deque<TreeNode> queue = new ArrayDeque<>();
    	inSearch(root,queue);
    	TreeNode curNode = queue.pollFirst();
    	while(!queue.isEmpty() && curNode.val != p.val) {
    		curNode = queue.pollFirst();
    	}
    	if (queue.isEmpty()) {
			return null;
		}
    	return queue.pollFirst();
    }

	private void inSearch(TreeNode root, Deque<TreeNode> queue) {
		if (root == null) {
			return;
		}
		inSearch(root.left, queue);
		queue.addLast(root);
		inSearch(root.right, queue);
	}
	
	// 由于是bst，可以利用性质解题
	public TreeNode inorderSuccessor1(TreeNode root, TreeNode p) {
		TreeNode parent = null,node = root;
		while(node != null) {
			if (node.val > p.val) { // 当前节点大于所求节点，则往左子树走
				parent = node;
				node = node.left;
			}else if (node.val < p.val) {// 当前节点小于所求节点，则往右子树走，但右节点的中序遍历没有后继者
				node = node.right;
			}else if(node.right != null){// 当前节点等于所求节点，则后继者是右子树中最小的节点,即所求节点的右子树的最左节点
				node = node.right;
				while(node.left != null) {
					node = node.left;
				}
				return node;
			}else {
				return parent;
			}
		}
		return parent;
	}
}
