package dp;

import java.util.HashMap;
import java.util.Map;

public class LengthOfLongestFibonacciSubsequence {
	// leetcode 873 medium 2022/7/9
	// 斐波那契数列数列，最小由3个数字组成，当最后两个数字确定，则，才能确定整个斐波那契数列
    public int lenLongestFibSubseq(int[] arr) {
    	int n = arr.length;
    	if (n == 0) {
			return 0;
		}
    	Map<Integer, Integer> map = new HashMap<>();
    	for(int i = 0;i < n;i++) {
    		map.put(arr[i], i);
    	}
    	// 定义二维数组 dp 表示以每个下标对的元素作为最后两个数字的斐波那契子序列的最大长度
    	// dp[j][i]表示以arr[i],arr[j]作为最后两个数字的斐波那契子序列的最大长度
    	int[][] dp = new int[n][n];
    	int ans = 0;
    	for(int i = 0;i < n;i++) {
    		// 剪枝，若arr[j] * 2 <= arr[i],则不存在arr[k],使得arr[k] + arr[j] = arr[i]
    		for(int j = i - 1;j >= 0 && arr[j] * 2 > arr[i];j--) {
    			// 判断是否存在arr[k],满足斐波那契数列
    			int k = map.getOrDefault(arr[i] - arr[j], -1);
    			if (k >= 0) {
					dp[j][i] = Math.max(dp[k][j] + 1, 3);
				}
    			ans = Math.max(ans, dp[j][i]);
    		}
    	}
    	return ans;
    }
}
