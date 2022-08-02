package designClass;

public class MyCircularQueue {
	// leetcode 622 medium 2022/8/2
	// ѭ�����е�ʵ��
	int len;
	int head = 0;
	int tail = 0;
	int[] nums;
    public MyCircularQueue(int k) {
    	len = k + 1; // ���һλ�����ж�ѭ�������Ƿ���
    	nums = new int[len];
    }
    
    public boolean enQueue(int value) {
    	if (isFull()) {
			return false;
		}
    	nums[tail % len] = value;
    	tail++;
    	return tail >= 0;
    }
    
    public boolean deQueue() {
    	if (isEmpty()) {
			return false;
		}
    	head++;
    	return head >= 0;
    }
    
    public int Front() {
    	return isEmpty() ? -1 : nums[head % len];
    }
    
    public int Rear() {
    	return isEmpty() ? -1 : nums[(tail - 1) % len];
    }
    
    public boolean isEmpty() {
    	return head == tail;
    }
    
    public boolean isFull() {
    	return (tail + 1) % len == head;
    }
}
