package array;

import java.util.Arrays;

public class MaximumLengthOfPairChain {
	// leetcode 646 medium 2022/9/3
	// 使用动态规划，也是暴力方法
    public int findLongestChain1(int[][] pairs) {
    	int n = pairs.length;
    	// 对数对进行排序，以第一个数为基准
    	Arrays.sort(pairs,(a,b) -> a[0] - b[0]);
    	int[] dp = new int[n];
    	Arrays.fill(dp, 1);
    	for(int i = 0;i < n;i++) {
    		for(int j = 0;j < i;j++) {
    			if (pairs[i][0] > pairs[j][1]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
    		}
    	}
    	return dp[n - 1];
    }
    
    // 使用贪心算法，要挑选最长数对链的第一个数对时，最优的选择是挑选第二个数字最小的，这样能给挑选后续的数对留下更多的空间
    public int findLongestChain(int[][] pairs) {
    	int cur = Integer.MIN_VALUE;
    	int ans = 0;
    	Arrays.sort(pairs,(a,b) -> a[1] - b[1]);
    	for(int[] p : pairs) {
    		if (cur < p[0]) {
				cur = p[1];
				ans++;
			}
    	}
    	return ans;
    }
}
