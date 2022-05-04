package array;

import java.util.HashSet;
import java.util.Set;

public class DistributeCandies {
	// leetcode 575 simple 2022/5/4
	// 简单模拟即可
    public int distributeCandies(int[] candyType) {
    	int n  = candyType.length;
    	Set<Integer> set = new HashSet<>();
    	for(int type : candyType) {
    		set.add(type);
    	}
    	return Math.min(set.size(), n / 2);
    }
}
