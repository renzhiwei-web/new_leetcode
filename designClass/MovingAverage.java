package designClass;

import java.util.ArrayDeque;
import java.util.Deque;

public class MovingAverage {
	// leetcode 2518 simple 2022/7/16
	// ¼òµ¥Ä£Äâ¼´¿É

	Deque<Integer> queue;
	int maxSize;
	double sum = 0;
    /** Initialize your data structure here. */
    public MovingAverage(int size) {
    	queue = new ArrayDeque<>();
    	maxSize = size;
    }
    
    public double next(int val) {
    	if (queue.size() == maxSize) {
			int temp = queue.removeFirst();
			sum -= temp;
			queue.addLast(val);
			sum += val;
		}else {
			queue.addLast(val);
			sum += val;
		}
    	return sum / (double)queue.size();
    }
}
