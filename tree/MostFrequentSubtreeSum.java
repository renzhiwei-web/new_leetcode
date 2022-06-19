package tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MostFrequentSubtreeSum {
	
	// leetcode 508 medium 2022/6/19
	// ���������뵽ʹ����ȱ����ķ������еݹ�ļ�����Ԫ�صĺ�
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
