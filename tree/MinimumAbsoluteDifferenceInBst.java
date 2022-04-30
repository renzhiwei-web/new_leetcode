package tree;

import java.util.ArrayList;
import java.util.List;

public class MinimumAbsoluteDifferenceInBst {
	// leetcode 530 simple 2022/4/30
	// 暴力法，将二叉搜索树的所有节点的值存放在数组中，通过遍历数组来求得结果
    public int getMinimumDifference1(TreeNode root) {
    	if (root == null) {
			return 0;
		}
    	List<Integer> list = new ArrayList<>();
    	midSearchlist(list,root);
    	// 由于是二叉搜索树，只需要查询每两个数字之间的差值即可
    	int ans = Integer.MAX_VALUE;
    	for(int i = 0;i < list.size() - 1;i++) {
    		int j = i + 1;
    		ans = Math.min(ans, Math.abs(list.get(j) - list.get(i)));
    	}
    	return ans;
    }

	private void midSearchlist(List<Integer> list, TreeNode root) {
		if (root == null) {
			return;
		}
		midSearchlist(list, root.left);
		list.add(root.val);
		midSearchlist(list, root.right);
	}
	int pre;
	int ans;
	//对暴力法进行优化,只遍历一次，且使用一个数字来代替数组
	public int getMinimumDifference(TreeNode root) {
		ans = Integer.MAX_VALUE;
		pre = -1;
		midSearch(root);
		return ans;
	}

	private void midSearch(TreeNode root) {
		if (root == null) {
			return;
		}
		midSearch(root.left);
		if (pre == -1) {
			pre = root.val;
		}else {
			ans = Math.min(ans, root.val - pre);
			pre = root.val;
		}
		midSearch(root.right);
	}
}
