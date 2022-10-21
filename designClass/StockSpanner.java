package designClass;

import java.util.Stack;

public class StockSpanner {
    // leetcode 901 medium 2022/10/21
    // 使用单调栈的思想，但是由于最终答案要保存那些被pop出的元素，所以将栈中元素设为数组，来保存每个元素进栈的顺序
    Stack<int[]> stack;
    int idx;
    public StockSpanner() {
        stack = new Stack<>();
        stack.push(new int[]{-1,Integer.MAX_VALUE});
        idx = -1;
    }

    public int next(int price) {
        idx++;
        while(price >= stack.peek()[1]){
            stack.pop();
        }
        int ans = idx - stack.peek()[0];
        stack.push(new int[] {idx,price});
        return ans;
    }
}
