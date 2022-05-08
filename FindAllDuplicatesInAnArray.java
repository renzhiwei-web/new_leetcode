package array;

import java.util.ArrayList;
import java.util.List;

public class FindAllDuplicatesInAnArray {
	// leetcode 442 medium 2022/5/8
	// 直接进行哈希方法即可
    public List<Integer> findDuplicates(int[] nums) {
    	int n = nums.length;
    	int[] hash = new int[n + 1];
    	List<Integer> ans = new ArrayList<>();
    	for(int num : nums) {
    		hash[num]++;
    	}
    	for(int i = 1;i <= n;i++) {
    		if (hash[i] == 2) {
				ans.add(i);
			}
    	}
    	return ans;
    }
}
