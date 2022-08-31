package array;

import java.util.ArrayDeque;
import java.util.Deque;

public class ValidateStackSequences {
	// leetcode 946 medium 2022/8/31
	// 使用栈模拟
    public boolean validateStackSequences(int[] pushed, int[] popped) {
    	Deque<Integer> stack = new ArrayDeque<>();
    	int n = pushed.length;
    	for(int i = 0,j = 0;i < n;i++) {
    		// 根据push 数组，将元素逐个压入栈中
    		stack.push(pushed[i]);
    		// 若 栈中存在元素 且 栈顶的元素与当前遍历的pop数组元素相同，则说明当前元素出栈，则，模拟栈中的栈顶元素出栈
    		while(!stack.isEmpty() && stack.peek() == popped[j]) {
    			stack.pop();
    			j++;
    		}
    	}
    	return stack.isEmpty();
    }
}
