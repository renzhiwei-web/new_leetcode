package array;

import java.util.Arrays;

public class PartitionToKEqualSumSubsets {
	int[] nums;
	int n, t, k;
	// leetcode 698 medium 2022/9/20
	// ʹ�û��ݷ����н���
	public boolean canPartitionKSubsets(int[] _nums, int _k) {
		nums = _nums;
		k = _k;
		int tot = 0;
		for (int x : nums) {
			tot += x;
		}
		if (tot % k != 0) {
			return false;
		} // �����Լ�֦
		Arrays.sort(nums);
		n = nums.length;
		t = tot / k;
		return dfs(n - 1, 0, 0, new boolean[n]); // ���ݷ�
	}

	private boolean dfs(int idx, int cur, int cnt, boolean[] vis) {
		if (cnt == k) {
			return true;
		}
		if (cur == t) {
			return dfs(n - 1, 0, cnt + 1, vis);
		} // ���¿�ʼ������һ�ֵ��ж�
		for (int i = idx; i >= 0; i--) { // ˳���Լ�֦
			if (vis[i] || cur + nums[i] > t) {
				continue;
			} // �����ǰ���������ѱ�������������ֵ֮�Ͳ�����Ҫ�󣬽��м�֦
			vis[i] = true; // �����ʹ�õ�ǰ��
			if (dfs(i - 1, cur + nums[i], cnt, vis)) {
				return true;
			}
			vis[i] = false;// ���л���
			if (cur == 0) {
				return false;
			} // �����Լ�֦
		}
		return false;
	}
}
