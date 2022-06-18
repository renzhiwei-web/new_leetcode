package link;

public class InsertIntoASortedCircularLinkedList {
	// leetcode 2475 medium 2022/6/18
	// 难点是找到插入的位置，由于空列表与单节点列表的特殊性，需要单独考虑
    public Node insert(Node head, int insertVal) {
    	// 当前列表是空的
        if (head == null) {
			head = new Node(insertVal);
			head.next = head;
			return head;
		}
        Node insertNode = new Node(insertVal);
        // 当前列表只有一个节点
        if (head.next == head) {
        	head.next = insertNode;
        	insertNode.next = head;
        	return head;
		}
        //当前列表有多个节点
        Node curNode = head,nextNode = head.next;
        while(nextNode != head) {
        	// 找到可插入的位置
        	if (insertVal >= curNode.val && insertVal <= nextNode.val) {
				break;
			}
        	// 如果找到最小值的节点，nextNode是最小节点
        	if (curNode.val > nextNode.val) {
        		// 如果插入节点大于列表最大值节点或者，插入节点小于最小值节点，也是插入位置
				if (insertVal > curNode.val || insertVal < nextNode.val) {
					break;
				}
			}
        	curNode = curNode.next;
        	nextNode = nextNode.next;
        }
        curNode.next = insertNode;
        insertNode.next = nextNode;
        return head;
    }
}
