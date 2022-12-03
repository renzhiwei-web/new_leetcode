package stringclass;

public class SecondLargestDigitInAString {
    // leetcode 1796 simple 2022/12/3
    // 简单模拟即可
    public int secondHighest(String s) {
        char[] cs = s.toCharArray();
        int max = -1,smax = -1;
        for (int i = 0; i < cs.length; i++) {
            if (!Character.isDigit(cs[i])) {
                continue;
            }
            int num = cs[i] - '0';
            if (num > max) {
                smax = max;
                max = cs[i] - '0';
            } else if (num != max && num > smax) {
                smax = num;
            }
        }
        return smax;
    }
}
