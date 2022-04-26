package array;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class NextGreaterElementI {
	// leetcode 496 simple 2022/4/26
	//暴力法,通过使用hash法来存储每个数在nums2中的索引
    public int[] nextGreaterElement1(int[] nums1, int[] nums2) {
    	Map<Integer, Integer> hash = new HashMap<>();
    	int[] ans = new int[nums1.length];
    	for(int i = 0;i < nums2.length;i++) {
    		hash.put(nums2[i], i);
    	}
    	for(int i = 0;i < nums1.length;i++) {
    		int idx = hash.get(nums1[i]);
    		for(idx++;idx < nums2.length;idx++) {
    			if (nums2[idx] > nums1[i]) {
					ans[i] = nums2[idx];
					break;
				}
    		}
    		if (idx == nums2.length) {
				ans[i] = -1;
			}
    	}
    	return ans;
    }
    
    //使用单调栈算法
    // 通过使用单调栈，保存nums2中所有元素的下一个更大值
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
    	Map<Integer, Integer> hash = new HashMap<>();
    	Deque<Integer> stack = new ArrayDeque<>();
    	for(int i = nums2.length - 1;i >= 0;i--) {//逆序遍历
    		int num = nums2[i];
    		while(!stack.isEmpty() && num >= stack.peek()) {//若当前栈是非空且，当前数大于栈顶元素，则将栈顶元素pop
    			stack.pop();
    		}
    		//若栈中没有元素，则没有下一个更大值，若栈中还有元素，则栈顶值就是下一个更大值
    		hash.put(num, stack.isEmpty() ? -1 : stack.peek());
    		stack.push(num);
    	}
    	int[] ans = new int[nums1.length];
    	for(int i = 0;i < nums1.length;i++) {
    		ans[i] = hash.get(nums1[i]);
    	}
    	return ans;
    }
}
