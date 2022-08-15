package designClass;

public class MyCircularDeque {
	// leetcode 641 medium 2022/8/15
	// 实现双端队列，可以从front端增删元素
	private int capacity;
	private int[] arr;
	private int front; // 指向第一个元素存放的位置
	private int rear; // 指向下一个插入元素的位置
	// 循环队列
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
