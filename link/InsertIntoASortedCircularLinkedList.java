package link;

public class InsertIntoASortedCircularLinkedList {
	// leetcode 2475 medium 2022/6/18
	// �ѵ����ҵ������λ�ã����ڿ��б��뵥�ڵ��б�������ԣ���Ҫ��������
    public Node insert(Node head, int insertVal) {
    	// ��ǰ�б��ǿյ�
        if (head == null) {
			head = new Node(insertVal);
			head.next = head;
			return head;
		}
        Node insertNode = new Node(insertVal);
        // ��ǰ�б�ֻ��һ���ڵ�
        if (head.next == head) {
        	head.next = insertNode;
        	insertNode.next = head;
        	return head;
		}
        //��ǰ�б��ж���ڵ�
        Node curNode = head,nextNode = head.next;
        while(nextNode != head) {
        	// �ҵ��ɲ����λ��
        	if (insertVal >= curNode.val && insertVal <= nextNode.val) {
				break;
			}
        	// ����ҵ���Сֵ�Ľڵ㣬nextNode����С�ڵ�
        	if (curNode.val > nextNode.val) {
        		// �������ڵ�����б����ֵ�ڵ���ߣ�����ڵ�С����Сֵ�ڵ㣬Ҳ�ǲ���λ��
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
