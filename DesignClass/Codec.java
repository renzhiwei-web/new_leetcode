package designClass;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import tree.TreeNode;

public class Codec {
	// leetcode 449 medium 2022/5/11
	// 由题意可得首先可以使用bfs来进行解题，但是没有利用bst的特性
	// 此题解同样是leetocde 297 的题解
    // Encodes a tree to a single string.
    public String serialize1(TreeNode root) {
    	if (root == null) {
			return "";
		}
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        StringBuilder sb = new StringBuilder();
        while(!queue.isEmpty()) {
        	TreeNode tempNode = queue.poll();
        	if (tempNode != null) {
				sb.append(tempNode.val);
				queue.offer(tempNode.left);
				queue.offer(tempNode.right);
			}
        	else {
				sb.append("null");
			}
        	sb.append(",");
        	
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize1(String data) {
        if (data == null || data.equals("")) {
			return null;
		}
        String[] nodes = data.split(",");
        int n = nodes.length,count = 1;
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty() && count < n) {
        	TreeNode node = queue.poll();
        	if (nodes[count].equals("null")) {
				node.left = null;
			}else {
				node.left = new TreeNode(Integer.parseInt(nodes[count]));
				queue.offer(node.left);
			}
        	count++;
        	if (nodes[count].equals("null")) {
				node.right = null;
			}else {
				node.right = new TreeNode(Integer.parseInt(nodes[count]));
				queue.offer(node.right);
			}
        	count++;
        }
        return root;
    }
    
    // 通过利用bst的特性，由于bst中知道前序遍历或者后序遍历后，即可知道bst的中序遍历，便可构造出整个树
    public String serialize(TreeNode root) {
    	List<Integer> list = new ArrayList<>();
    	postOrder(root,list);
    	String str = list.toString();
    	return str.substring(1,str.length() - 1);// 消除前后两个中括号
    }

	private void postOrder(TreeNode root, List<Integer> list) {
		if (root == null) {
			return;
		}
		postOrder(root.left, list);
		postOrder(root.right, list);
		list.add(root.val);
	}
	
	public TreeNode deserialize(String data) {
		if (data.equals("")) {
			return null;
		}
		String[] arr = data.split(", ");
		Deque<Integer> stack = new ArrayDeque<>();
		int len = arr.length;
		for(int i = 0;i < len;i++) {
			stack.push(Integer.parseInt(arr[i]));
		}
		return construct(Integer.MIN_VALUE,Integer.MAX_VALUE,stack);
	}

	private TreeNode construct(int minValue, int maxValue, Deque<Integer> stack) {
		if (stack.isEmpty() || stack.peek() < minValue || stack.peek() > maxValue) {
			return null;
		}
		int val = stack.pop();
		TreeNode root = new TreeNode(val);
		root.right = construct(val, maxValue, stack);
		root.left = construct(minValue, val, stack);
		return root;
	}
}
