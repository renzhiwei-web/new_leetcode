package array;

import java.util.HashMap;
import java.util.Map;

public class CountSubarraysWithMedianK {
    // leetcode 2488 hard 2023/3/16
    // 使用前缀和进行解题
    // 由题意可得，设k在nums中的下标为kIndex，则符合题意的子数组有以下特点
    // 子数组的起始下标小于等于Kindex，且结束下标大于等于Kindex
    // 子数组中大于k的元素个数与小于k的元素个之差为0或1
    // 将大于k的元素设为1，小于k的元素设为-1，等于k的元素设为0，计算转换后的数组的前缀和
    // 利用转换后的前缀和来判断元素的个数
    public int countSubarrays(int[] nums, int k) {
        int n = nums.length;
        int kIndex = -1;
        for (int i = 0; i < n; i++) {
            if (nums[i] == k){
                kIndex = i;
                break;
            }
        }
        int ans = 0;
        Map<Integer,Integer> counts = new HashMap<>();
        counts.put(0,1);
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += sign(nums[i] - k);
            if (i < kIndex){
                counts.put(sum,counts.getOrDefault(sum,0) + 1);
            }else {
                int prev0 = counts.getOrDefault(sum,0);
                int prev1 = counts.getOrDefault(sum - 1,0);
                ans += prev0 + prev1;
            }
        }
        return ans;
    }

    private int sign(int num) {
        if (num == 0){
            return 0;
        }
        return num > 0 ? 1: -1;
    }
}