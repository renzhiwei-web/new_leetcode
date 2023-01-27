package stringclass;

import java.util.Arrays;

public class GreatestEnglishLetterInUpperAndLowerCase {
    // leetcode 2309 simple 2023/1/17
    // 简单模拟，使用位运算进行空间优化
    public String greatestLetter(String s) {
        int[] alpha = new int[26];
        char[] cs = s.toCharArray();
        Arrays.fill(alpha,1);
        for (char ch :
                cs) {
            if (ch >= 'A' && ch < 'a') {
                alpha[ch - 'A'] |= 2;
            } else if (ch >= 'a') {
                alpha[ch - 'a'] |= 4;
            }
        }
        for (int i = 25; i >= 0; i--) {
            if (alpha[i] == 7){
                char ans = (char) ('A' + i);
                return String.valueOf(ans);
            }
        }
        return "";
    }
}
