package link;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class NextGreaterNodeInLinkedList {
    // leetcode 1019 medium 2023/4/10
    // 使用单调栈的思想
    public int[] nextLargerNodes(ListNode head) {
        ListNode p = head;
        int len = 0;
        while (p != null) {
            len++;
            p = p.next;
        }
        int[] ans = new int[len];
        Stack<int[]> stack = new Stack<>();
        p = head;
        stack.push(new int[]{0,p.val});
        int id = 1;
        p = p.next;
        while (p != null) {
            while (!stack.isEmpty() && p.val > stack.peek()[1]){
                int[] temp = stack.pop();
                ans[temp[0]] = p.val;
            }
            stack.push(new int[]{id,p.val});
            id++;
            p = p.next;
        }
        return ans;
    }
}
