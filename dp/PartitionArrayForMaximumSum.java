package dp;

import java.util.Arrays;


public class PartitionArrayForMaximumSum {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int len = arr.length;
        // dp[i]，表示前i - 1个数的答案
        int[] dp = new int[len + 1];
        dp[0] = 0;
        for (int i = 1; i <= len; i++) {
            // 遍历当前的数字
            for (int j = 1; j <= k; j++) {
                // 开始向前扩展当前数
                if (i - j >= 0) {
                    dp[i] = Math.max(dp[i],dp[i - j] + arrMax(arr,i - j,i - 1) * j);
                }else {
                    // 越界直接停止遍历
                    break;
                }
            }
        }
        return dp[len];
    }

    /**
     * 找到arr数组中从i到j的最大数字
     * @param arr
     * @param i
     * @param j
     * @return
     */
    private int arrMax(int[] arr, int i, int j) {
        int ans = Integer.MIN_VALUE;
        for (int k = i; k <= j; k++) {
            ans = Math.max(ans,arr[k]);
        }
        return ans;
    }

    public int maxSumAfterPartitioning1(int[] arr, int k) {
        int n = arr.length;
        int[] f = new int[n + 1];
        for (int i = 1; i <= n; ++i) {
            int mx = 0;
            for (int j = i; j > Math.max(0, i - k); --j) {
                mx = Math.max(mx, arr[j - 1]);
                f[i] = Math.max(f[i], f[j - 1] + mx * (i - j + 1));
            }
        }
        return f[n];
    }
}
