package array;


public class ApplyOperationsToAnArray {
    // leetcode 2460 simple 2023/6/5
    // 简单模拟
    public int[] applyOperations(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len - 1; i++) {
            if (nums[i] == nums[i + 1]){
                nums[i] <<= 1;
                nums[i + 1] = 0;
            }
        }
        int indexNow = 0;
        int indexNum = 0;
        int m = nums.length;

        while(indexNum<m){
            if(nums[indexNum] != 0) {
                nums[indexNow++] = nums[indexNum];
            }
            ++indexNum;
        }

        for(int i = indexNow; i < m; i++){
            nums[i] = 0;
        }
        return nums;
    }

}
