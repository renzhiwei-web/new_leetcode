package designClass;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class ExamRoom {
    // leetcode 855 medium 2022/12/30
    // 思路比较简单：找到最长的线段，从中间分割成两段，中点就是seat的返回值
    // 找到p的左右线段，合并成一个线段，这就是leave(p)的逻辑
    private Map<Integer,int[]> startMap; // 将端点p映射到以p为左端点的线段
    private Map<Integer,int[]> endMap; // 将端点p映射到以p为右端点的线段
    private TreeSet<int[]> pq; //根据线段长度从小到大存放所有线段
    private int N;
    public ExamRoom(int n) {
        N = n;
        startMap = new HashMap<>();
        endMap = new HashMap<>();
        pq = new TreeSet<>((a,b) -> {
            int distA = distance(a);
            int distB = distance(b);
            // 如果长度相同，就比较索引
            if (distA == distB){
                return b[0] - a[0];
            }
            return distA - distB;
        });
        // 在有序集合中存放一个虚拟线段
        addInterval(new int[]{-1,n});
    }

    private void addInterval(int[] intv) {
        pq.add(intv);
        startMap.put(intv[0],intv);
        endMap.put(intv[1],intv);
    }

    private int distance(int[] intv) {
        int x = intv[0];
        int y = intv[1];
        if (x == -1){
            return y;
        }
        if (y == N){
            return N - 1 - x;
        }
        return (y - x) / 2;
    }

    public int seat() {
        // 从有序集合拿出最长的线段
        int[] longest = pq.last();
        int x = longest[0];
        int y = longest[1];
        int seat;
        if (x == -1){
            seat = 0;
        } else if (y == N) {
            seat = N - 1;
        }else{
            seat = (y - x) / 2 + x;
        }
        // 将最长的线段分成两段
        int[] left = new int[]{x,seat};
        int[] right = new int[]{seat,y};
        removeInterval(longest);
        addInterval(left);
        addInterval(right);
        return seat;
    }

    private void removeInterval(int[] intv) {
        pq.remove(intv);
        startMap.remove(intv[0]);
        endMap.remove(intv[1]);
    }

    public void leave(int p) {
        // 将p的左右线段找出来
        int[] right = startMap.get(p);
        int[] left = endMap.get(p);
        // 合并两个线段成为一个线段
        int[] merged = new int[]{left[0],right[1]};
        removeInterval(left);
        removeInterval(right);
        addInterval(merged);
    }
}
