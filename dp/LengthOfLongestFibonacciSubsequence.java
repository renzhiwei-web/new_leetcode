package dp;

import java.util.HashMap;
import java.util.Map;

public class LengthOfLongestFibonacciSubsequence {
	// leetcode 873 medium 2022/7/9
	// 쳲������������У���С��3��������ɣ��������������ȷ�����򣬲���ȷ������쳲���������
    public int lenLongestFibSubseq(int[] arr) {
    	int n = arr.length;
    	if (n == 0) {
			return 0;
		}
    	Map<Integer, Integer> map = new HashMap<>();
    	for(int i = 0;i < n;i++) {
    		map.put(arr[i], i);
    	}
    	// �����ά���� dp ��ʾ��ÿ���±�Ե�Ԫ����Ϊ����������ֵ�쳲����������е���󳤶�
    	// dp[j][i]��ʾ��arr[i],arr[j]��Ϊ����������ֵ�쳲����������е���󳤶�
    	int[][] dp = new int[n][n];
    	int ans = 0;
    	for(int i = 0;i < n;i++) {
    		// ��֦����arr[j] * 2 <= arr[i],�򲻴���arr[k],ʹ��arr[k] + arr[j] = arr[i]
    		for(int j = i - 1;j >= 0 && arr[j] * 2 > arr[i];j--) {
    			// �ж��Ƿ����arr[k],����쳲���������
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
