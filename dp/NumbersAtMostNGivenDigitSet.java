package dp;

public class NumbersAtMostNGivenDigitSet {
    // leetcode 902 hard 2022/10/18
    // 使用数位dp来实现
    public int atMostNGivenDigitSet1(String[] digits, int n) {
        String s = Integer.toString(n);
        int m = digits.length;
        // k是n的位数
        int k = s.length();
        // dp[i][0]表示由digits构成且小于n的前i位的数字的个数，dp[i][1]表示由digits构成且等于n的前i位的数字的个数
        // 由设定可知dp[i][1]不是0，就是1
        int[][] dp = new int[k+1][2];
        // dp[0][1]初始化为1
        dp[0][1] = 1;
        // 遍历n的每一位数字
        for (int i = 1; i <= k; i++) {
            // 遍历digits的每个数字看判断是否满足dp数组
            for (int j = 0; j < m; j++) {
                // 如果当前digit等于n的第i位数字，则满足dp[i][1]
                if (digits[j].charAt(0) == s.charAt(i - 1)){
                    dp[i][1] = dp[i - 1][1];
                // 若不相等，则可以判断是否小于n的第i位数字，同时更新dp[i][0]
                } else if (digits[j].charAt(0) < s.charAt(i - 1)) {
                    dp[i][0] += dp[i - 1][1];
                }else {
                    break;
                }
            }
            if (i > 1){
                dp[i][0] += m + dp[i - 1][0] * m;
            }
        }
        return dp[k][0] + dp[k][1];
    }

    public int atMostNGivenDigitSet(String[] digits, int n) {
        char[] nc = String.valueOf(n).toCharArray();
        int result = 0, ncl = nc.length, dl = digits.length;
        for (int i = 1; i < ncl; i++) result += Math.pow(dl, i); // 先对【非最高位】的其他位，可组装的数字进行统计
        for (int i = 0; i < ncl; i++) {
            boolean compareNext = false; // 是否需要对比下一个数字
            for (String digit : digits) {
                char dc = digit.charAt(0); // 将String转换为char
                if (dc < nc[i]) result += Math.pow(dl, ncl - i - 1);
                else {
                    if (dc == nc[i]) compareNext = true; break;
                }
            }
            if (!compareNext) return result;
        }
        return ++result; // 如果到最后1位依然满足compareNext，因为最后1位无法再向后对比了，所以最终结果+1
    }
}
