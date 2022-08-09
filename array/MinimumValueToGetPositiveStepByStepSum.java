package array;

public class MinimumValueToGetPositiveStepByStepSum {
	// leetcode 1413 medium 2022/8/9
	// ʹ��ǰ׺��˼��
    public int minStartValue(int[] nums) {
    	int min = Integer.MAX_VALUE;
    	int sum = 0;
    	for(int num : nums) {
    		sum += num;
    		if (sum < min) {
				min = sum;
			}
    	}
    	return min <= 0 ? Math.abs(min) + 1 : 1;
    }
}
