package array;

public class LexicographicallySmallestStringAfterApplyingOperations {
    // leetcode 1625 medium 2023/3/19
    // 寻找规律，由题意可得，数字最多累加10次就会回到初始状态,即会产生10种状态
    // 当b为偶数时，轮转只会对奇数位产生作用，累加和轮转即会产生n*10，若b为奇数，则都会产生作用，累加和轮转会产生n*10*10种状态，
    public String findLexSmallestString(String s, int a, int b) {
        int n = s.length();
        String ans = s;
        for (int i = 0; i < n; i++) {
            s = s.substring(b) + s.substring(0,b);
            char[] cs = s.toCharArray();
            for (int j = 0; j < 10; j++) { // 最多进行10次累加操作就会回到初始状态
                for (int k = 1; k < n; k += 2) {
                    cs[k] = (char) (((cs[k] - '0' + a) % 10) + '0');
                }
                if ((b & 1) == 1) { // 如果b为奇数，则也会对偶数位产生影响
                    for (int p = 0; p < 10; p++) {
                        for (int k = 0; k < n; k += 2) {
                            cs[k] = (char) (((cs[k] - '0' + a) % 10) + '0');
                        }
                        s = String.valueOf(cs);
                        if (ans.compareTo(s) > 0) {
                            ans = s;
                        }
                    }
                } else {
                    s = String.valueOf(cs);
                    if (ans.compareTo(s) > 0) {
                        ans = s;
                    }
                }

            }
        }
        return ans;
    }
}
