package math;

public class MinimumMovesToEqualArrayElements {
	// leetcode 453 simple 2022/4/22
	// 进行反向思考，对数组中的n-1个元素进行自增操作，相当于对一个元素进行自减操作
	// 由此容易想到，每次对数组中的最大值进行自减操作，直到数组中所有元素都相同
	// 考察灵活的反向思维与数学思维
    public int minMoves(int[] nums) {
    	int min = Integer.MAX_VALUE;
    	for(int i = 0;i < nums.length;i++) {
    		min = Math.min(min, nums[i]);
    	}
    	int ans = 0;
    	for(int i = 0;i < nums.length;i++) {
    		ans += nums[i] - min;
    	}
    	return ans;
    }
}
