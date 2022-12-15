package stringclass;

public class SumOfDigitsOfStringAfterConvert {
    // leetcode 1945 simple 2022/12/15
    // 简单模拟
    public int getLucky(String s, int k) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i) - 'a' + 1);
        }
        return function(sb.toString(),k);
    }

    private int function(String sb, int k) {
        if (k == 0){
            return Integer.parseInt(sb);
        }
        int ans = 0;
        for (int i = 0; i < sb.length(); i++) {
            ans += sb.charAt(i) - '0';
        }
        return function(String.valueOf(ans),k - 1);
    }
}
