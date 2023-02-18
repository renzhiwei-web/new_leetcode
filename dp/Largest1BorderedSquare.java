package dp;

public class Largest1BorderedSquare {
    // leetcode 1139 medium 2023/2/18
    // 适用动态规划解决最优化问题
    public int largest1BorderedSquare(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        // left[x][y]表示以x,y为起点左侧连续1的最大数目
        int[][] left = new int[m + 1][n + 1];
        // up[x][y]表示x,y为起点的上方连续1的最大数目
        int[][] up = new int[m + 1][n + 1];
        int maxBorder = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // 如果当前数字为1，则更新left，up
                if (grid[i - 1][j - 1] == 1){
                    left[i][j] = left[i][j - 1] + 1;
                    up[i][j] = up[i - 1][j] + 1;
                    // 在上边界与右边界得出最小的l
                    int border = Math.min(left[i][j],up[i][j]);
                    // 计算符合right与down条件的l
                    while (left[i - border + 1][j] < border || up [i][j - border + 1] < border){
                        border--;
                    }
                    maxBorder = Math.max(maxBorder,border);
                }
            }
        }
        return maxBorder * maxBorder;
    }
}
