package array;

import java.util.ArrayDeque;
import java.util.Deque;

public class FinalPricesWithASpecialDiscountInAShop {
	// leetcode 1475 simple 2022/9/1
	// 使用单调栈解题
    public int[] finalPrices(int[] prices) {
    	int len = prices.length;
    	int[] ans = new int[len];
    	Deque<Integer> stack = new ArrayDeque<>();
    	for(int i = len - 1;i >= 0;i--) {
    		while(!stack.isEmpty() && stack.peek() > prices[i]) {
    			stack.pop();
    		}
    		ans[i] = stack.isEmpty() ? prices[i] : prices[i] - stack.peek();
    		stack.push(prices[i]);
    	}
    	return ans;
    }
}
