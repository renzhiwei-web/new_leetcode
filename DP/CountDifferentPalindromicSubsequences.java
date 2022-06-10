package dp;

public class CountDifferentPalindromicSubsequences {
	// leetcode 730 hard 2022/6/10
	// 回文问题，本题的难点是要求的是子序列问题，所以不可以使用滑动窗口思想
	// 根据题解的思想，使用动态规划思想
	// 动态规划的难点是如何思考动态转移方程
	// 可以将长字符串看作短字符串左右加上两个字符，这样就可以进行分情况讨论
	// 详细的讨论看以下网页
	// https://leetcode.cn/problems/count-different-palindromic-subsequences/solution/tong-ji-butong-by-jiang-hui-4-q5xf/
    public int countPalindromicSubsequences(String s) {
    	int mod = 1000000007;
    	int n = s.length();
    	int[][] dp = new int[n][n];
    	// 一个单字符就是一个回文子序列
    	for(int i = 0;i < n;i++) {
    		dp[i][i] = 1;
    	}
    	// 从长度为2的子串开始计算
    	for(int len = 2;len <= n;len++) {
    		// 挨个计算长度为len的子串的回文子序列个数
    		for(int i = 0;i + len <= n;i++) {
    			int j = i + len - 1;
    			if (s.charAt(i) == s.charAt(j)) {
					int left = i + 1;
					int right = j - 1;
					// 找到第一个和s[i]相同的字符
					while(left <= right && s.charAt(left) != s.charAt(i)) {
						left++;
					}
					// 找到第一个和s[j]相同的字符
					while(left <= right && s.charAt(right) != s.charAt(j)) {
						right--;
					}
					if (left > right) {
						// 原字符串与新加的字符没有相同的字符
						dp[i][j] = 2 * dp[i + 1][j - 1] + 2;
					}else if (left == right) {
						// 出现一个重复字符
						dp[i][j] = 2 * dp[i + 1][j - 1] + 1;
					}else {
						// 出现两个以及两个以上的字符
						dp[i][j] = 2 * dp[i + 1][j - 1] - dp[left + 1][right - 1];
					}
				}else {
					// 首尾两个字符不相同
					dp[i][j] = dp[i][j - 1] + dp[i + 1][j] - dp[i + 1][j - 1];
				}
    			// 处理超范围的结果
    			dp[i][j] = (dp[i][j] >= 0) ? dp[i][j] % mod : dp[i][j] + mod;
    		}
    	}
    	return dp[0][n - 1];
    }
}
