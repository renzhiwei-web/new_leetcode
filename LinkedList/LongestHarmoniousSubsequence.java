package array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LongestHarmoniousSubsequence {
	// leetcode 594 simple 2022/5/6
	// 由于不必返回具体的和谐数组，只需返回数组的长度，使用排序，然后使用滑动窗口进行解题
    public int findLHS1(int[] nums) {
    	Arrays.sort(nums);
    	int left = 0,right = 0;
    	int ans = 0;
    	while(right < nums.length) {
    		while(nums[right] - nums[left] > 1) {
    			left++;
    		}
    		if (nums[right] - nums[left] == 1) {
				ans = Math.max(ans, right - left + 1);
			}
    		right++;
    	}
    	return ans;
    }
    
    // 使用哈希表法，和谐数组的长度是相邻两数出现次数之和
    public int findLHS(int[] nums) {
    	Map<Integer, Integer> hash = new HashMap<Integer, Integer>();
    	for(int num : nums) {
    		hash.put(num, hash.getOrDefault(num, 0) + 1);
    	}
    	int ans = 0;
		/*
		 * for(int num : nums) { if (hash.containsKey(num - 1)) { ans = Math.max(ans,
		 * hash.get(num) + hash.get(num - 1)); }
		 * 
		 * }
		 */
    	for(Map.Entry<Integer, Integer> entry : hash.entrySet()) {
    		if (hash.containsKey(entry.getKey() - 1)) {
				ans = Math.max(ans, entry.getValue() + hash.get(entry.getKey() - 1));
			}
    	}
    	return ans;
    }
}
