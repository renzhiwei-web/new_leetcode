package array;

import java.util.Arrays;

public class HeightChecker {
	//leetcode 1051 simple 2022/6/13
	// ¼òµ¥µÄÅÅĞòÌâ
    public int heightChecker(int[] heights) {
    	int[] expected = heights.clone();
    	Arrays.sort(expected);
    	int ans = 0;
    	for(int i = 0;i < heights.length;i++) {
    		if(expected[i] != heights[i]) {
    			ans++;
    		}
    	}
    	return ans;
    }
}
