package dp;

import java.util.Arrays;

public class MaximumNumberOfConsecutiveValuesYouCanMake {
    // leetcode 1798 medium 2023/2/4
    // 关注本题的主要关键点，从0开始的连续整数
    // 若取前n-1硬币可以组成tail个连续整数，将前n-1个硬币再加上第n个硬币，判断tail+coin[n] > tail + 1
    public int getMaximumConsecutive(int[] coins) {
        Arrays.sort(coins);
        int tail = 0;
        for (int coin : coins) {
            if (coin > tail + 1) {
                return tail + 1;
            }
            tail += coin;
        }
        return tail + 1;
    }
}
