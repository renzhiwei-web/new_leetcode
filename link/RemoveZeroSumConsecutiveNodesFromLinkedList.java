package link;

import java.util.HashMap;
import java.util.Map;

public class RemoveZeroSumConsecutiveNodesFromLinkedList {
    // leetcode 1171 medium 2023/6/11
    // 利用前缀和来判断是否需要跳过子序列为0
    public ListNode removeZeroSumSublists(ListNode head) {
        ListNode dummy = new ListNode(0,head);
        Map<Integer,ListNode> map = new HashMap<>();
        int prefix = 0;
        for (ListNode node = dummy;node != null;node = node.next){
            prefix += node.val;
            map.put(prefix,node);
        }
        prefix = 0;
        for (ListNode node = dummy;node != null;node = node.next){
            prefix += node.val;
            node.next = map.get(prefix).next;
        }
        return dummy.next;
    }
}
