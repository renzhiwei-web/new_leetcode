package array;

import java.util.Arrays;

public class MaximumEqualFrequency {
	// leetcode 1224 hard 2022/8/18
	// ʹ�ù�ϣ�������������ؼ�����sum������趨
	// cnt[i] = x ����Ϊ��ֵ i �ĳ��ִ���Ϊ x ��
	// sum[i] = x ����Ϊ���ִ���Ϊ i ����ֵ���� x ��
	static int[] cnt = new int[100010], sum = new int[100010];

	public int maxEqualFreq(int[] nums) {
		Arrays.fill(cnt, 0);
		Arrays.fill(sum, 0);
		// max ������¼�����ִ���
		int n = nums.length, max = 0, ans = 0;
		for (int i = 0; i < n; i++) {
			int t = nums[i];
			int cur = ++cnt[t]; // curΪ��ǰ���ֳ��ֵĴ��� ����cnt����
			int len = i + 1;// len Ϊǰ׺��������
			sum[cur]++;
			sum[cur - 1]--; // ����sum����
			max = Math.max(max, cur);
			if (max == 1) {// ˵����ǰ���������� nums[i] ��ֻ������һ�Σ���ʱ����ɾ��һ��������Ҫ��
				ans = len;
			} 
			if (max * sum[max] + 1 == len) {// ˵��һ����ֵ����������һ�Σ�ɾ��������Ҫ��
				ans = len;
			} 
			if ((max - 1) * (sum[max - 1] + 1) + 1 == len) { // ˵�����δ���Ϊ max ����ֵֻ��һ����������ִ�����Ϊ max - 1������ɾ��һ�κ�����Ҫ��
				ans = len;
			}
		}
		return ans;
	}
}
