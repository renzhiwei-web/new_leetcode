package graph;

public class NumMatrix {
	// leetcode 304 mdeium 2022/4/29
	// 二维数组前缀和计算，想象是矩阵中面积的计算，注意的是pre[i + 1][j + 1]表示的是(0,0),(i,j)的矩阵内元素总和
	int[][] pre;
	public NumMatrix(int[][] matrix) {
		int m = matrix.length,n = matrix[0].length;
		pre = new int[m + 1][n + 1];
		for(int i = 1;i <= m;i++) {
			for(int j = 1;j <= n;j++) {
				pre[i][j] = pre[i - 1][j] + pre[i][j - 1] - pre[i - 1][j - 1] + matrix[i - 1][j - 1];
			}
		}
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
    	return pre[row2 + 1][col2 + 1] - pre[row1][col2 + 1] - pre[row2 + 1][col1] + pre[row1][col1];
    }
}
