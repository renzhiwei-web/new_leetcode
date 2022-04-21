package array;

import java.util.ArrayList;
import java.util.List;

public class FindAllNumbersDisappearedInAnArray {
    public List<Integer> findDisappearedNumbers(int[] nums) {
    	// leetcode 448 simple 2022/4/21
    	// 首先容易想到排序方法，但是要求时间复杂度为O(n),则使用哈希数组方法
        List<Integer> ans = new ArrayList<Integer>();
        int n = nums.length;
        int[] hash = new int[n + 1];
        for(int i = 0;i < n;i++) {
        	hash[nums[i]]++;
        }
        for(int i = 1;i <= n;i++) {
        	if(hash[i] == 0) {
        		ans.add(i);
        	}
        }
        return ans;
    }
}
