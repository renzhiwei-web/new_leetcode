package array;

import java.util.Arrays;

public class MakeTwoArraysEqualByReversingSubArrays {
	// leetcode 1460 simple 2022/8/24
	// 根据冒泡排序可得，只有两个元素完全相同，才可以是arr变成target
    public boolean canBeEqual1(int[] target, int[] arr) {
    	Arrays.sort(target);
    	Arrays.sort(arr);
    	for(int i = 0;i < target.length;i++) {
    		if (target[i] != arr[i]) {
				return false;
			}
    	}
    	return true;
    }
    
    public boolean canBeEqual(int[] target, int[] arr) {
    	int[] hash = new int[1001];
        for (int i : target) {
            hash[i]++;
        }
        for (int i : arr) {
            if (--hash[i] < 0) {
                return false;
            }
        }
        return true;
    }
}
