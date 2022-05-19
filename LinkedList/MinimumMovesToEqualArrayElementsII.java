package array;

import java.util.Arrays;
import java.util.Random;

public class MinimumMovesToEqualArrayElementsII {
	// leetcode 462 medium 2022/5/19
	// 首先容易证明取中位数时，可以使移动次数最少
    public int minMoves21(int[] nums) {
    	int n = nums.length;
    	Arrays.sort(nums);
    	int mid = 0;
    	if (n % 2 == 1) {
			mid = nums[n / 2];
		}else {// 当数组为偶数个数时，可以取中间任意一个数作为基准值，或者取平均数
			mid = (nums[(n / 2) - 1] + nums[n / 2]) / 2; 
		}
    	int ans = 0;
    	for(int num : nums) {
    		ans += Math.abs(num - mid);
    	}
    	return ans;
    }
    
    
    Random random = new Random();
    // 依据快排来进行定位中位数
    public int minMoves2(int[] nums) {
    	int n = nums.length;
    	int target = (n - 1) / 2;
    	int mid = 0;
    	int left = 0;
    	int right = n - 1;
    	while(true) {
    		int pivotIndex = partition(nums,left,right);
    		if (pivotIndex == target) {
				mid = nums[pivotIndex];
				break;
			}else if (pivotIndex < target) {
				left = pivotIndex + 1;
			}else {
				right = pivotIndex - 1;
			}
    	}
    	int ans = 0;
    	for(int num : nums) {
    		ans += Math.abs(num - mid);
    	}
    	System.out.println(ans);
    	return ans;
    }
	private int partition1(int[] nums, int left, int right) {
		// 随机选择一个数为枢轴
		int randomIndex = left + random.nextInt(right - left + 1);
		// 将枢轴值与left所在值进行交换
		swap(nums,left,randomIndex);
		int pivot = nums[left];
		int le = left + 1;
		int ge = right;
		while(true) {
			while(le <= ge && nums[le] < pivot) {
				le++;
			}
			
			while(le <= ge && nums[ge] > pivot) {
				ge--;
			}
			if (le >= ge) {
				break;
			}
			swap(nums,le,ge);
			le++;
			ge--;
		}
		// left所在值为枢轴值，进行交换
		swap(nums,left,ge);
		return ge;
	}
	private void swap(int[] nums, int le, int ge) {
		int temp = nums[le];
		nums[le] = nums[ge];
		nums[ge] = temp;
	}
	
	// 自己写的快速排序
	private int partition(int[] nums, int left, int right) {
		// 随机选择一个数为枢轴
		int randomIndex = left + random.nextInt(right - left + 1);
		// 将枢轴值与left所在值进行交换
		swap(nums,left,randomIndex);
		int pivot = nums[left];
		while(left < right) {
			while(left < right && nums[right] >= pivot) right--;
			nums[left] = nums[right];
			while(left < right && nums[left] <= pivot) left++;
			nums[right] = nums[left];
		}
		nums[left] = pivot;
		return left;
	}
}
