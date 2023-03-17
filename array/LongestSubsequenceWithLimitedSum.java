package array;

import java.util.Arrays;

public class LongestSubsequenceWithLimitedSum {
    // leetcode 2389 simple 2023/3/17
    // 由题意可得，要得到子序列的最大长度
    // 使用贪心算法+前缀和+二分查找算法进行解题
    // 由题意可得，最后的结果是子序列的长度，所以与nums中元素的次序无关，所以将nums进行排序，再求出其前缀和数组
    // 再使用二分查找算法，找到符合条件的前缀和即可，从小到大排序过后，求得的结果一定是最长子序列
    public int[] answerQueries(int[] nums, int[] queries) {
        int n = nums.length,m = queries.length;
        Arrays.sort(nums);
        int[] prefix = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }
        int[] ans = new int[m];
        for (int i = 0; i < m; i++) {
            ans[i] = binarySearch(prefix,queries[i]) - 1;
        }
        return ans;
    }

    private int binarySearch(int[] prefix, int target) {
        int low = 1,high = prefix.length;
        while (low < high){
            int mid = low + (high - low) / 2;
            if (prefix[mid] > target) {
                high = mid;
            }else {
                low = mid + 1;
            }
        }
        return low;
    }
}
