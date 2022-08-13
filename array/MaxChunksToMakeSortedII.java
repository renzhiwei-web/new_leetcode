package array;

import java.util.ArrayDeque;
import java.util.Deque;

public class MaxChunksToMakeSortedII {
	// leetcode 768 hard 2022/8/13
	// �����Ѿ��ֺõĿ�ɵã��ұߵĿ���������־����ڻ������ߵĿ����������
    public int maxChunksToSorted(int[] arr) {
    	Deque<Integer> stack = new ArrayDeque<>();
    	for(int num : arr) {
    		// ջ��ά�����ֵ
    		if (stack.isEmpty() || num >= stack.peek()) {
				stack.push(num);
			}else {
				// �����ǰֵС��ջ��ֵ������ջ��ֵ���ҽ�ջ������С�ڵ��ڵ�ǰֵ������ջ
				// ��ζ�ţ�Ԫ��������Щ��Ҫ������ͬһ���������
				int mx = stack.pop();
				while(!stack.isEmpty() && stack.peek() > num) {
					stack.pop();
				}
				stack.push(mx);
			}
    	}
    	return stack.size();
    }
}
