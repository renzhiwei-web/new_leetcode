package array;

public class NRepeatedElementInSize2nArray {
	// leetcode 961 simple 2022/5/21
	// 首先想到暴力法，即用哈希法
	// 长度为2N中寻找重复N次的元素，将2n个位置看成n个抽屉，每个抽屉装两个数，要么他们各自在一个抽屉中(相隔),要么存在一对在一个抽屉中相邻
    public int repeatedNTimes(int[] nums) {
    	if (nums[0] == nums[3]) {
			return nums[0];
		}
    	for(int i = 0;i < nums.length;i++) {
    		if (nums[i] == nums[i + 1] || nums[i] == nums[i + 2]) {
				return nums[i];
			}
    	}
    	return -1;
    }
   
}
