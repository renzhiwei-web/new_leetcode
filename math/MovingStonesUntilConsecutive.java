package math;

import java.util.Arrays;

public class MovingStonesUntilConsecutive {
    // leetcode 1033 medium 2023/4/30
    // 进行分类讨论
    public int[] numMovesStones(int a, int b, int c) {
        int[] ans = new int[2];
        int[] stones = new int[]{a,b,c};
        Arrays.sort(stones);
        a = stones[0];
        b = stones[1];
        c = stones[2];
        int max = c - a - 2;
        int min = c - a == 2 ? 0 : b - a <= 2 || c - b <= 2 ? 1 : 2;
        ans[0] = min;
        ans[1] = max;
        return ans;
    }
}
