package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimumSubsequenceInNonIncreasingOrder {
	// leetcode 1403 simple 2022/8/4
	// 贪心算法，注意子序列的定义
    public List<Integer> minSubsequence(int[] nums) {
    	int sum = 0;
    	for(int i = 0;i < nums.length;i++) {
    		sum += nums[i];

    	}
    	Arrays.sort(nums);
    	List<Integer> ans = new ArrayList<>();
    	int ansSum = 0;
    	int i = nums.length - 1;
    	while(ansSum * 2 <= sum && i >= 0) {
    		ans.add(nums[i]);
    		ansSum += nums[i--];
    	}
    	return ans;
    }
}
