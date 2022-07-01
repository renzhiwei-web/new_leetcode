package divideandconquer;

import java.util.ArrayList;
import java.util.List;

public class DifferentWaysToAddParentheses {
	// leetcode 241 medium 2022/7/1
	// 首先题目比较复杂，但是对于运算表达式，可以将整个运算表达式分成x op y
	// 每个x 又可以变成x op y，所以采用分治算法
    public List<Integer> diffWaysToCompute(String expression) {
    	// 如果只有数字，直接返回
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
    	// 采用分治算法
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
