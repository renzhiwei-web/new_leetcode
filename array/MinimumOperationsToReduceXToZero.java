package array;


public class MinimumOperationsToReduceXToZero {
    // leetcode 1658 medium 2023/1/7
    // 将问题转换为求数组中最长和为sum-x的子数组
    // 使用双指针求解
    public int minOperations(int[] nums, int x) {
        int target = -x;
        for (int num : nums) {
            target += num;
        }
        if (target < 0){
            return -1;
        }
        int ans = -1;
        int left = 0,sum = 0,n = nums.length;
        for (int right = 0;right < n;right++){
            sum += nums[right];
            while (sum > target){
                sum -= nums[left++];
            }
            if (sum == target){
                ans = Math.max(ans,right - left + 1);
            }
        }
        return ans < 0 ? -1 : n - ans;
    }
}
