package tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MostFrequentSubtreeSum {
	
	// leetcode 508 medium 2022/6/19
	// 首先容易想到使用深度遍历的方法进行递归的计算子元素的和
	Map<Integer, Integer> cnt = new HashMap<>();
	int maxCnt = 0;
    public int[] findFrequentTreeSum(TreeNode root) {
    	dfs(root);
    	List<Integer> list = new ArrayList<>();
    	for(Map.Entry<Integer, Integer> entry : cnt.entrySet()) {
    		int s = entry.getKey(),c = entry.getValue();
    		if (c == maxCnt) {
				list.add(s);
			}
    	}
    	int[] ans = new int[list.size()];
    	for(int i = 0;i < list.size();i++) {
    		ans[i] = list.get(i);
    	}
    	return ans;
    }
	private int dfs(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int sum = root.val + dfs(root.left) + dfs(root.right);
		cnt.put(sum, cnt.getOrDefault(sum, 0) + 1);
		maxCnt = Math.max(cnt.get(sum), maxCnt);
		return sum;
	}
}
