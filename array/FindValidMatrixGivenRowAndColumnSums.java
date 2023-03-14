package array;

public class FindValidMatrixGivenRowAndColumnSums {
    // leetcode 1605 medium 2023/3/14
    // 贪心算法
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int row = rowSum.length,col = colSum.length;
        int[][] ans = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int x = Math.min(rowSum[i],colSum[j]);
                ans[i][j] = x;
                rowSum[i] -= x;
                colSum[j] -= x;
            }
        }
        return ans;
    }
}
