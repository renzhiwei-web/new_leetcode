package array;

import java.util.HashMap;
import java.util.Map;

public class MaximumNumberOfPairsInArray {
    // leetcode 2341 simple 2023/2/16
    // 简单模拟
    public int[] numberOfPairs(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num,map.getOrDefault(num,0) + 1);
        }
        int counts_pair = 0,couts_leftover = 0;
        for (var key : map.keySet()) {
            counts_pair += map.get(key) / 2;
            couts_leftover += map.get(key) % 2;
        }
        return new int[]{counts_pair,couts_leftover};
    }
}
