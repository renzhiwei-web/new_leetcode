package array;

public class MaximumAverageSubarrayI {
	// leetcode 643 simple 2022/5/18
	// 使用滑动窗口+前缀和解题
    public double findMaxAverage(int[] nums, int k) {
		int len = nums.length;
		int[] prefix = new int[len + 1];
		for(int i = 1;i <=len;i++) {
			prefix[i] = prefix[i - 1] + nums[i - 1];
		}
		double max = prefix[k];
		for(int i = k + 1;i <= len;i++) {
			double temp = prefix[i] - prefix[i - k];
			if (temp > max) {
				max = temp;
			}
		}
		return max / k;
    }
    
    // 单独使用滑动窗口
    public double findMaxAverage1(int[] nums, int k) {
    	int len = nums.length;
    	double sum = 0;
    	for(int i = 0;i < k;i++) {
    		sum += nums[i];
    	}
    	double max = sum;
    	for(int i = k;i < len;i++) {
    		sum = sum - nums[i - k] + nums[i];
    		if (max < sum) {
				max = sum;
			}
    	}
    	return max / k;
    }
}
