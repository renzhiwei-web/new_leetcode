package array;

public class RotateArray {
    // leetcode 189 medium 2022/12/3
    // 首先可以想到暴力法，通过使用额外数组进行解题
    // 第二种方法 可以使用轮转方法
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start += 1;
            end -= 1;
        }
    }
}
