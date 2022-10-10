package dp;

public class MinimumSwapsToMakeSequencesIncreasing {
    public int minSwap(int[] nums1, int[] nums2) {
    	// f[i][0/1]表示让nums1和nums[2]的前i个书严格递增所需操作的最小次数
    	int n = nums1.length;
    	int[][] dp = new int[n][2];
    	dp[0][1] = 1;
    	for (int i = 1;i < n;i++) {
    		dp[i][0] = n; // 答案不会超过n，所以初始化成n，便于求最小数
    		dp[i][1] = n;
    		// 当满足a1<a2 且 b1<b2时，可以交换也可以不交换
    		if (nums1[i - 1] < nums1[i] && nums2[i - 1] < nums2[i]) {
				dp[i][0] = dp[i - 1][0];
				dp[i][1] = dp[i - 1][1] + 1;
			}
    		// 如果b1 < a2 且 a1 < b2，可以交换其中一对
    		if (nums2[i - 1] < nums1[i] && nums1[i - 1] < nums2[i]) {
				dp[i][0] = Math.min(dp[i][0], dp[i - 1][1]);
				dp[i][1] = Math.min(dp[i][1], dp[i - 1][0] + 1);
			}
    	}
    	return Math.min(dp[n - 1][0], dp[n - 1][1]);
    }
}
