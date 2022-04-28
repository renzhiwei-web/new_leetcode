package bitCompute;

public class Base7 {
	// leetcode 504 simple 2022/4/28
	// 使用短除法简单模拟即可
    public String convertToBase7(int num) {
    	StringBuilder sb = new StringBuilder();
    	boolean lessZero = false;
    	if (num < 0) {
			num = -num;
			lessZero = true;
		}
    	if (num == 0) {
			return "0";
		}
    	while(num != 0) {
    		int u = num % 7;
    		num /= 7;
    		sb.append(u);
    	}
    	if (lessZero) {
    		return sb.reverse().insert(0, "-").toString();
		}
    	return sb.reverse().toString();
    }
}
