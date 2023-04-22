package dp;

public class LongestArithmeticSubsequence {
    // leetcode 1027 medium 2023/4/22
    // 二维数组的动态规划
    public int longestArithSeqLength(int[] nums) {
        int len = nums.length;
        int ans = 0;
        // dp[i][j] 表示nums数组以下标为i的数字为结尾，等差为j的等差数列的最大长度
        int[][] dp = new int[len][1001];
        // 由于等差可能为负数，所以将等差+500，变成正数以便于计算
        for (int i = 1; i < len; i++) {
            // 遍历下标i之前的所有数字
            for (int j = 0; j < i; j++) {
                int d = nums[i] - nums[j] + 500;
                dp[i][d] = Math.max(dp[i][d],dp[j][d] + 1);
                ans = Math.max(ans,dp[i][d]);
            }
        }
        return ans + 1;
    }
}
