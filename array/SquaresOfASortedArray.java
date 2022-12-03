package array;

import java.util.ArrayList;
import java.util.List;

public class SquaresOfASortedArray {
    // leetcode 977 simple 2022/12/3
    // 双指针
    public int[] sortedSquares(int[] nums) {
        int postIdx = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= 0){
                postIdx = i;
                break;
            }
        }
        int[] ans = new int[nums.length];
        if (postIdx == -1){ // 没有正数
            for (int i = 0; i < nums.length; i++) {
                ans[i] = (int) Math.pow(nums[nums.length - i - 1],2);
            }
            return ans;
        }

        List<Integer> list = new ArrayList<>();
        int left = postIdx - 1;
        int right = postIdx;
        while(left >= 0 && right < nums.length){
            if (Math.abs(nums[left]) <= nums[right]){
                list.add((int) Math.pow(nums[left], 2));
                left--;
            }else {
                list.add((int) Math.pow(nums[right], 2));
                right++;
            }
        }
        while(left >= 0){
            list.add((int) Math.pow(nums[left], 2));
            left--;
        }
        while (right < nums.length){
            list.add((int) Math.pow(nums[right], 2));
            right++;
        }
        for (int i = 0; i < nums.length; i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }
}
