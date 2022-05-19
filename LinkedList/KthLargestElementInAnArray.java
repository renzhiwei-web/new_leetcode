package array;

import java.util.Random;

public class KthLargestElementInAnArray {
	// leetcode 215 medium 2022/5/19
	// 首先想到使用快速排序进行解题
    public int findKthLargest1(int[] nums, int k) {
    	int len = nums.length;
    	int target = len - k;
    	int left = 0,right = len - 1;
    	while(true) {
    		int pivotIndex = partition(nums,left,right);
    		if (pivotIndex == target) {
				return nums[pivotIndex];
			}else if (pivotIndex < target) {
				left = pivotIndex + 1;
			}else {
				right = pivotIndex - 1;
			}
    	}
    }

    private void swap(int[] nums, int le, int ge) {
		int temp = nums[le];
		nums[le] = nums[ge];
		nums[ge] = temp;
	}
	
	// 自己写的快速排序
    Random random = new Random();
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
	
	// 使用堆排序进行解题
	public int findKthLargest(int[] nums, int k) {
		int heapSize = nums.length;
		buildMaxHeap(nums,heapSize);
		for(int i = nums.length - 1;i >= nums.length - k + 1;i--) {
			swap(nums, 0, i);
			heapSize--;
			maxHeapify(nums,0,heapSize);
		}
		return nums[0];
	}

	private void maxHeapify(int[] nums, int i, int heapSize) {
		int l = i * 2 + 1,r = i * 2 + 2,largset = i;// l为左节点，r为右节点，largeset为根，左，右节点中的最大值
		if (l < heapSize && nums[l] > nums[largset]) {
			largset = l;
		}
		if (r < heapSize && nums[r] > nums[largset]) {
			largset = r;
		}
		if (largset != i) {// 如果最大值的节点不是根节点，则进行交换，并对交换后节点再进行递归的调整
			swap(nums, i, largset);
			maxHeapify(nums, largset, heapSize);
		}
	}

	private void buildMaxHeap(int[] nums, int heapSize) {
		// 从第一个非叶子节点为根节点的子树开始，将其调整为大根堆
		for(int i = heapSize / 2;i >= 0;i--) {
			maxHeapify(nums, i, heapSize);
		}
	}
}
