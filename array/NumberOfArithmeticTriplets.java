package array;

import java.util.HashSet;
import java.util.Set;

public class NumberOfArithmeticTriplets {
    // leetcode 2367 simple 2023/3/31
    // 使用数组或者哈希表简单模拟即可
    public int arithmeticTriplets(int[] nums, int diff) {
        int len = nums.length;
        int ans = 0;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        for (int num : nums) {
            if (set.contains(num + diff) && set.contains(num + 2 * diff)) {
                ans++;
            }
        }
        return ans;
    }
}
