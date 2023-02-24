package array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MakeArrayZeroBySubtractingEqualAmounts {
    // leetcode 2357 simple 2023/2/24
    // 转化问题思路，由题意可知，每次操作数组都是对数组中所有非零元素进行减操作，
    // 所以求出数组中不同非零元素的个数即是答案
    public int minimumOperations(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (num == 0) {
                continue;
            } else {
                set.add(num);
            }
        }
        return set.size();
    }
}
