package array;

import java.util.Arrays;

public class MaximumLengthOfPairChain {
	// leetcode 646 medium 2022/9/3
	// ʹ�ö�̬�滮��Ҳ�Ǳ�������
    public int findLongestChain1(int[][] pairs) {
    	int n = pairs.length;
    	// �����Խ��������Ե�һ����Ϊ��׼
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
    
    // ʹ��̰���㷨��Ҫ��ѡ��������ĵ�һ������ʱ�����ŵ�ѡ������ѡ�ڶ���������С�ģ������ܸ���ѡ�������������¸���Ŀռ�
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
