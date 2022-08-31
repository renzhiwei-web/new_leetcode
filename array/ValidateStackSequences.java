package array;

import java.util.ArrayDeque;
import java.util.Deque;

public class ValidateStackSequences {
	// leetcode 946 medium 2022/8/31
	// ʹ��ջģ��
    public boolean validateStackSequences(int[] pushed, int[] popped) {
    	Deque<Integer> stack = new ArrayDeque<>();
    	int n = pushed.length;
    	for(int i = 0,j = 0;i < n;i++) {
    		// ����push ���飬��Ԫ�����ѹ��ջ��
    		stack.push(pushed[i]);
    		// �� ջ�д���Ԫ�� �� ջ����Ԫ���뵱ǰ������pop����Ԫ����ͬ����˵����ǰԪ�س�ջ����ģ��ջ�е�ջ��Ԫ�س�ջ
    		while(!stack.isEmpty() && stack.peek() == popped[j]) {
    			stack.pop();
    			j++;
    		}
    	}
    	return stack.isEmpty();
    }
}
