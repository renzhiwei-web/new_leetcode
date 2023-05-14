package array;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class DistantBarcodes {
    // leetcode 1054 2023/5/14 medium
    // 使用顺序的数据结构，这里使用大根堆，每次都从大根堆中取出两个数构造数组
    // 若取出的两个数还有剩余，再将这两个数及其次数进行更新，然后放入大根堆中。
    public int[] rearrangeBarcodes(int[] barcodes) {
        int len = barcodes.length;
        Map<Integer,Integer> map = new HashMap<>();
        for (int b : barcodes) {
            map.put(b,map.getOrDefault(b,0) + 1);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> b[0] - a[0]);
        pq.poll();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            pq.offer(new int[]{entry.getValue(),entry.getKey()});
        }
        int[] ans = new int[len];
        for (int i = 0; i < len; i++) {
            int[] p = pq.poll();
            int cx = p[0],x = p[1];
            if (i == 0 || ans[i - 1] != x) {
                ans[i] = x;
                if (cx > 1) {
                    pq.offer(new int[]{cx - 1, x});
                }
            } else {
                int[] p2 = pq.poll();
                int cy = p2[0],y = p2[1];
                ans[i] = y;
                if (cy > 1){
                    pq.offer(new int[]{cy - 1,y});
                }
                pq.offer(new int[]{cx,x});
            }
        }
        return ans;
    }
}
