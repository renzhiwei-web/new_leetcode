package array;

import java.util.Stack;

public class MinimumAddToMakeParenthesesValid {
	// leetcode 921 medium 2022/10/4
	// 首先想到利用栈，进行模拟算法
    public int minAddToMakeValid1(String s) {
    	Stack<Character> stack = new Stack<>();
    	char[] cs = s.toCharArray();
    	int ans = 0;
    	for(int i = 0;i < cs.length;i++) {
    		if (cs[i] == '(') {
				stack.push(cs[i]);
			}else {
				if (!stack.isEmpty()) {
					stack.pop();
				}else {
					ans++;
				}
			}
    	}
    	while(!stack.isEmpty()) {
    		stack.pop();
    		ans++;
    	}
    	return ans;
    }
    
    // 虚拟算法
    public int minAddToMakeValid(String s) {
    	int ans = 0;
    	int leftCount = 0;
    	int length = s.length();
    	for(int i = 0;i < length;i++) {
    		char c = s.charAt(i);
    		if (c == '(') {
				leftCount++;
			}else {
				if (leftCount > 0) {
					leftCount--;
				}else {
					ans++;
				}
			}
    	}
    	ans += leftCount;
    	return ans;
    }
}
