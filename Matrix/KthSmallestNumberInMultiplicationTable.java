package graph;

public class KthSmallestNumberInMultiplicationTable {
	// leetcode 668 hard 2022/5/18
	// 首先容易想到暴力法，将乘法表存储在矩阵中，使用归并排序解题。效率很低
	// 使用二分法进行解题，一个反向问题：对于乘法表中的数字x，它是乘法表中的第几小的数字
    public int findKthNumber(int m, int n, int k) {
    	int left = 1,right = m * n;
    	while(left < right) {
    		// 计算二分的mid
    		int x = left + (right - left) / 2;
    		// (x / n)行都是小于等于x的直接计数
    		int count = x / n * n;
    		// 从(x / n + 1)行开始逐行比较，由于是乘法表，所以x / i(行数)表示小于等于x的个数
    		for(int i = x / n + 1;i <= m;i++) {
    			count += x / i;
    		}
    		if (count >= k) {
				right = x;
			}else {
				left = x + 1;
			}
    	}
    	return left;
    }
}
