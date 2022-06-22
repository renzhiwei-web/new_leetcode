package tree;

import java.util.ArrayDeque;
import java.util.Deque;

public class FindBottomLeftTreeValue {
	// leetcode 513 medium 2022/6/22
	// ��Ϊ�漰����Σ����������뵽����������������㷨�������bfs����С�Ľ����ȱ������������ٱ���������
	
	// ������������㷨�Ƚϲ������뵽���ݹ�Ĺ����У���height��¼��ǰ����ȣ�ֻ���ڵݹ�����Ż�ִ������if���
	int curVal = 0;
	int curHeight = 0;
	
    public int findBottomLeftValue(TreeNode root) {
    	dfs(root,0);
    	return curVal;
    }

	private void dfs(TreeNode root, int height) {
		// TODO Auto-generated method stub
		if (root == null) {
			return;
		}
		height++;
		dfs(root.left, height);
		dfs(root.right, height);
		
		if (height > curHeight) {
			curHeight = height;
			curVal = root.val;
		}
	}
	
	// ������������㷨
	public int findBottomLeftValue1(TreeNode root) {
		Deque<TreeNode> queue = new ArrayDeque<>();
		int ans = 0;
		if (root != null) {
			queue.add(root);
		}
		while(!queue.isEmpty()) {
			TreeNode node = queue.removeFirst();
			ans = node.val;
			if (node.right != null) {
				queue.add(node.right);
			}
			if (node.left != null) {
				queue.add(node.left);
			}
			
		}
		return ans;
	}
}
