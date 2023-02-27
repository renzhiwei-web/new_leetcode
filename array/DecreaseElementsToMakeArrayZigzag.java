package array;


public class DecreaseElementsToMakeArrayZigzag {
    // leetcode 1144 直接使用暴力求解
    // 首先容易想到，进行分类讨论
    // 将数组分为奇数索引大还是偶数索引大，再分别使用贪心算法进行解题
    public int movesToMakeZigzag(int[] nums) {
        return Math.min(even(nums),odd(nums));
    }

    private int odd(int[] nums) {
        int ans = 0;
        for (int i = 1; i < nums.length; i += 2) {
            int a = 0;
            if (i - 1 >= 0){
                a = Math.max(a,nums[i] - nums[i - 1] + 1);
            }
            if (i + 1 < nums.length){
                a = Math.max(a,nums[i] - nums[i + 1] + 1);
            }
            ans += a;
        }
        return ans;
    }

    private int even(int[] nums) {
        int ans = 0;
        for (int i = 0; i < nums.length; i += 2) {
            int a = 0;
            if (i - 1 >= 0){
                a = Math.max(a,nums[i] - nums[i - 1] + 1);
            }
            if (i + 1 < nums.length){
                a =  Math.max(a,nums[i] - nums[i + 1] + 1);
            }
            ans += a;
        }
        return ans;
    }
}
