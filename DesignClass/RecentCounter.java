package designClass;

import java.util.ArrayDeque;
import java.util.Deque;

public class RecentCounter {
	// leetcode 933 simple 2022/5/6
	// 首先需要思考的是选取一个合适的数据结构来存储访问的时间
	Deque<Integer> queue;
	public RecentCounter() {
		queue = new ArrayDeque<>();
    }
    
    public int ping(int t) {
    	queue.addLast(t);
    	while(queue.peek() + 3000 < t) {
    		queue.pollFirst();
    	}
    	return queue.size();
    }
}
