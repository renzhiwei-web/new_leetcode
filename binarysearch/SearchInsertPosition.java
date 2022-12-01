package binarysearch;

public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        // leetcode 35 simple 2022/12/1
        // 二分法
        int left = 0,right = nums.length;
        while(left + 1 != right) {
            int mid = (left + right) >> 1;
            if (nums[mid] == target){
                return mid;
            } else if (nums[mid] < target) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return right;
    }
}
