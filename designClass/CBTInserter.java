package designClass;

import java.util.ArrayDeque;
import java.util.Queue;

import tree.TreeNode;

public class CBTInserter {
	// leetcode 919 medium 2022/7/25
	// �����ǹ�����ȫ������������ʹ�ö������ݽṹ���������������
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
			}else {//��Ϊ����ȫ�������������������������˵����ǰ�������Ѿ�������
				break;
			}
    		if (tempNode.right != null) {
    			queue.add(tempNode.right);
    			queue.poll();//������ӽڵ���ڣ���˵�����ڵ��Ѿ������ٲ��������ӽڵ㣬�Ƴ�����
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
