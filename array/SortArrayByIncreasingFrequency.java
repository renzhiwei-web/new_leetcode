package array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SortArrayByIncreasingFrequency {
	// leetcode 1636 simple 2022/9/19
	// 主要学习排序的方法
    public int[] frequencySort(int[] nums) {
    	Map<Integer, Integer> map = new HashMap<>();
    	for(int num : nums) {
    		map.put(num, map.getOrDefault(num, 0) + 1);
    	}
    	List<Integer> list = new ArrayList<>();
    	for(int num : nums) {
    		list.add(num);
    	}
    	list.sort((a,b) -> {
    		int cnt1 = map.get(a);
    		int cnt2 = map.get(b);
    		// 如果a，b的频数不同，则按频数排序，若相同，则数学顺序排序
    		return cnt1 != cnt2 ? cnt1 - cnt2 : b - a;
    	});
    	for(int i = 0;i < nums.length;i++) {
    		nums[i] = list.get(i);
    	}
    	return nums;
    }
}
