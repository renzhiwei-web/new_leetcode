package array;

import java.util.Arrays;

public class SumOfSubsequenceWidths {
    // leetcode 891 hard 2022/11/18
    // 求所有子序列的最大值与最小值的差
    private static final int MOD = (int) 1e9 + 7;
    public int sumSubseqWidths(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int[] pow = new int[n];
        pow[0] = 1;
        for (int i = 1; i < n; i++) {
            pow[i] = pow[i - 1] * 2 % MOD;
        }
        long ans = 0L;
        for (int i = 0; i < n; i++) {
            ans += (long) (pow[i] - pow[n - 1 - i]) * nums[i];
        }
        return (int)(ans % MOD + MOD) % MOD;
    }
}
