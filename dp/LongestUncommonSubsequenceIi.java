package dp;

public class LongestUncommonSubsequenceIi {
	// leetcode 532 medium 2022/6/27
	// leetcode 1143 最长公共子序列的应用 https://mp.weixin.qq.com/s?__biz=MzU4NDE3MTEyMA==&mid=2247492097&idx=1&sn=f51f29d86df809d8ac43a40a1369b3d6
    public int findLUSlength(String[] strs) {
    	int n = strs.length,ans = -1;
    	for(int i = 0;i < n;i++) {
    		if (strs[i].length() <= ans) {// 进行剪枝，当子序列长度大于等其他字符串长度时，则不可能时特殊子序列
    			continue;
			}
    		boolean ok = true;
    		for(int j = 0;j < n && ok;j++) {
    			if (i == j) {
					continue;
				}
    			if (check(strs[i],strs[j])) {
					ok = false;
				}
    		}
    		if (ok) {
				ans = strs[i].length();
			}
    	}
    	return ans;
    }

	private boolean check(String s1, String s2) {
		int n = s1.length(),m = s2.length();
		if (m < n) {
			return false;
		}
		int[][] f = new int[n + 1][m + 1];//f[i][j]代表考虑 s1 的前 i - 1 个字符、考虑 s2 的前 j - 1 的字符，形成的最长公共子序列长度。
		for(int i = 1;i <= n;i++) {
			for(int j = 1;j <= m;j++) {
				f[i][j] = s1.charAt(i - 1) == s2.charAt(j - 1) ? f[i - 1][j - 1] + 1 : f[i - 1][j - 1];
				f[i][j] = Math.max(f[i][j], f[i - 1][j]);
				f[i][j] = Math.max(f[i][j], f[i][j - 1]);
				if (f[i][j] == n) {
					return true;
				}
			}
		}
		return false;
	}
}
