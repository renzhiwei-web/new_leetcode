package array;

public class ShuffleTheArray {
	// leetcode 1470 simple 2022/8/29
	// 方法一，使用额外的空间
    public int[] shuffle1(int[] nums, int n) {
    	int[] ans = new int[2 * n];
    	for(int i = 0;i < n;i++) {
    		ans[2 * i] = nums[i];
    		ans[2 * i + 1] = nums[n + i];
    	}
    	return ans;
    }
    
    // 方法二，原地进行数据变化
    // 利用int有占32个bit，而题目中给的数据范围为1000以内，则最多占10个bit
    public int[] shuffle(int[] nums, int n) {
    	for(int i = 0; i < 2 * n; i ++){
            int j = i < n ? 2 * i : 2 * (i - n) + 1;//i是原始数据，j是数据的新下标
            nums[j] |= ((nums[i] & 1023) << 10);//从nums[i]低10位上取出原数据，用nums[j]的11-20bit位来存
        }
        for(int i = 0;i < 2 * n;i++) nums[i] >>= 10;//右移10位，高位补0，只留下重新排列后的数据
        return nums;
    }
}
