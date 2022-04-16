package dp;

public class CountingBits {
	// leetcode 338 simple,2022/4/16
	// 最简单的方法是遍历
	// 学习如何求得整数二进制中1与0的个数
	// 通过将整数与1，2，4，8等数按位与即可
	public int[] countBits1(int n) {
		int[] ans = new int[n + 1];
		for(int i = 0;i <= n;i++) {
			ans[i] = getNum(i);
		}
		return ans;
    }

	public int getNum(int n) {
		int count = 0;
		int flag = 1;
		while(flag != 0) {
			if((n & flag) != 0) {
				count++;
			}
			flag = flag << 1;
		}
		return count;
	}
	
	// 分析：偶数i，则二进制中1的个数与i/2的二进制1的位数相等（偶数的二进制末尾是0）
	//      奇数i，则二进制中1的个数与i - 1的二进制数位数+1 相等
	// 根据以上分析，可以使用递归
	public int[] countBits2(int n) {
		int[] ans = new int[n + 1];
		for(int i = 0;i <= n;i++) {
			ans[i] = countBit(i);
		}
		return ans;
    }
	
	private int countBit(int n) {
		if(n == 1) {
			return 1;
		}
		if (n == 0) {
			return 0;
		}
		if(n % 2 == 0) {
			return countBit(n / 2);
		}else {
			return countBit(n - 1) + 1;
		}
	}
	
	// 根据递归方法，可以得出动态规划算法
	public int[] countBits3(int n) {
		int[] ans = new int[n + 1];
		ans[0] = 0;
		for(int i = 1;i <= n;i++) {
			if(i % 2 == 0) {
				ans[i] = ans[i >> 1];
			}else {
				ans[i] = ans[i - 1] + 1;
			}
		}
		return ans;
    }
	
	// 优化动态规划算法，由递归算法可得，偶数的二进制末尾是0，奇数的二进制末尾是1
	// 使用位运算判断奇偶性比mod运算快速
	public int[] countBits(int n) {
		int[] ans = new int[n + 1];
		ans[0] = 0;
		for(int i = 1;i <= n;i++) {
			if((i & 1) == 0) {
				ans[i] = ans[i >> 1];
			}else {
				ans[i] = ans[i - 1] + 1;
			}
		}
		return ans;
    }
}
