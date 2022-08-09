package stringclass;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SpecialBinaryString {
	// leetcode 761 hard 2022/8/8
	// ������ڵݹ����
    public String makeLargestSpecial(String s) {
    	if (s.length() == 0) {
			return "";
		}
    	List<String> list = new ArrayList<>();
    	int count = 0,last = 0;
    	for(int i = 0,cur = 0;i < s.length();i++,cur++) {
    		if (s.charAt(i) == '1') {
				count++;
			}else {
				count--;
			}
    		// һ����Ч������ƥ�䣬ȥ�����Ž����ڲ�����
    		if (count == 0) {
				String str = '1' + makeLargestSpecial(s.substring(last + 1, cur)) + '0';
				list.add(str);
				last = cur + 1;
			}
    	}
    	// �������򣬸���ð�����򣬽����������ڵ�Ԫ�ؽ��������������ڲ��������ɴ�С����
    	list.sort(Comparator.reverseOrder());
    	// ƴ���������ַ���
    	StringBuilder sb = new StringBuilder();
    	for(String str : list) {
    		sb.append(str);
    	}
    	return sb.toString();
    }
}
