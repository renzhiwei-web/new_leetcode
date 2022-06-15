package array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FindKThSmallestPairDistance {
	// leetcode 719 hard 2022/6/15
	// 很容易想到使用排序，然后将所有的距离对遍历出来，直接解题
	// 但是会超出时间限制
	public int smallestDistancePair(int[] nums, int k) {
		Arrays.sort(nums);
		int n = nums.length;
		Map<Integer, Integer> map = new HashMap<>();
		for(int i = 0;i < n;i++) {
			for(int j = i + 1;j < n;j++) {
				int temp = nums[j] - nums[i];
				map.put(temp, map.getOrDefault(temp, 0) + 1);
			}
		}
		int ans = 0;
		int count = 0;
		while(count < k) {
			if (map.containsKey(ans)) {
				count += map.get(ans);
			}
			ans++;
		}
		return ans;
	}
	
	
	// 为了减少时间复杂度，使用二分法+双指针的思想
    public int smallestDistancePair1(int[] nums, int k) {
    	Arrays.sort(nums);
    	int n = nums.length;
    	int left = 0;
    	int right = nums[n - 1] - nums[0];
    	int ans = 0;
    	while(left <= right) {
    		int mid = left + (right - left) / 2;
    		int i = 0;
    		int count = 0;
    		// 计算当前小于mid的数对有多少
    		for(int j = 0;j < n;j++) {
    			while(nums[j] - nums[i] > mid) {
    				i++;
    			}
    			count += j - i;
    		}
    		// count 小于k，则继续向右遍历，否则向左遍历
    		if (count >= k) {
				ans = mid;
				right = mid - 1;
			}else {
				left = mid + 1;
			}
    	}
    	return ans;
    }
}
