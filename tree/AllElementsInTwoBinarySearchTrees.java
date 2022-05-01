package tree;

import java.util.ArrayList;
import java.util.List;

public class AllElementsInTwoBinarySearchTrees {
	// leetcode 1305 medium 2022/5/1
	// 容易想到中序遍历两棵二叉排序树，再使用归并排序
    public List<Integer> getAllElements1(TreeNode root1, TreeNode root2) {
    	List<Integer> list1 = new ArrayList<>(),list2 = new ArrayList<>();
    	midSearch(list1,root1);
    	midSearch(list2,root2);
    	int i = 0,j = 0;
    	List<Integer> ans = new ArrayList<>();
    	while(i < list1.size() && j < list2.size()) {
    		if (list1.get(i) <= list2.get(j)) {
				ans.add(list1.get(i));
				i++;
			}else {
				ans.add(list2.get(j));
				j++;
			}
    	}
    	while(i < list1.size()) {
    		ans.add(list1.get(i++));
    	}while(j < list2.size()) {
    		ans.add(list2.get(j++));
    	}
    	return ans;
    }

	private void midSearch(List<Integer> list, TreeNode root) {
		if (root == null) {
			return;
		}
		midSearch(list, root.left);
		list.add(root.val);
		midSearch(list, root.right);
	}
}
