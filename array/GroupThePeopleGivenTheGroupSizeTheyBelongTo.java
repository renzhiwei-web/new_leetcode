package array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupThePeopleGivenTheGroupSizeTheyBelongTo {
	// leetcode 1282 medium 2022/8/12
	// 使用哈希表进行模拟
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
    	Map<Integer, List<Integer>> map = new HashMap<>();
    	int len = groupSizes.length;
    	for(int i = 0;i < len;i++) {
    		List<Integer> list = map.getOrDefault(groupSizes[i], new ArrayList<>());
    		list.add(i);
    		map.put(groupSizes[i], list);
    	}
    	List<List<Integer>> ans = new ArrayList<>();
    	for(int k : map.keySet()) {
    		List<Integer> list = map.get(k),cur = new ArrayList<>();
    		for(int i = 0;i < list.size();i++) {
    			cur.add(list.get(i));
    			if (cur.size() == k) {
					ans.add(cur);
					cur = new ArrayList<>();
				}
    		}
    	}
    	return ans;
    }
}
