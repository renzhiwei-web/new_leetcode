package stringclass;

public class StrongPasswordCheckerIi {
    // leetcode 2299 simple 2023/1/19
    // 模拟+二进制状态压缩
    public boolean strongPasswordCheckerII(String password) {
        if (password.length() < 8){
            return false;
        }
        int mask = 0;
        for (int i = 0; i < password.length(); i++) {
            char ch = password.charAt(i);
            if (i > 0 && ch == password.charAt(i - 1)){
                return false;
            }
            if (Character.isLowerCase(ch)){
                mask |= 1;
            } else if (Character.isUpperCase(ch)) {
                mask |= 2;
            } else if (Character.isDigit(ch)) {
                mask |= 4;
            }else {
                mask |= 8;
            }

        }
        return mask == 15;
    }
}
