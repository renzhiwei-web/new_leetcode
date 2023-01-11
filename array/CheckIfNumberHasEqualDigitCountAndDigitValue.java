package array;

import java.util.Map;

public class CheckIfNumberHasEqualDigitCountAndDigitValue {
    // leetcode 2283 simple 2023/1/11
    // 简单模拟
    public boolean digitCount(String num) {
        char[] nums = num.toCharArray();
        int[] cnt = new int[10];
        for (char ch : nums) {
            cnt[ch - '0']++;
        }
        int i = 0;
        for (;i < nums.length;i++){
            if (cnt[i] != nums[i] - '0'){
                return false;
            }
        }
        while(i < 10){
            if (cnt[i] != 0){
                return false;
            }
            i++;
        }
        return true;
    }
}
