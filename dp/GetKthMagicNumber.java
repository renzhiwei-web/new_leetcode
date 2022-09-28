package dp;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class GetKthMagicNumber {
	// leetcode 2773 medium 2022/9/28
	// 本题的大意是从1开始，全是以前一个数的3，5，7的倍数组成的数组中找到第k个数
	// 利用优先队列（默认是最小堆），将当前遍历数取出，并将其3，5，7的倍数压入堆中，直到能够取出k个数为止
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
	
	// 利用动态规划
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
