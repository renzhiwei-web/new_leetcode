package DoublePoint;

public class MaxConsecutiveOnesIII {
    // leetcode 1004 同向双指针
    public int longestOnes(int[] nums, int k) {
        int len = nums.length;
        int count = 0; // 记录0的个数
        int ans = 0;
        int left = 0;
        for (int r = 0; r < len; r++) {
            count += 1 - nums[r];
            while (count > k) {
                count -= 1 - nums[left];
                left++;
            }
            ans = Math.max(ans,r - left + 1);
        }
        return ans;
    }
}
