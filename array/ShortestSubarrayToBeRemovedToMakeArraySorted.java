package array;

public class ShortestSubarrayToBeRemovedToMakeArraySorted {
    // leetcode 1574 medium 2023/3/25
    // 使用双指针暴力求解,错误的解法，无法求出最短
    public int findLengthOfShortestSubarray(int[] arr) {
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            int left = i, right = i + 1;
            int curAns = i + 0;
            while (right < arr.length) {
                if (arr[right] > arr[left]) {
                    left = right;
                    right++;
                }else {
                    right++;
                    curAns++;
                }
            }
            ans = Math.min(curAns,ans);
        }
        return ans;
    }

    // 双指针与二分查找
    // 基本的解题思想是：找到arr数组的最长连续非递减前缀arr[0...i]与长连续非递减前缀后缀arr[j...(n-1)]
    // 遍历每个前缀的元素arr[l],在后缀中找到最小大于arr[l]的元素索引r，则删除arr[(l + 1)...(r - 1)]后，剩下元素就是递增的
    public int findLengthOfShortestSubarray1(int[] arr) {
        int n = arr.length;
        int i = 0,j = n - 1;
        while (i + 1 < n && arr[i] <= arr[i + 1]){
            i++;
        }
        while (j - 1 >= 0 && arr[j - 1] <= arr[j]) {
            j--;
        }
        if (i >= j) {
            return 0;
        }
        // 要不删除前缀后的所有数组元素，要不删除后缀前的所有数组元素
        int ans = Math.min(n - i - 1, j);
        for (int l = 0; l <= i; l++) {
            // 在后缀中找到与arr[l] 最相近的元素的索引
            int r = search(arr,arr[l],j);
            ans = Math.min(ans,r - l - 1);
        }
        return ans;
    }

    /**
     * 在后缀中找到与arr[l] 最相近的元素的索引
     * @param arr
     * @param target
     * @param left
     * @return
     */
    private int search(int[] arr, int target, int left) {
        int right = arr.length;
        while (left < right) {
            int mid = (left + right) >> 1;
            if (arr[mid] >= target) {
                right = mid;
            }else {
                left = mid + 1;
            }
        }
        return left;
    }
}
