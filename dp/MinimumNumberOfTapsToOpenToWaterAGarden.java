package dp;

import java.util.Arrays;

public class MinimumNumberOfTapsToOpenToWaterAGarden {
    // leetcode 1326 hard 2023/2/21
    // 由题意可得，最优化问题，容易想到动态规划，题目可以转化为覆盖区间所使用最少的区间数目
    public int minTaps(int n, int[] ranges) {
        int[][] intervals = new int[n + 1][];
        for (int i = 0; i <= n; i++) {
            int start = Math.max(0,i - ranges[i]);
            int end = Math.min(n,i + ranges[i]);
            intervals[i] = new int[]{start,end};
        }
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        // dp[i]表示覆盖区间[0,i]所需的最少区间数目
        int[] dp = new int[n + 1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0] = 0;
        for (int[] interval : intervals) {
            int start = interval[0], end = interval[1];
            if (dp[start] == Integer.MAX_VALUE){
                return -1;
            }
            for (int j = start; j <= end; j++) {
                dp[j] = Math.min(dp[j],dp[start] + 1);
            }
        }
        return dp[n];
    }

    public int minTaps1(int n, int[] ranges) {
        int[] last = new int[n + 1];//last[i]表示，左端点为i,右端点最大的区间
        for (int i = 0; i <= n; i++) {
            int l = Math.max(0,i - ranges[i]);
            int r = i + ranges[i];
            last[l] = Math.max(last[l], r);
        }
        int ans = 0;
        int max = 0,pre = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max,last[i]);
            if (max <= i){
                return -1;
            }
            if (pre == i){
                ans++;
                pre = max;
            }
        }
        return ans;
    }
}
