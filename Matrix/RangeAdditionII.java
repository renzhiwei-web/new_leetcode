package array;

public class RangeAdditionII {
	// leetcode 598 simple 2022/5/7
	// 由题意可知，直接维护所有数组的的交集即可
    public int maxCount(int m, int n, int[][] ops) {
    	for(int[] op :ops) {
    		m = Math.min(m, op[0]);
    		n = Math.min(n, op[1]);
    	}
    	return m * n;
    }
}
