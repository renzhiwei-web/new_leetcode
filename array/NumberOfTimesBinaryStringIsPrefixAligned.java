package array;

public class NumberOfTimesBinaryStringIsPrefixAligned {
    // leetcode 1375 medium 2023/6/14
    // 在第 i 次翻转之后，我们希望 [1, i] 内的所有位都是 1，这等价于「前 i 次翻转中下标的最大值等于 i」
    public int numTimesAllBlue(int[] flips) {
        int n = flips.length;
        int ans = 0, right = 0;
        for (int i = 0; i < n; ++i) {
            right = Math.max(right, flips[i]);
            if (right == i + 1) {
                ++ans;
            }
        }
        return ans;
    }
}
