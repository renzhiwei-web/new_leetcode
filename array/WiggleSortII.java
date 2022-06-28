package array;

import java.util.Arrays;

public class WiggleSortII {
	//leetcode 324 medium 2022/6/28
	// 使用另辟空间的方法，时间复杂度为o(n)
    public void wiggleSort(int[] nums) {
    	int[] clone = nums.clone();
    	Arrays.sort(clone);
    	//两个指针
        int left = (nums.length - 1) / 2, right = nums.length - 1;
        //依次放置
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                nums[i] = clone[left];
                left--;
            } else {
                nums[i] = clone[right];
                right--;
            }
        }
    }
}
