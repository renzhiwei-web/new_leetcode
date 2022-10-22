package dp;

import java.util.Arrays;

public class MaximumProfitInJobScheduling {
    // leetcode 1235 hard 2022/10/22
    // 先将startTime，endTime，profit组合，然后按照endTime进行排序
    // 使用动态规划，转移方程如下，由于需要查找，为了提高效率，使用二分查找
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int len = startTime.length;
        int[][] jobs = new int[len][];
        for (int i = 0; i < len; i++) {
            jobs[i] = new int[]{startTime[i],endTime[i],profit[i]};
        }
        // 按照结束时间进行排序
        Arrays.sort(jobs,(a,b) -> a[1] - b[1]);
        // dp是动态规划数组，表示前i份工作的最大报酬
        int[] dp = new int[len + 1];
        for (int i = 0; i < len; i++) {
            // j是最大的满足endTime[j] <= startTime[i]的j，那么最大报酬等于前j个最大工作报酬加上profit[i]
            int j = search(jobs,i,jobs[i][0]);
            dp[i + 1] = Math.max(dp[i],dp[j + 1] + jobs[i][2]);
        }
        return dp[len];
    }

    // 返回endTime <= upper 的最大下标
    private int search(int[][] jobs, int right, int upper) {
        int left = -1;
        while (left + 1 < right){
            int mid = (left + right) / 2;
            if (jobs[mid][1] <= upper){
                left = mid;
            }else {
                right = mid;
            }
        }
        return left;
    }
}
