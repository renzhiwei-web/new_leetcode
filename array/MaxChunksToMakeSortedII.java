package array;

import java.util.ArrayDeque;
import java.util.Deque;

public class MaxChunksToMakeSortedII {
	// leetcode 768 hard 2022/8/13
	// 对于已经分好的块可得，右边的块的所有数字均大于或等于左边的块的所有数字
    public int maxChunksToSorted(int[] arr) {
    	Deque<Integer> stack = new ArrayDeque<>();
    	for(int num : arr) {
    		// 栈顶维持最大值
    		if (stack.isEmpty() || num >= stack.peek()) {
				stack.push(num);
			}else {
				// 如果当前值小于栈顶值，则保留栈顶值，且将栈中所有小于等于当前值的数出栈
				// 意味着，元素组中这些数要分配在同一个排序块中
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
