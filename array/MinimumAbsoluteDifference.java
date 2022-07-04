package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class MinimumAbsoluteDifference {
	// leetcode 1200 medium 2022/7/4
	// ¼òµ¥Ä£Äâ¼´¿É
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
    	int len = arr.length;
    	Arrays.sort(arr);
    	int min = arr[len - 1] - arr[0];
    	for(int i = 0;i < len - 1;i++) {
    		int temp = arr[i + 1] - arr[i];
    		if (temp < min) {
				min = temp;
			}
    	}
    	List<List<Integer>> ans = new ArrayList<>();
    	for(int i = 0;i < len - 1;i++) {
    		if (min == arr[i + 1] - arr[i]) {
				List<Integer> res = new ArrayList<>();
				res.add(arr[i]);
				res.add(arr[i + 1]);
				ans.add(res);
			}
    	}
    	return ans;
    }
}
