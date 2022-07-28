package array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class RankTransformOfAnArray {
	// leetcode 1331 simple 2022/7/28
	// ¼òµ¥Ä£Äâ¼´¿É
    public int[] arrayRankTransform(int[] arr) {
    	int len = arr.length;
    	int[] arrBk = arr.clone();
    	Arrays.sort(arrBk);
    	Map<Integer, Integer> map = new HashMap<>();
    	for(int i = 0,index = 1;i < len;i++) {
    		if (!map.containsKey(arrBk[i])) {
				map.put(arrBk[i], index++);
			}
    	}
    	for(int i = 0;i < len;i++) {
    		arr[i] = map.get(arr[i]);
    	}
    	return arr;
    }
}
