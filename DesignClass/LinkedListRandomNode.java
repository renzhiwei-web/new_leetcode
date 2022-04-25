package designClass;

//import java.util.ArrayList;
//import java.util.List;
import java.util.Random;

import array.ListNode;

public class LinkedListRandomNode {
	//leetcode 382 medium 2022/4/25
	// 简单的模拟，暴力法
	/*List<Integer> list = new ArrayList<>();
	Random random = new Random(20220425);//构造函数的参数随机，作用是使生成的随机更有预见性
	*/
	// 蓄水池算法 https://leetcode-cn.com/problems/linked-list-random-node/solution/xu-shui-chi-chou-yang-suan-fa-by-jackwener/
	ListNode node;
	Random random = new Random(20220425);
	public LinkedListRandomNode(ListNode head) {
		// 简单的模拟，暴力法
		/*while(head != null) {
			list.add(head.val);
			head = head.next;
		}*/
		node = head;
    }
    
    public int getRandom() {
    	// 暴力法
    	/*int idx = random.nextInt(list.size());
    	return list.get(idx);*/
    	int ans = 0;
    	int idx = 0;
    	ListNode temp = node;
    	while(temp != null && ++idx >= 0) {
    		if (random.nextInt(idx) == 0) {
				ans = temp.val;
			}
    		temp = temp.next;
    	}
    	return ans;
    	
    }
    
    
}
