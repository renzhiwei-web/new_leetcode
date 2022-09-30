package array;

public class ZeroMatrix {
	// leetcode 2690 medium 2022/9/30
	// 简单模拟
    public void setZeroes(int[][] matrix) {
    	int row = matrix.length;
    	int col = matrix[0].length;
    	boolean[] zeroRow = new boolean[row]; // 存放改行或该列是否有 0 元素
    	boolean[] zeroCol = new boolean[col];
    	for(int i = 0;i < row;i++) { // 遍历矩阵，将所有0元素所在的行，列找到
    		for(int j = 0;j < col;j++) {
    			if (matrix[i][j] == 0) {
					zeroRow[i] = true;
					zeroCol[j] = true;
				}
    		}
    	}
    	// 重新遍历矩阵，利用两个bool数组来改造数组
    	for(int i = 0;i < row;i++) {
    		for(int j = 0;j < col;j++) {
    			if (zeroRow[i] || zeroCol[j]) {
    				matrix[i][j] = 0;
    			}
    		}
    	}
    }
}
