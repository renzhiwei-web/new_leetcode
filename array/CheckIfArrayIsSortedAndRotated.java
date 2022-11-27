package array;

public class CheckIfArrayIsSortedAndRotated {
    // leetcode 1752 simple 2022/11/27
    // 简单模拟即可，但是有个小陷阱
    public boolean check(int[] nums) {
        int n = nums.length;
        int count = 0;
        for (int i = 1; i < n; i++) {
            if (count > 1) {
                return false;
            }
            if (nums[i - 1] > nums[i]){
                count++;
            }
        }
        // 当count == 1时，需要判断是经过轮转得到的
        // 轮转的结果是队首数字要大于等于队尾数字
        return (count == 1 && nums[0] >= nums[n - 1]) || count == 0;
    }
}
