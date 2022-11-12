package dp;

public class DominoAndTrominoTiling {
    // leetcode 790 medium 2022/11/12
    // 动态规划，最重要的是找到动态转移方程
    // 规律展示https://leetcode.cn/problems/domino-and-tromino-tiling/solution/by-endlesscheng-umpp/
    private static final long MOD = (long)1e9 + 7;
    public int numTilings(int n) {
        if (n == 1) {
            return 1;
        }
        long[] dp = new long[n + 1];
        dp[0] = dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = (2 * dp[i - 1] + dp[i - 3]) % MOD;
        }
        return (int)dp[n];
    }
}
