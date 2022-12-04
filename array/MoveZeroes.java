package array;

public class MoveZeroes {
    // leetcode 283 simple 2022/12/4

    public void moveZeroes(int[] nums) {
        if (nums == null){
            return;
        }
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0){
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j++] = tmp;
            }
        }
    }
}
