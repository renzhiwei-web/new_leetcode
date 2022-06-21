package stringclass;

public class DefangingAnIpAddress {
	// leetcode 1108 simple 2022/6/21
	// 使用库函数版本
    public String defangIPaddr1(String address) {
    	return address.replace(".", "[.]");
    }
    
    // 不使用库函数解决问题
    public String defangIPaddr(String address) {
    	StringBuilder sb = new StringBuilder();
    	char[] addressChars = address.toCharArray();
    	for(int i = 0;i < addressChars.length;i++) {
    		if (addressChars[i] != '.') {
				sb.append(addressChars[i]);
			}else {
				sb.append("[.]");
			}
    	}
    	return sb.toString();
    }
}
