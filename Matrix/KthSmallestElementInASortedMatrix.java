package graph;

public class KthSmallestElementInASortedMatrix {
	// leetcode 378 medium 2022/5/18
	// 此题是 668 的初始版本，相似的解法
    public int kthSmallest(int[][] matrix, int k) {
    	int n = matrix.length;
    	int left = matrix[0][0],right = matrix[n - 1][n - 1];
    	while(left < right) {
    		int mid = (left + right) >> 1;
    		if (check(matrix,mid,k,n)) {
				right = mid;
			}else {
				left = mid + 1;
			}
    	}
    	return left;
    }

	private boolean check(int[][] matrix, int mid, int k, int n) {
		int i = n - 1;
		int j = 0;
		int num = 0;
		while(i >= 0 && j < n) {// 由于比mid数大的数值的个数，都在矩阵的右下角，从第一列依次判断
			if (matrix[i][j] <= mid) {// 当前列前i行小于等于mid值，则计数+(i + 1)
				num += i + 1;
				j++;//再判断下一列
			}else {
				i--;// 当前列的当前行大于mid值，减小i值再重新判断
			}
		}
		return num >= k;
	}
}
