package array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class NumberOfDistinctAverages {
    // leetcode 2465 2023/6/4 双指针简单模拟
    public int distinctAverages(int[] nums) {
        int len = nums.length;
        Arrays.sort(nums);
        int left = 0,right = len - 1;
        Set<Double> set = new HashSet<>();
        while (left < right){
            double v = (float) (nums[left] + nums[right]) / 2.0;
            set.add(v);
            left++;
            right--;
        }
        return set.size();
    }
}
