package bitCompute;

public class FirstLetterToAppearTwice {
    // leetcode 2351 simple 2023/1/1
    // 使用二进制进行状态的存储
    public char repeatedCharacter(String s) {
        int mask = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if ((mask >> (ch - 'a') & 1) == 1){
                return ch;
            }
            mask |= 1 << (ch - 'a');
        }
        return 0;
    }
}
