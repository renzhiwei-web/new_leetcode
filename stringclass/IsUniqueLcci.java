package stringclass;

public class IsUniqueLcci {
    // leetcode 2768 simple 2022/12/12
    // 判断字符串中的字符是否唯一，很容易想到利用额外空间进行解题
    // 如何不利用额外空间进行解题，很容易联想到数组中数字是否唯一的问题
    // 利用异或运算进行解题
    public boolean isUnique(String astr) {
        long bits = 0;
        int size = astr.length();
        for (int i = 0; i < size; i++) {
            int move = astr.charAt(i) - 'A';
            if ((bits & (1L << move)) != 0) {
                //有重复的，直接返回false
                return false;
            } else {
                //标记当前位置有这个字符
                bits |= (1L << move);
            }
        }
        return true;
    }
}
