package dp;

public class CountSortedVowelStrings{
    // leetcode 1641 medium 2023/3/29
    // 数学方法+动态规划
    public int countVowelStrings(int n) {
        // dp[i][j] 表示长度为 i+1，以 j 结尾的按字典序排列的字符串数量
        int[][] dp = new int[n][5];
        for (int i = 0; i < 5; i++) {
            dp[0][i] = 1;// 初始化
        }
        for (int i = 1; i < n; i++) {
            // a前只能是a
            dp[i][0] = dp[i - 1][0];
            // b前只能是b或a
            dp[i][1] = dp[i][0] + dp[i - 1][1];
            // 其他类似
            dp[i][2] = dp[i][1] + dp[i - 1][2];
            dp[i][3] = dp[i][2] + dp[i - 1][3];
            dp[i][4] = dp[i][3] + dp[i - 1][4];
        }
        int ans = 0;
        for (int i = 0; i < 5; i++) {
            ans += dp[n - 1][i];
        }
        return ans;
    }
}
