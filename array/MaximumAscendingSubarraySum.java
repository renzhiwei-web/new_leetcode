package array;

public class MaximumAscendingSubarraySum {
	// leetcode 1800 simple 2022/10/7
	// ¼òµ¥Ä£Äâ
    public int maxAscendingSum(int[] nums) {
    	int max = nums[0];
    	int ans = 0;
    	for(int i = 1;i < nums.length;i++) {
    		if (nums[i] > nums[i - 1]) {
				max += nums[i];
			}else {
				ans = Math.max(ans, max);
				max = nums[i];
			}
    	}
    	return Math.max(max, ans);
    }
}
