package stringclass;

public class ReformatPhoneNumber {
	// leetcode 1694 simple 2022/10/1
	// 简单模拟即可
    public String reformatNumber(String number) {
    	String s = number.replace(" ", "").replace("-", "");
    	int n = s.length();
    	StringBuilder sb = new StringBuilder();
    	for(int i = 0;i < n;i += 3) {
    		if (sb.length() != 0) {
				sb.append("-");
			}
    		if (i + 5 > n) {// 如果剩下不到5个字符，则特殊处理
				if (i + 3 >= n) {// 如果剩下字符少于等于 3个，则直接添加
					sb.append(s.substring(i));
					break;
				}else { // 如果剩下字符是4个，则，平分成两段添加
					sb.append(s.substring(i, i + 2)).append("-").append(s.substring(i + 2));
					break;
				}
			}else {
				sb.append(s.substring(i, i + 3));
			}
    	}
    	return sb.toString();
    	
    	
    }
}
