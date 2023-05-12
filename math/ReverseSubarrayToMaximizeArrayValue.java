package math;

public class ReverseSubarrayToMaximizeArrayValue {
    public int maxValueAfterReverse(int[] nums) {
        int base = 0,d = 0,n = nums.length;
        int mx = Integer.MAX_VALUE,mn = Integer.MIN_VALUE;
        for (int i = 1; i < n; i++) {
            int a = nums[i - 1];
            int b = nums[i];
            int dab = Math.abs(a - b);
            base += dab;
            mx = Math.max(mx,Math.min(a,b));
            mn = Math.min(mn,Math.max(a,b));
            // 处理边界问题，当i=0或j=1
            d = Math.max(d,Math.max(Math.abs(nums[0] - b) -dab,Math.abs(nums[n - 1] - a) - dab));
        }
        return base + Math.max(d,2 * (mx - mn));
    }
}
