package dp;

public class MinimumDeletionsToMakeStringBalanced {
    // leetcode 1653 medium 前后缀解题，
    // 由题意可得，必然存在一条分割线，将a与b分隔开，在前缀中必然是删除a，在后缀中必然是删除b
    public int minimumDeletions(String s) {
        char[] cs = s.toCharArray();
        int countA = 0;
        for (var ch : cs) {
            // 统计 ‘a’ 的个数
            if (ch == 'a'){
                countA++;
            }
        }
        int ans = countA;
        for (char ch : cs) {
            // 如果是a，则减少删除次数
            if (ch == 'a') {
                countA--;
            }else {
                // 如果是b，则增加删除次数
                countA++;
            }
            ans = Math.min(countA,ans);
        }
        return ans;
    }

    // 动态规划，尝试分解问题，若字符串中只有一个b，则无需删除
    // 若字符串中最后一个是a，则进行分类讨论
    // 若删除a，则前i个字符最小删除次数+1、若保留a，则删除前i个字符中所有的b
    public int minimumDeletions1(String s) {
        int f = 0,cntB = 0;
        for (char ch : s.toCharArray()) {
            if (ch == 'b') {
                cntB++;
            }else {
                f = Math.min(f + 1,cntB);
            }
        }
        return f;
    }
}
