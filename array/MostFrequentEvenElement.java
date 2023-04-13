package array;

import java.util.HashMap;
import java.util.Map;

public class MostFrequentEvenElement {
    // leetcode 2404 simple 2023/4/13
    // 简单模拟即可
    public int mostFrequentEven(int[] nums) {
        int len = nums.length;
        Map<Integer,Integer> count = new HashMap<>();
        for (int x : nums) {
            if ((x & 1) == 0) {
                count.put(x,count.getOrDefault(x,0) + 1);
            }
        }
        int ans = -1,ct = 0;
        for (Map.Entry<Integer, Integer> entry :
                count.entrySet()) {
            if (ans == -1 || entry.getValue() > ct || entry.getValue() == ct && ans > entry.getKey()) {
                ans = entry.getKey();
                ct = entry.getValue();
            }
        }
        return ans;
    }
}
