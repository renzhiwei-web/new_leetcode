package dp;

public class CountSubstringsThatDifferByOneCharacter {
    // leetcode 1638 medium 2023/3/27
    // 首先使用暴力法
    public int countSubstrings(String s, String t) {
        int m = s.length(),n = t.length();
        int ans  = 0;
        // 遍历两个字符串
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int diff = 0;
                // 开始进行子串的遍历
                for (int k = 0; i + k < m && j + k < n; k++) {
                    diff += s.charAt(i + k) == t.charAt(j + k) ? 0 : 1;
                    // 如果diff 不是等于 1，则不满足条件，直接退出循环
                    if (diff > 1) {
                        break;
                    // 如果diff 等于 1，则一直进行遍历
                    } else if (diff == 1) {
                        ans++;
                    }
                }
            }
        }
        return ans;
    }
    // 预处理+动态规划算法
    // 枚举 ss 与 tt 中不相等的字符对 (s[i],t[j])，并计算以 (s[i],t[j]) 构造的符合题意的子串数目即可。
    public int countSubstrings1(String s, String t) {
        int m = s.length(),n = t.length();
        // 设以字符 s[i] 与字符 t[j] 为起点且左侧连续相等的最大长度为 dpl[i][j]
        int[][] dpl = new int[m + 1][n + 1];
        // 以字符 s[i] 与字符 t[j] 为终点且右侧连续相等的最大长度为 dpr[i][j]
        int[][] dpr = new int[m + 1][n + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dpl[i + 1][j + 1] = s.charAt(i) == t.charAt(j) ? (dpl[i][j] + 1) : 0;
            }
        }
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                dpr[i][j] = s.charAt(i) == t.charAt(j) ? (dpr[i + 1][j + 1] + 1) : 0;
            }
        }
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (s.charAt(i) != t.charAt(j)) {
                    ans += (dpl[i][j] + 1) * (dpr[i + 1][j + 1] + 1);
                }
            }
        }
        return ans;
    }
}
