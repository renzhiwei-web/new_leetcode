package stringclass;

import java.util.HashSet;
import java.util.Set;
// leetcode 1016 medium 2023/5/11
public class BinaryStringWithSubstringsRepresenting1ToN {
    // 暴力求解法:查看每个范围内的数字的二进制字符串是否在s中
    public boolean queryString(String s, int n) {
        for (int i = 1; i <= n; i++) {
            if (!s.contains(Integer.toBinaryString(i))){
                return false;
            }
        }
        return true;
    }

    // 暴力求解法，将s的子串都转成二进制数，如果数字在范围中，则保存在哈希表中，
    // 最终若哈希表大小为n，则成功
    public boolean queryString1(String s, int n) {
        Set<Integer> set = new HashSet<>();
        char[] cs = s.toCharArray();
        for (int i = 0,m = cs.length; i < m; i++) {
            int x = cs[i] - '0';
            // 二进制数从 1 开始
            if (x == 0){
                continue;
            }
            for (int j = i + 1; x <= n; j++) {
                set.add(x);
                if (j == m){
                    break;
                }
                x = (x << 1) | (cs[j] - '0');
            }
        }
        return set.size() == n;
    }

    public boolean queryString2(String s, int n) {
        if (n == 1){
            return s.contains("1");
        }
        // n 的二进制长度减一
        int k = 31 - Integer.numberOfLeadingZeros(n);
        if (s.length() < Math.max(n - (1 << k) + k + 1,(1 << (k - 1)) + k - 1)){
            return false;
        }

        return check(s,k,n / 2 + 1,(1 << k) - 1) && check(s,k + 1,1 << k,n);
    }

    // 对于长为 k 的在 [lower, upper] 内的二进制数，判断这些数 s 是否都有
    private boolean check(String s, int k, int lower, int upper) {
        if (lower > upper) {
            return true;
        }
        Set<Integer> set = new HashSet<>();
        int mask = (1 << (k - 1)) - 1;
        int x = Integer.parseInt(s.substring(0,k - 1),2);
        for (int i = k - 1,m = s.length();i < m;i++){
            // & mask 可以去掉最高比特位，从而实现滑窗的「出」
            // << 1 | (s.charAt(i) - '0') 即为滑窗的「入」
            x = ((x & mask) << 1) | (s.charAt(i) - '0');
            if (lower <= x && x <= upper){
                set.add(x);
            }
        }
        return set.size() == upper - lower + 1;
    }
}
