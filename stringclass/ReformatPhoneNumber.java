package stringclass;

public class ReformatPhoneNumber {
	// leetcode 1694 simple 2022/10/1
	// ��ģ�⼴��
    public String reformatNumber(String number) {
    	String s = number.replace(" ", "").replace("-", "");
    	int n = s.length();
    	StringBuilder sb = new StringBuilder();
    	for(int i = 0;i < n;i += 3) {
    		if (sb.length() != 0) {
				sb.append("-");
			}
    		if (i + 5 > n) {// ���ʣ�²���5���ַ��������⴦��
				if (i + 3 >= n) {// ���ʣ���ַ����ڵ��� 3������ֱ�����
					sb.append(s.substring(i));
					break;
				}else { // ���ʣ���ַ���4������ƽ�ֳ��������
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
