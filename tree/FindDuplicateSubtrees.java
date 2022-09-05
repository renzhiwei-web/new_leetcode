package tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindDuplicateSubtrees {
	// leetcode 652 medium 2022/9/5
	// 二叉树中使用哈希表进行解题
	Map<String, Integer> map = new HashMap<>();
	List<TreeNode> ans = new ArrayList<>();
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
    	dfs(root);
    	return ans;
    }
    
    String dfs(TreeNode root) {
    	if (root == null) {
			return " ";
		}
    	StringBuilder sb = new StringBuilder();
    	sb.append(root.val).append("-");
    	sb.append(dfs(root.left)).append(dfs(root.right));
    	String key = sb.toString();
    	map.put(key, map.getOrDefault(key, 0) + 1);
    	if (map.get(key) == 2) {
			ans.add(root);
		}
    	return key;
    }
}
