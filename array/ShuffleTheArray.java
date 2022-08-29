package array;

public class ShuffleTheArray {
	// leetcode 1470 simple 2022/8/29
	// 方法一，使用额外的空间
    public int[] shuffle(int[] nums, int n) {
    	int[] ans = new int[2 * n];
    	for(int i = 0;i < n;i++) {
    		ans[2 * i] = nums[i];
    		ans[2 * i + 1] = nums[n + i];
    	}
    	return ans;
    }
}
