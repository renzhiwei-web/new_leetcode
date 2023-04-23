package dp;

public class FillingBookcaseShelves {
    // leetcode 1105 medium 2023/4/23
    // 动态规划
    public int minHeightShelves(int[][] books, int shelfWidth) {
        int len = books.length;
        int[] dp = new int[len + 1];
        dp[0] = 0;
        for (int i = 1; i <= len; i++) {
            int w = books[i - 1][0],h = books[i - 1][1];
            // 先将这本书放在新的一层书架中(方式一)
            dp[i] = dp[i - 1] + h;
            for (int j = i - 1;j > 0;j--){
                // 向前遍历已经放过的书
                w += books[j - 1][0];
                // 如果可以同已经遍历过的的书同这本书放在同一层书架(方式二)，同时记录这层书架的最高度
                if (w > shelfWidth) {
                    break;
                }
                h = Math.max(h,books[j - 1][1]);
                // 判断方式一与方式二的最小值
                dp[i] = Math.min(dp[i],dp[j - 1] + h);
            }
        }
        return dp[len];
    }
}
