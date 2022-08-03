package stringclass;

import java.util.Arrays;

public class OrderlyQueue {
	// leetcode 899 hard 2022/8/3
	// �Ծ���ת�䣬��k���з��������
    public String orderlyQueue(String s, int k) {
    	if (k == 1) {
			StringBuilder sb = new StringBuilder(s);
			for(int i = 1;i < s.length();i++) {
				sb.append(sb.charAt(0)).deleteCharAt(0);
				if (sb.toString().compareTo(s) < 0) {
					s = sb.toString();
				}
			}
			return s;
		}else {
			// ֱ������
			char[] chars = s.toCharArray();
			Arrays.sort(chars);
			return new String(chars);
		}
    	
    }
}
