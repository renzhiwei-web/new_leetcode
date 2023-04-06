package array;

public class ConvertToBase2 {
    // leetcode 1017 medium 2023/4/6
    // 简单进行模拟即可
    public String baseNeg2(int n) {
        if (n == 0) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        int i = 1;
        while (n != 0){
            if ((n & 1) != 0) {
                sb.append(1);
                n -= i;
            }else {
                sb.append(0);
            }
            i *= -1;
            n /= 2;
        }
        return sb.reverse().toString();
    }
}
