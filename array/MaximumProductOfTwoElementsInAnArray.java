package array;

public class MaximumProductOfTwoElementsInAnArray {
	// leetcode 1464 simple 2022/8/26
	// 简单模拟，维护最大值与次最大值
    public int maxProduct(int[] nums) {
    	int max = 0,submax = 0;
    	for(int i = 0;i < nums.length;i++) {
    		if (nums[i] > max) {
    			submax = max;
				max = nums[i];
			}else if (nums[i] > submax) {
				submax = nums[i];
			}
    	}
    	
    	return (max - 1) * (submax - 1);
    }
}
