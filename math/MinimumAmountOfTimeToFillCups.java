package math;

import java.util.Arrays;

public class MinimumAmountOfTimeToFillCups {
    // leetcode 2335 simple 2023/2/11
    // 数学思想简单模拟
    public int fillCups(int[] amount) {
        Arrays.sort(amount);
        if (amount[2] >= amount[0] + amount[1]){
            return amount[2];
        }
        int sum = amount[0] + amount[1] + amount[2];
        return (sum & 1) == 0 ? sum >> 1 : (sum >> 1) + 1;
    }
}
