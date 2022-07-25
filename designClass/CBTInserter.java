package designClass;

import java.util.ArrayDeque;
import java.util.Queue;

import tree.TreeNode;

public class CBTInserter {
	// leetcode 919 medium 2022/7/25
	// 由于是构造完全二叉树，所以使用队列数据结构，层序遍历二叉树
	Queue<TreeNode> queue;
	TreeNode rootNode;
    public CBTInserter(TreeNode root) {
    	queue = new ArrayDeque<>();
    	rootNode = root;
    	queue.add(root);
    	while(!queue.isEmpty()) {
    		TreeNode tempNode = queue.peek();
    		if (tempNode.left != null) {
				queue.add(tempNode.left);
			}else {//因为是完全二叉树，如果不存在子树，则说明当前二叉树已经遍历完
				break;
			}
    		if (tempNode.right != null) {
    			queue.add(tempNode.right);
    			queue.poll();//如果右子节点存在，则说明父节点已经不能再插入其他子节点，推出队列
			}else {
				break;
			}
    	}
    }
    
    public int insert(int val) {
    	TreeNode tempNode = queue.peek();
    	TreeNode newNode = new TreeNode(val);
    	queue.offer(newNode);
    	if (tempNode.left == null) {
    		tempNode.left = newNode;
		}else {
			tempNode.right = newNode;
			queue.poll();
		}
    	return tempNode.val;
    }
    
    public TreeNode get_root() {
    	return rootNode;
    }
}
