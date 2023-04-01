package stringclass;

public class MaskingPersonalInformation {
    // leetcode 831 medium 2023/4/1
    // 简单模拟
    public String maskPII(String s) {
        int index = s.indexOf('@');
        if (index == -1) {
            return phone(s);
        }else {
            return email(s,index);
        }
    }

    private String email(String s, int index) {
        return s.substring(0, 1).toLowerCase() +// 拼接第一个字符
                "*****" +
                s.substring(index - 1, index + 1).toLowerCase() +
                s.substring(index + 1).toLowerCase();
    }

    private String phone(String s) {
        String digits = s.replaceAll("\\D+","");
        int len = digits.length();
        StringBuilder sb = new StringBuilder();
        int count = len - 10;
        if (count != 0) {
            sb.append('+');
        }
        sb.append("*".repeat(Math.max(0, count)));
        if (count != 0) {
            sb.append('-');
        }
        sb.append("***-***-");
        sb.append(digits.substring(len - 4,len));
        return sb.toString();
    }

}
