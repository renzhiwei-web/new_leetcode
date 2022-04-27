package tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindModeInBinarySearchTree {
	Map<Integer, Integer> hash;
	int max = 0;
    public int[] findMode(TreeNode root) {
    	hash = new HashMap<>();
    	dfs(root);
    	List<Integer> ans = new ArrayList<>();
    	for(Map.Entry<Integer, Integer> entry : hash.entrySet()) {
    		if (entry.getValue() == max) {
				ans.add(entry.getKey());
			}
    	}
    	int[] res = new int[ans.size()];
    	for(int i = 0;i < ans.size();i++) {
    		res[i] = ans.get(i);
    	}
    	return res;
    }
    
    private void dfs(TreeNode node) {
    	if (node == null) {
			return;
		}
		int temp = hash.getOrDefault(node.val, 0) + 1;
		hash.put(node.val, temp);
		max = Math.max(temp, max);
		dfs(node.left);
		dfs(node.right);
	}
}
