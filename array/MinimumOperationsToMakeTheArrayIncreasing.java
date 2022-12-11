package array;

public class MinimumOperationsToMakeTheArrayIncreasing {
    // leetcode 1827 simple 2022/12/11
    // 使用贪心算法
    public int minOperations(int[] nums) {
        int ans = 0;
        if (nums.length == 1){
            return 0;
        }
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]){
                continue;
            }
            ans += nums[i - 1] + 1 - nums[i];
            nums[i] = nums[i - 1] + 1;
        }
        return ans;
    }
}
