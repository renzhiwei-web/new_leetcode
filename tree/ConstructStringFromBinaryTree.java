package tree;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

public class ConstructStringFromBinaryTree {
	// leetcode 606 simple 2022/5/12
	// 首先容易想到使用递归算法
	StringBuilder sb = new StringBuilder();
    public String tree2str1(TreeNode root) {
    	dfs(root);
    	return sb.substring(1, sb.length() - 1);
    }
	private void dfs(TreeNode root) {
		sb.append("(");
		sb.append(root.val);
		if (root.left != null) {
			dfs(root.left);
		}else if (root.right != null) {// 只有右子树而没有左子树时，要添加一个空括号
			sb.append("()");
		}
		if (root.right != null) {
			dfs(root.right);
		}
		sb.append(")");
	}
	
	// 非递归算法
	public String tree2str(TreeNode root) {
		StringBuilder sb = new StringBuilder();
		Set<TreeNode> vis = new HashSet<>();
		Deque<TreeNode> queue = new ArrayDeque<>();// 此为栈
		queue.addLast(root);
		while(!queue.isEmpty()) {
			TreeNode tempNode = queue.pollLast();
			if (vis.contains(tempNode)) {
				sb.append(")");
			}else {
				queue.addLast(tempNode);
				sb.append("(");
				sb.append(tempNode.val);
				if (tempNode.right != null) {// 由于使用栈，所以右节点先进栈，后出栈
					queue.addLast(tempNode.right);
				}
				if (tempNode.left != null) {
					queue.addLast(tempNode.left);
				}else if (tempNode.right != null) {
					sb.append("()");
				}
				vis.add(tempNode);
			}
		}
		return sb.substring(1, sb.length() - 1);
	}
}
