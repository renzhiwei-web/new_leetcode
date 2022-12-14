package stringclass;

public class StringToUrlLcci {
    // leetcode 2770 simple 2022/12/13
    // 简单模拟
    public String replaceSpaces(String S, int length) {
        char[] cs = S.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            if (cs[i] == ' '){
                sb.append("%20");
            }else {
                sb.append(cs[i]);
            }
        }
        return sb.toString();
    }
}
