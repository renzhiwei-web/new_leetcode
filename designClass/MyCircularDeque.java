package designClass;

public class MyCircularDeque {
	// leetcode 641 medium 2022/8/15
	// ʵ��˫�˶��У����Դ�front����ɾԪ��
	private int capacity;
	private int[] arr;
	private int front; // ָ���һ��Ԫ�ش�ŵ�λ��
	private int rear; // ָ����һ������Ԫ�ص�λ��
	// ѭ������
    public MyCircularDeque(int k) {
    	capacity = k + 1;
    	arr = new int[capacity];
    	front = 0;
    	rear = 0;
    }
    
    public boolean insertFront(int value) {
    	if (isFull()) {
			return false;
		}
    	front = (front - 1 + capacity) % capacity;
    	arr[front] = value;
    	return true;
    }
    
    public boolean insertLast(int value) {
    	if (isFull()) {
			return false;
		}
    	arr[rear] = value;
    	rear = (rear + 1) % capacity;
    	return true;
    }
    
    public boolean deleteFront() {
    	if (isEmpty()) {
			return false;
		}
    	front = (front + 1) % capacity;
    	return true;
    }
    
    public boolean deleteLast() {
    	if (isEmpty()) {
			return false;
		}
    	rear = (rear - 1 + capacity) % capacity;
    	return true;
    }
    
    public int getFront() {
    	if (isEmpty()) {
			return -1;
		}
    	return arr[front];
    }
    
    public int getRear() {
    	if (isEmpty()) {
			return -1;
		}
    	return arr[(rear - 1 + capacity) % capacity];
    }
    
    public boolean isEmpty() {
    	return front == rear;
    }
    
    public boolean isFull() {
    	return (rear + 1) % capacity == front;
    }
}
