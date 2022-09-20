package array;

import java.util.Arrays;

public class PartitionToKEqualSumSubsets {
	int[] nums;
	int n, t, k;
	// leetcode 698 medium 2022/9/20
	// 使用回溯法进行解题
	public boolean canPartitionKSubsets(int[] _nums, int _k) {
		nums = _nums;
		k = _k;
		int tot = 0;
		for (int x : nums) {
			tot += x;
		}
		if (tot % k != 0) {
			return false;
		} // 可行性剪枝
		Arrays.sort(nums);
		n = nums.length;
		t = tot / k;
		return dfs(n - 1, 0, 0, new boolean[n]); // 回溯法
	}

	private boolean dfs(int idx, int cur, int cnt, boolean[] vis) {
		if (cnt == k) {
			return true;
		}
		if (cur == t) {
			return dfs(n - 1, 0, cnt + 1, vis);
		} // 重新开始进行新一轮的判断
		for (int i = idx; i >= 0; i--) { // 顺序性剪枝
			if (vis[i] || cur + nums[i] > t) {
				continue;
			} // 如果当前遍历的数已被遍历，或这数值之和不符合要求，进行剪枝
			vis[i] = true; // 标记已使用当前数
			if (dfs(i - 1, cur + nums[i], cnt, vis)) {
				return true;
			}
			vis[i] = false;// 进行回溯
			if (cur == 0) {
				return false;
			} // 可行性剪枝
		}
		return false;
	}
}
