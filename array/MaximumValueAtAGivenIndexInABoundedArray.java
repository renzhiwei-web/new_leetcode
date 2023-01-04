package array;

public class MaximumValueAtAGivenIndexInABoundedArray {
    // leetcode 1802 medium 2023/1/4
    // 可以将此问题转成求nums[index]=target的问题，求target的值
    // 由题意可得，若设target最大，则nums[index - i] = target - i,nums[index + i] = target + i
    // 当sum（nums） == maxsum时，target值最大
    // 使用二分搜索算法寻找target
    public int maxValue(int n, int index, int maxSum) {
        int left = 1,right = maxSum;
        while(left < right){
            int mid = (left + right + 1) >> 1;
            if (-mid + get(mid,index + 1) + get(mid,n - index) <= maxSum){
                left = mid;
            }else {
                right = mid - 1;
            }
        }
        return right;
    }

    private long get(long mid, int cnt) {
        return cnt >= mid ? cnt - mid + (mid + 1) * mid / 2 : (2 * mid - cnt + 1) * cnt / 2;
    }
}
