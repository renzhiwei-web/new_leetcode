package array;

public class MinMaxGame {
    // leetcode 2293 simple 2023/1/15
    // 由题意可得，首先想到模拟方法
    public int minMaxGame(int[] nums) {
        int n = nums.length;
        if (n == 1){
            return nums[0];
        }
        int[] newNums = new int[n / 2];
        for (int i = 0; i < newNums.length; i++) {
            if ((i & 1) != 0){
                newNums[i] = Math.max(nums[2 * i], nums[2 * i + 1]);
            }else {
                newNums[i] = Math.min(nums[2 * i], nums[2 * i + 1]);
            }
        }
        return minMaxGame(newNums);
    }

    // 原地修改数组
    // 由leetcode执行结果来看，不如直接模拟效率高
    public int minMaxGame1(int[] nums) {
        int n = nums.length;
        for (;n > 1;){
            n >>= 1;
            for (int i = 0; i < n; i++) {
                int a = nums[i << 1],b = nums[i << 1 | 1];
                nums[i] = (i & 1) != 0 ? Math.max(a,b) : Math.min(a,b);
            }
        }
        return nums[0];
    }
}
