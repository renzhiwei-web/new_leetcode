package stringclass;

import java.util.Arrays;

public class SmallestStringWithAGivenNumericValue {
    // leetcode 1663 medium 2023/1/26
    // 由题意可得使用贪心算法
    public String getSmallestString(int n, int k) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int d = (n - 1 - i) * 26;
            if (k - 1 <=  d){
                sb.append('a');
                k--;
            }else {
                int t = k - d - 1;
                char ch = t > 0 ?(char) ('a' + t) : (char) ('z' + t);
                sb.append(ch);
                k -= (t + 1);
            }
        }
        return sb.toString();
    }

    public String getSmallestString1(int n, int k) {
        char[] ans = new char[n];
        Arrays.fill(ans, 'a');
        int i = n - 1, d = k - n;
        for (; d > 25; d -= 25) {
            ans[i--] = 'z';
        }
        ans[i] = (char) ('a' + d);
        return String.valueOf(ans);
    }
}
