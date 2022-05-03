package math;

import java.util.Arrays;

public class ArrayPartitionI {
	// leetcode 561 simple 2022/5/3
	// 首先容易想到，对数组进行排序，每隔一个取值，即是答案
    public int arrayPairSum(int[] nums) {
    	Arrays.sort(nums);
    	int ans = 0;
    	for(int i = 0;i < nums.length;i += 2) {
    		ans += nums[i];
    	}
    	return ans;
    }
}
