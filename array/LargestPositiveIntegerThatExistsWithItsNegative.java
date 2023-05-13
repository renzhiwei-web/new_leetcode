package array;


import java.util.Arrays;

public class LargestPositiveIntegerThatExistsWithItsNegative {
    // leetcode 2441 simple 2023/5/13
    // 排序，然后使用双指针简单模拟即可
    public int findMaxK(int[] nums) {
        Arrays.sort(nums);
        int left = 0,right = nums.length - 1;
        while (left < right){
            // 进行剪枝
            if (nums[left] > 0 || nums[right] < 0){
                break;
            }
            int abs = Math.abs(nums[left]);
            if (abs == nums[right]){
                return abs;
            } else if (abs < nums[right]) {
                right--;
            } else {
                left++;
            }
        }
        return -1;
    }
}
