package stringclass;

public class DefangingAnIpAddress {
	// leetcode 1108 simple 2022/6/21
	// ʹ�ÿ⺯���汾
    public String defangIPaddr1(String address) {
    	return address.replace(".", "[.]");
    }
    
    // ��ʹ�ÿ⺯���������
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
