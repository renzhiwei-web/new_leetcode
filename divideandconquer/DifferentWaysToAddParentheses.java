package divideandconquer;

import java.util.ArrayList;
import java.util.List;

public class DifferentWaysToAddParentheses {
	// leetcode 241 medium 2022/7/1
	// ������Ŀ�Ƚϸ��ӣ����Ƕ���������ʽ�����Խ�����������ʽ�ֳ�x op y
	// ÿ��x �ֿ��Ա��x op y�����Բ��÷����㷨
    public List<Integer> diffWaysToCompute(String expression) {
    	// ���ֻ�����֣�ֱ�ӷ���
    	List<Integer> ans = new ArrayList<>();
    	int len = expression.length();
    	int start = 0;
    	for(start = 0;start < len;start++) {
    		if (Character.isDigit(expression.charAt(start))) {
				continue;
			}else {
				break;
			}
    	}
    	if (start == len) {
			ans.add(Integer.parseInt(expression));
		}
    	// ���÷����㷨
    	for(int i = start;i < len;i++) {
    		if (Character.isDigit(expression.charAt(i))) {
				continue;
			}
    		char op = expression.charAt(i);
    		List<Integer> left = diffWaysToCompute(expression.substring(0, i));
    		List<Integer> right = diffWaysToCompute(expression.substring(i + 1,len));
    		for(int j : left) {
    			for(int k : right) {
    				if (op == '+') {
						ans.add(j + k);
					}else if(op == '-'){
						ans.add(j - k);
					}else if (op == '*') {
						ans.add(j * k);
					}
    			}
    		}
    	}
    	return ans;
    }
}
