package designClass;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Stack;

public class FreqStack {
    // leetcode 895 hard 2022/11/30
    // 数据结构的应用
    int idx;
    // 设置三元组，val，freq，time，时间越大表示越靠近栈顶
    // 利用优先队列来实现栈结构
    PriorityQueue<int[]> q;
    Map<Integer,Integer> freq;
    public FreqStack() {
        q = new PriorityQueue<int[]>((a,b) -> a[1] == b[1] ? b[2] - a[2] : b[1] - a[1]);
        freq = new HashMap<>();
    }

    public void push(int val) {
        freq.put(val,freq.getOrDefault(val,0) + 1);
        q.add(new int[]{val,freq.get(val),idx++});

    }

    public int pop() {
        int[] t = q.poll();
        freq.put(t[0],t[1] -1);
        return t[0];
    }
}
