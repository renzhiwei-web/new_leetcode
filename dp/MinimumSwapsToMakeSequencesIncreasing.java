package dp;

public class MinimumSwapsToMakeSequencesIncreasing {
    public int minSwap(int[] nums1, int[] nums2) {
    	// f[i][0/1]��ʾ��nums1��nums[2]��ǰi�����ϸ���������������С����
    	int n = nums1.length;
    	int[][] dp = new int[n][2];
    	dp[0][1] = 1;
    	for (int i = 1;i < n;i++) {
    		dp[i][0] = n; // �𰸲��ᳬ��n�����Գ�ʼ����n����������С��
    		dp[i][1] = n;
    		// ������a1<a2 �� b1<b2ʱ�����Խ���Ҳ���Բ�����
    		if (nums1[i - 1] < nums1[i] && nums2[i - 1] < nums2[i]) {
				dp[i][0] = dp[i - 1][0];
				dp[i][1] = dp[i - 1][1] + 1;
			}
    		// ���b1 < a2 �� a1 < b2�����Խ�������һ��
    		if (nums2[i - 1] < nums1[i] && nums1[i - 1] < nums2[i]) {
				dp[i][0] = Math.min(dp[i][0], dp[i - 1][1]);
				dp[i][1] = Math.min(dp[i][1], dp[i - 1][0] + 1);
			}
    	}
    	return Math.min(dp[n - 1][0], dp[n - 1][1]);
    }
}
