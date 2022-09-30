package array;

public class ZeroMatrix {
	// leetcode 2690 medium 2022/9/30
	// ��ģ��
    public void setZeroes(int[][] matrix) {
    	int row = matrix.length;
    	int col = matrix[0].length;
    	boolean[] zeroRow = new boolean[row]; // ��Ÿ��л�����Ƿ��� 0 Ԫ��
    	boolean[] zeroCol = new boolean[col];
    	for(int i = 0;i < row;i++) { // �������󣬽�����0Ԫ�����ڵ��У����ҵ�
    		for(int j = 0;j < col;j++) {
    			if (matrix[i][j] == 0) {
					zeroRow[i] = true;
					zeroCol[j] = true;
				}
    		}
    	}
    	// ���±���������������bool��������������
    	for(int i = 0;i < row;i++) {
    		for(int j = 0;j < col;j++) {
    			if (zeroRow[i] || zeroCol[j]) {
    				matrix[i][j] = 0;
    			}
    		}
    	}
    }
}
