package array;

public class ChampagneTower {
    // leetcode 799 medium 2022/11/20
    // 使用动态规划模拟即可
    public double champagneTower(int poured, int query_row, int query_glass) {
        double[][] dp = new double[query_row + 2][query_row + 2];
        dp[1][1] = poured;// 为了防止越界，下标0，0放在1，1的位置上
        for (int row = 2; row <= query_row + 1; row++) {
            for (int column = 1; column <= row; column++) {
                dp[row][column] = Math.max(dp[row - 1][column - 1] - 1,0) / 2 + Math.max(dp[row - 1][column] - 1,0) / 2;

            }
        }
        return Math.min(dp[query_row + 1][query_glass + 1],1);
    }

    public double champagneTower1(int poured, int query_row, int query_glass) {
        double[] dp = {poured};
        for (int row = 1; row <= query_row; row++) {
            double[] nextRow = new double[row + 1];
            for (int cloumn = 0; cloumn < row; cloumn++) {
                double volume = dp[cloumn];
                if (volume > 1){
                    nextRow[cloumn] += (volume - 1) / 2;
                    nextRow[cloumn + 1] += (volume - 1) / 2;
                }
            }
            dp = nextRow;
        }
        return Math.min(dp[query_glass],1);
    }
}
