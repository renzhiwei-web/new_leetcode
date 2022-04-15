class RangeSumQueryImmutable {
    // leetcode 303 simple 2022/4/15 
    //使用前缀和的思路来优化区域和的值
    int[] sum;
    public NumArray(int[] nums) {
        int len = nums.length;
        sum = new int[len + 1];
        for (int i = 0;i < len;i++){
            sum[i + 1] = sum[i] + nums[i];
        }
    }
    
    public int sumRange(int left, int right) {
        return sum[right + 1] - sum[left];
    }
}
