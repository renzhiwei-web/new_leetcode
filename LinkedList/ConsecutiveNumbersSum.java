package array;

public class ConsecutiveNumbersSum {
	// leetcode 829 hard 2022/6/3
	// 由于是连续整数求和，可以利用求和公式进行枚举
	// 等差数列求和公式 n = (a + (a + k - 1)) * k / 2 (k是连续数字的个数，a是起始数)
	// 因为a>= 1，即2n > k^2;找到了k的上界
    public int consecutiveNumbersSum(int n) {
    	int t = 2 * n,ans = 0;
    	for(int k = 1;k * k < t;k++) {
    		// 利用公式可得，t%k==0且a为正整数时才有解
    		if (t % k == 0 && (t / k + 1 - k) % 2 == 0) {
				ans++;
			}
    	}
    	return ans;
    }
}
