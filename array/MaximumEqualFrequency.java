package array;

import java.util.Arrays;

public class MaximumEqualFrequency {
	// leetcode 1224 hard 2022/8/18
	// 使用哈希表与计数法，最关键的是sum数组的设定
	// cnt[i] = x 含义为数值 i 的出现次数为 x 次
	// sum[i] = x 含义为出现次数为 i 的数值共有 x 个
	static int[] cnt = new int[100010], sum = new int[100010];

	public int maxEqualFreq(int[] nums) {
		Arrays.fill(cnt, 0);
		Arrays.fill(sum, 0);
		// max 用来记录最大出现次数
		int n = nums.length, max = 0, ans = 0;
		for (int i = 0; i < n; i++) {
			int t = nums[i];
			int cur = ++cnt[t]; // cur为当前数字出现的次数 更新cnt数组
			int len = i + 1;// len 为前缀所含数量
			sum[cur]++;
			sum[cur - 1]--; // 更新sum数组
			max = Math.max(max, cur);
			if (max == 1) {// 说明当前处理到的所有 nums[i] 均只出现了一次，此时任意删除一个均满足要求；
				ans = len;
			} 
			if (max * sum[max] + 1 == len) {// 说明一个数值单独出现了一次，删除后即满足要求
				ans = len;
			} 
			if ((max - 1) * (sum[max - 1] + 1) + 1 == len) { // 说明数次次数为 max 的数值只有一个，其余出现次数均为 max - 1，对其删除一次后即满足要求。
				ans = len;
			}
		}
		return ans;
	}
}
