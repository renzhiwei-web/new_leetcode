package array;

public class MaxConsecutiveOnes {
	// leetcode 485 simple 2022/4/24
	// 使用滑动窗口简单模拟即可
    public int findMaxConsecutiveOnes(int[] nums) {
    	int ans = 0;
    	int i = 0,j = 0;
    	while(i < nums.length && j < nums.length) {
    		if(nums[i] == 1) {
    			j = i + 1;
    			while(j < nums.length && nums[j] == 1) {
    				j++;
    			}
    			if (j != nums.length) {
    				ans = Math.max(ans, j - i);
				}
    		}
    		i++;
    	}
    	return ans;
    }
}
