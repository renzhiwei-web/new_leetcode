package array;

public class RotateFunction {
	// leetcode 396 medium 2022/4/22
	// 首先容易想到暴力方法，按照题意模拟即可
	// 提交结果超出时间限制
    public int maxRotateFunction1(int[] nums) {
        int n = nums.length;
        int ans = Integer.MIN_VALUE;
        for(int k = 0;k < n;k++) {
        	ans = Math.max(ans, function(nums,k));
        }
        return ans;
    }

	private int function(int[] nums, int k) {
		int res = 0;
		int j = 0;
		for(int i = k;i < nums.length;i++,j++) {
			res += j * nums[i]; 
		}
		for(int i = 0;i < k;i++,j++) {
			res += j * nums[i];
		}
		return res;
	}
	
	// 仔细思考，发现f(k)之间的结果有一些规律
	// f(k) - f(k - 1) = nums[0] + nums[1] +... + nums[n - 1] - nums[k - 1] * n
	public int maxRotateFunction2(int[] nums) {
		int n = nums.length;
		int[] dp = new int[n];
		int sum = 0;
		for(int i = 0;i < n;i++) {
			sum += nums[i];
		}
		for(int i = 0;i < n;i++) {
			dp[0] += i * nums[i];
		}
		int ans = dp[0];
		for(int k = 1;k < n;k++) {
			dp[k] = dp[k - 1] + sum - (n * nums[n - k]);
			ans = Math.max(dp[k], ans);
		}
		return ans;
	}
	
	// 对动态规划进行优化，由于f(k)只与f(k - 1)有关，不需要数组
	public int maxRotateFunction(int[] nums) {
		int n = nums.length;
		int dp = 0;
		int sum = 0;
		for(int i = 0;i < n;i++) {
			sum += nums[i];
		}
		for(int i = 0;i < n;i++) {
			dp += i * nums[i];
		}
		int ans = dp;
		for(int k = 1;k < n;k++) {
			dp = dp + sum - (n * nums[n - k]);
			ans = Math.max(ans, dp);
		}
		return ans;
	}
}
