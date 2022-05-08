package stringclass;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinimumIndexSumOfTwoLists {
	// leetcode 599 simple 2022/5/8
	// 使用哈希方法进行模拟即可
    public String[] findRestaurant(String[] list1, String[] list2) {
    	int n = list1.length,m = list2.length;
    	Map<String, Integer> map = new HashMap<>();
    	for(int i = 0;i < n;i++) {
    		map.put(list1[i], i);
    	}
    	List<String> ans = new ArrayList<>();
    	int min = 3000;
    	for(int i = 0;i < m;i++) {
    		if (!map.containsKey(list2[i])) {
				continue;
			}
    		if (i + map.get(list2[i]) < min) {
				ans.clear();
				min = i + map.get(list2[i]);
				ans.add(list2[i]);
			}else if (i + map.get(list2[i]) == min) {
				ans.add(list2[i]);
			}
    	}
    	return ans.toArray(new String[ans.size()]);
    }
}
