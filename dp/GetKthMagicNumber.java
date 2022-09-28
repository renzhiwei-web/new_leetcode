package dp;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class GetKthMagicNumber {
	// leetcode 2773 medium 2022/9/28
	// ����Ĵ����Ǵ�1��ʼ��ȫ����ǰһ������3��5��7�ı�����ɵ��������ҵ���k����
	// �������ȶ��У�Ĭ������С�ѣ�������ǰ������ȡ����������3��5��7�ı���ѹ����У�ֱ���ܹ�ȡ��k����Ϊֹ
	public int getKthMagicNumber1(int k) {
		int[] factors = {3,5,7};
		Set<Long> seen = new HashSet<>();
		PriorityQueue<Long> heap = new PriorityQueue<>();
		seen.add(1L);
		heap.offer(1L);
		int magic = 0;
		for(int i = 0;i < k;i++) {
			long curr = heap.poll();
			magic = (int)curr;
			for(long factor : factors) {
				long next = curr * factor;
				if (seen.add(next)) {
					heap.offer(next);
				}
			}
		}
		return magic;
    }
	
	// ���ö�̬�滮
	public int getKthMagicNumber(int k) {
		int[] dp = new int[k + 1];
		int ps3 = 0,ps5 = 0,ps7 = 0;
		dp[0] = 1;
		for(int i = 1;i < k;i++) {
			dp[i] = Math.min(dp[ps3] * 3, Math.min(dp[ps5] * 5, dp[ps7] * 7));
			if (dp[i] == dp[ps3] * 3) {
				ps3++;
			}
			if (dp[i] == dp[ps5] * 5) {
				ps5++;
			}
			if(dp[i] == dp[ps7] * 7) {
				ps7++;
			}
		}
		return dp[k - 1];
	}
}
