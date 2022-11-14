package array;

import java.util.HashSet;
import java.util.Set;

public class SplitArrayWithSameAverage {
    // leetcode 805 hard 2022/11/14
    // 目标是求出原数组的两个子数组，使得两个子数组的平均数相等
    // 由于两个子数组平均数相等，则两个子数组的平均数与原数组相等
    // 可以使目标问题转移成等价问题，
    // 将原数组中每个元素 减去 平均数，这样使得原数组和为0
    // 再从原数组中找到两个子数组，使两个子数组的和为0
    // 由于会出现浮点数运算，可以将原数组每个元素 a[i] * len(nums) - sum(nums)
    // 这样原数组的和变为0，但每个元素还是整数
    // 由于数组的子数组除去空集，共有2^(len(nums))中情况，为减少时间复杂度，将数组平分
    // 平分后的左右数组，判断其子集和是否存在为0或者互为相反数的情况。
    public boolean splitArraySameAverage(int[] nums) {
        if (nums.length == 1){
            return false;
        }
        int n = nums.length;
        int m = n / 2;
        int sum = 0;
        for (int num :
                nums) {
            sum += num;
        }
        for (int i = 0; i < n; i++) {
            nums[i] = nums[i] * n - sum;
        }
        Set<Integer> set = new HashSet<>();
        // 这段代码大意是,子集（除空集）共有2^(len(nums))种情况，求出每种集合的和
        for (int i = 1; i < (1 << m); i++) {
            int tot = 0;
            for (int j = 0; j < m; j++) {
                if ((i & (1 << j)) != 0){
                    tot += nums[j];
                }
            }
            if (tot == 0){
                return true;
            }
            set.add(tot);
        }
        int rsum = 0;
        for (int i = m; i < n; i++) {
            rsum += nums[i];
        }
        for (int i = 1; i < (1 << (n - m)); i++) {
            int tot = 0;
            for (int j = m; j < n; j++) {
                if ((i & (1 << (j - m))) != 0){
                    tot += nums[j];
                }
            }
            // 若rsum == tot，这种情况是，整个数组的和为0，但是没有子集为0
            if (tot == 0 || ((rsum != tot) && (set.contains(-tot)))){
                return true;
            }
        }
        return false;
    }

    public boolean splitArraySameAverage1(int[] nums) {
        if (nums.length == 1) {
            return false;
        }
        int n = nums.length, m = n / 2;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        boolean isPossible = false;
        for (int i = 1; i <= m; i++) {
            if (sum * i % n == 0) {
                isPossible = true;
                break;
            }
        }
        if (!isPossible) {
            return false;
        }
        Set<Integer>[] dp = new Set[m + 1];
        for (int i = 0; i <= m; i++) {
            dp[i] = new HashSet<Integer>();
        }
        dp[0].add(0);
        for (int num : nums) {
            for (int i = m; i >= 1; i--) {
                for (int x : dp[i - 1]) {
                    int curr = x + num;
                    if (curr * n == sum * i) {
                        return true;
                    }
                    dp[i].add(curr);
                }
            }
        }
        return false;
    }
}
