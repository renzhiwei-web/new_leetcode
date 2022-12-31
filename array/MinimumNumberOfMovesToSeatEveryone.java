package array;

import java.util.Arrays;

public class MinimumNumberOfMovesToSeatEveryone {
    //leetcode 2037 simple 2022/12/31
    // 此题使用贪心算法
    public int minMovesToSeat(int[] seats, int[] students) {
        Arrays.sort(seats);
        Arrays.sort(students);
        int ans = 0;
        for (int i = 0; i < seats.length; i++) {
            ans += Math.abs(seats[i] - students[i]);
        }
        return ans;
    }
}
