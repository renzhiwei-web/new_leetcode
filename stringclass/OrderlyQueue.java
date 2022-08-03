package stringclass;

import java.util.Arrays;

public class OrderlyQueue {
	// leetcode 899 hard 2022/8/3
	// 脑经急转弯，对k进行分情况讨论
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
			// 直接排序
			char[] chars = s.toCharArray();
			Arrays.sort(chars);
			return new String(chars);
		}
    	
    }
}
