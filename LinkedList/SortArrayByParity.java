package array;

public class SortArrayByParity {
	// leetcode 905 simple 2022/4/28
	// 使用双指针模拟即可，用的是快排的思想
	public int[] sortArrayByParity(int[] nums) {
		int len = nums.length;
		int left = 0, right = len - 1;
		while (left < right) {
			while (left < len && nums[left] % 2 == 0) {
				left++;
			}
			while (right >= 0 && nums[right] % 2 == 1) {
				right--;
			}
			if (left < right) {

				int temp = nums[left];
				nums[left] = nums[right];
				nums[right] = temp;
				left++;
				right--;
			}
		}
		return nums;
	}
}
