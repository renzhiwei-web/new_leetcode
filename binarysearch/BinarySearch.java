package binarysearch;

public class BinarySearch {
    // leetcode 704 simple 2022/12/1
    public int search(int[] nums, int target) {
        int left = -1,right = nums.length;
        while(left + 1 != right) {
            int mid = (left + right) >> 1;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid;
            }else {
                right = mid;
            }
        }
        return -1;
    }
}
