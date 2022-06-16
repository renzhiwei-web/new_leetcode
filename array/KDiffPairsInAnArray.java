package array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class KDiffPairsInAnArray {
	// leetcode 532 medium 2022/6/16
	// 首先容易想到使用排序+双指针的方法进行解答。但是难点是要求去重
	public int findPairs2(int[] nums, int k) {
    	int n = nums.length,ans = 0;
    	Arrays.sort(nums);
    	for(int i = 0,j = 0;i < n - 1 && j < n;i++) {
    		// 重复的不计算，如果相同的nums[i - 1]已经计算过了
    		if(i > 0 && nums[i] == nums[i - 1]) {
    			continue;
    		}
    		while(j <= i) {
    			j++;
    		}
    		while(j < n && (nums[j] < nums[i] + k)) {
    			j++;
    		}
    		//找到目标值
    		if (j < n && nums[j] == nums[i] + k) {
				ans++;
			}
    	}
    	return ans;
    }
	
	// 去重要想到两个数据结构，set与map，这里使用map会更好
    public int findPairs1(int[] nums, int k) {
    	Map<Integer, Integer> map = new HashMap<>();
    	for(int i : nums) {
    		map.put(i, map.getOrDefault(i, 0) + 1);
    	}
    	int ans = 0;
    	for(int i : nums) {
    		if (map.get(i) == 0) {
				continue;
			}
    		if (k == 0) {
				if (map.get(i) > 1) {
					ans++;
				}
			}else {
				int a = i - k;
				int b = i + k;
				if (map.getOrDefault(a, 0) > 0 ) {
					ans++;
				}
				if (map.getOrDefault(b, 0) > 0 ) {
					ans++;
				}
			}
    		map.put(i, 0);
    	}
    	return ans;
    }
    
    // 由于是寻找数对，可以通过定位一个数字，查找另一个数字，这里使用二分查找来降低时间复杂度
    public int findPairs(int[] nums, int k) {
    	int n = nums.length,ans = 0;
    	Arrays.sort(nums);
    	for(int i = 0;i < n - 1;i++) {
    		if(i > 0 && nums[i] == nums[i - 1]) {
    			continue;
    		}
    		int target = nums[i] + k;
    		int left = i,right = n;
    		while(left + 1 != right) {
    			int mid = (left + right) / 2;
    			if (nums[mid] == target) {
					ans++;
					break;
				}else if (nums[mid] > target) {
					right = mid;
				}else {
					left = mid;
				}
    		}
    	}
    	return ans;
    }

}
