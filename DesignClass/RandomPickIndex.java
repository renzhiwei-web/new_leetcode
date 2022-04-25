package designClass;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class RandomPickIndex {
	// leetcode 398 medium 2022/4/25
	// 使用hash法来求得索引
	//Map<Integer, List<Integer>> hash = new HashMap<>();
	Random random = new Random();
	//蓄水池算法
	int[] list;
    public RandomPickIndex(int[] nums) {
    	/*for(int i = 0;i < nums.length;i++) {
    		List<Integer> list = hash.getOrDefault(nums[i], new ArrayList<>());
    		list.add(i);
    		hash.put(nums[i], list);
    	}*/
    	list = nums;
    }
    
    public int pick(int target) {//数组是有序的
    	/*List<Integer> list = hash.get(target);
    	return list.get(random.nextInt(list.size()));*/
    	int len = list.length;
    	int ans = 0;
    	for(int i = 0,cnt = 0;i < len;i++) {
    		if (list[i] == target) {
				cnt++;
				if (random.nextInt(cnt) == 0) {
					ans = i;
				}
			}
    	}
    	return ans;
    }
}
