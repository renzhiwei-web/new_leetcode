package array;

import java.util.ArrayList;
import java.util.List;

public class FindKClosestElements {
	// leetcode 658 medium 2022/8/25
	// 使用二分加双指针
	// 首先通过二分法找到与x差值最小的位置idx，然后从idx开始使用双指针往两边进行扩展
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
    	int n = arr.length,l = 0,r = n - 1;
    	while(l < r) {
    		int mid = l + r + 1 >> 1;
	    	if (arr[mid] <= x) {
				l = mid;
			}else {
				r = mid - 1;
			}
    	}
    	r = r + 1 < n && Math.abs(arr[r + 1] - x) < Math.abs(arr[r] - x) ? r + 1 : r;
    	int i = r - 1, j = r + 1;
    	while(j - i - 1 < k) {
    		if (i >= 0 && j < n) {
				if (Math.abs(arr[j] - x) < Math.abs(arr[i] - x)) {
					j++;
				}else {
					i--;
				}
			}else if (i >= 0) {
				i--;
			}else {
				j++;
			}
    	}
    	List<Integer> ans = new ArrayList<>();
    	for(int p = i + 1;p <= j - 1;p++) {
    		ans.add(arr[p]);
    	}
    	return ans;
    }
}
