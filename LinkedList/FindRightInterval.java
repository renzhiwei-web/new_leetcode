package array;

import java.util.Arrays;

public class FindRightInterval {
	// leetcode 436 medium 2022/5/20
	// 首先想到暴力法
    public int[] findRightInterval1(int[][] intervals) {
    	int len = intervals.length;
    	int[] ans = new int[len];
    	Arrays.fill(ans, -1);
    	for(int i = 0;i < len;i++) {
    		int minEnd = Integer.MAX_VALUE;
    		int rightEnd = intervals[i][1]; // 注意，最右区间包括自身
    		for(int j = 0;j < len;j++) {
    			if (intervals[j][0] >= rightEnd && intervals[j][0] < minEnd) {
					minEnd = intervals[j][0];
    				ans[i] = j;
				}
    		}
    	}
    	return ans;
    	
    }
    
    // 既然要求寻找顺序，则想到使用排序后进行二分查找来降低复杂度
    public int[] findRightInterval2(int[][] intervals) {
    	int len = intervals.length;
    	int[][] start = new int[len][2];
    	// 将每个区间的start存入索引数组中，且存放索引
    	for(int i = 0;i < len;i++) {
    		start[i][0] = intervals[i][0];
    		start[i][1] = i;
    	}
    	Arrays.sort(start,(o1,o2) -> o1[0] - o2[0]);
    	
    	int[] ans = new int[len];
    	for(int i = 0;i < len;i++) {
    		int left = -1,right = len;
    		int target = -1;
    		while(left +1 !=  right) {
    			int mid = (left + right) >> 1;
    			if (start[mid][0] >= intervals[i][1]) {
					target = start[mid][1];
					right = mid;
				}else {
					left = mid;
				}
    		}
    		ans[i] = target;
    	}
    	return ans;
    }
    
    // 新思想，双指针方法，莫队思想
    public int[] findRightInterval(int[][] intervals) {
    	int len = intervals.length;
    	int[][] start = new int[len][2];
    	int[][] end = new int[len][2];
    	for(int i = 0;i < len;i++) {
    		start[i][0] = intervals[i][0];
    		start[i][1] = i;
    		end[i][0] = intervals[i][1];
    		end[i][1] = i;
    	}
    	Arrays.sort(start,(o1,o2) -> o1[0] - o2[0]);
    	Arrays.sort(end,(o1,o2) -> o1[0] - o2[0]);
    	
    	int[] ans = new int[len];
    	for(int i = 0,j = 0;i < len;i++) {
    		while(j < len && end[i][0] > start[j][0]) {
    			j++;
    		}
    		if (j < len) {
				ans[end[i][1]] = start[j][1];
			}else {
				ans[end[i][1]] = -1;
			}
    	}
    	return ans;
    }
}
