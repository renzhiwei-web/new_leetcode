package stringclass;

public class StringRotation {
	// leetcode 2691 simple 2022/9/29
	// 进行模拟，使用数学的方式进行虚拟，不需要真实的轮转字符串
    public boolean isFlipedString1(String s1, String s2) {
    	int m = s1.length(), n = s2.length();
        if (m != n) {
            return false;
        }
        if (n == 0) {
            return true;
        }
        for (int i = 0; i < n; i++) {
            boolean flag = true;
            for (int j = 0; j < n; j++) {
                if (s1.charAt((i + j) % n) != s2.charAt(j)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return true;
            }
        }
        return false;
	}
    
    public boolean isFlipedString(String s1, String s2) {
    	if (s1.length() != s2.length()) {
			return false;
		}
    	if ((s1 + s1).contains(s2)) {
			return true;
		}else {
			return false;
		}
    }
}
