package math;

public class SmallestRangeI {
	// leetcode 908 simple 2022/4/30
	// 仔细观察题意，要求求出操作后的最大值与最小值的最小差值
	// 由于操作的范围是[-k,k]，则原始数组的最大值与最小值的差值小于等与2k，那么操作后的数组最小差值一定是0，，若大于2k，则差值-2k即为最后的结果
    public int smallestRangeI(int[] nums, int k) {
    	int max = -1,min = Integer.MAX_VALUE;
    	for(int num : nums) {
    		if (num > max) {
				max = num;
			}
    		if (num < min) {
				min = num;
			}
    	}
    	int ans = 0;
    	int temp = max - min - 2 * k;
    	if (temp > 0) {
			ans = temp;
		}
    	return ans;
    	
    }
}
