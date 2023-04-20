package dp;

import java.util.Arrays;

public class MakeArrayStrictlyIncreasing {
    // leetcode 1187 hard 2023/4/20
    // 使用动态规划
    public int makeArrayIncreasing(int[] arr1, int[] arr2) {
        Arrays.sort(arr2);
        // 去重，m表示去重过程中的索引
        int m = 0;
        for (int x : arr2) {
            if (m == 0 || x != arr2[m - 1]){
                arr2[m++] = x;
            }
        }
        final int inf = 1 << 30;
        int[] arr = new int[arr1.length + 2];
        arr[0] = -inf;
        arr[arr.length - 1] = inf;
        // 将arr1复制到arr数组中，且增加前后两个哨兵，便于计算
        System.arraycopy(arr1,0,arr,1,arr1.length);
        int[] dp = new int[arr.length];
        Arrays.fill(dp,inf);
        dp[0] = 0;
        for (int i = 1; i < arr.length; i++) {
            // 如果当前数字与前一个数字保持严格递增，则可以直接进行状态转换
            if (arr[i - 1] < arr[i]){
                dp[i] = dp[i - 1];
            }
            // 利用二分查找在arr2中第一个大于等于 arr[i] 的下标 j
            int j = search(arr2,arr[i],m);
            for (int k = 1; k <= Math.min(i - 1,j); k++) {
                // 使用arr2[j]之前的数字替换arr1[i - 1]以及之前的数字，
                // 由于arr2是有序的，所以替换后的数字无需考虑与前一个的递增关系
                if (arr[i - k - 1] < arr2[j - k]){
                    dp[i] = Math.min(dp[i],dp[i - k - 1] + k);
                }
            }
        }
        return dp[arr.length - 1] >= inf ? -1 : dp[arr.length - 1];
    }

    private int search(int[] arr2, int x, int n) {
        int l = 0,r = n;
        while (l < r) {
            int mid = (l + r) >> 1;
            if (arr2[mid] >= x) {
                r = mid;
            }else {
                l = mid + 1;
            }
        }
        return l;
    }
}
