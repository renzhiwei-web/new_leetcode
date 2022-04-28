package array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class RelativeRanks {
	// leetcode 506 simple 2022/4/28
	// 通过排序
	String[] ss = new String[]{"Gold Medal", "Silver Medal", "Bronze Medal"};
    public String[] findRelativeRanks(int[] score) {
    	int n = score.length;
    	String[] ans = new String[n];
    	int[] clone = score.clone();
    	Arrays.sort(clone);
    	Map<Integer, Integer> hash = new HashMap<>();
    	for(int i = n - 1;i >=0;i--) {
    		hash.put(clone[i], n - 1 - i);
    	}
    	for(int i = 0;i < n;i++) {
    		int rank = hash.get(score[i]);
    		ans[i] = rank < 3 ? ss[rank] : String.valueOf(rank + 1);
    	}
    	return ans;
    }
}
