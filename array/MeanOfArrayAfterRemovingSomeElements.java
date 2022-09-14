package array;

import java.util.Arrays;

public class MeanOfArrayAfterRemovingSomeElements {
	// leetcode 1619 simple 2022/9/14
	// ¼òµ¥Ä£Äâ¼´¿É
    public double trimMean(int[] arr) {
    	Arrays.sort(arr);
    	int n = arr.length;
    	int lost = n / 20;
    	double ans = 0.0;
    	for(int i = lost;i < n - lost;i++) {
    		ans += arr[i];
    	}
    	
    	return ans / (n - 2 * lost);
    }
}
