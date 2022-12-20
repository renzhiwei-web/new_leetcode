package array;

import java.util.Arrays;

public class MinimumLimitOfBallsInABag {
    // leetcode 1760 medium 2022/12/20
    // 使用二分法就行解题，给定花销mid,是否能够在maxOperations次操作内使得盒子所有的数都小于等于mid
    public int minimumSize(int[] nums, int maxOperations) {
        int l = 1, r = Arrays.stream(nums).max().getAsInt();
        while (l < r) {
            int mid = (l + r) / 2;
            if (check(mid, nums, maxOperations)) r = mid;
            else l = mid + 1;
        }
        return r;
    }
    boolean check(int mid, int[] nums, int op) {
        for (int x : nums) op -= (x - 1)/ mid;
        return op >= 0;

    }
}
