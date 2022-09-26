package array;

public class MissingTwo {
	// 首先容易想到使用相加求出两个缺失值的和，需要另一个等式，才能求出两个未知数
	// 可以用乘积形式，但是会溢出；
	// 可以将n项数列一分为2，以两缺失值和的中间值为分界，求出前一个缺失值
    public int[] missingTwo1(int[] nums) {
    	int len = nums.length;
    	int n = len + 2;
    	int[] ans = new int[2];
    	int sum = 0;
    	for(int i : nums) {
    		sum += i;
    	}
    	// 求出两个缺失值之和
    	int ts = (1 + n) * n / 2 - sum;
    	// 两个元素的分界值
    	int m = ts / 2; 
    	
    	// 将问题转换为求前一个元素的值
    	sum = 0;
    	for(int i : nums) {
    		if (i <= m) {
				sum += i;
			}
    	}
    	int res = (1 + m) * m / 2 - sum;
    	ans[0] = res;
    	ans[1] = ts - res;
    	return ans;
    }
    
    public int[] missingTwo(int[] nums) {
    	int n = nums.length + 2;
    	int res = 0;
    	// 对所有数值进行异或运算
    	for (int i = 1;i <= n;i++) {
    		res ^= i;
    	}
    	for (int i : nums) {
    		res ^= i;
    	}
    	// res为两个缺失值的异或结果
    	int diff = res & -res; // 求出res的lowbit值
    	// lowbit值：指一个数的二进制形式中，最低位的最后一个1和后面所有0组成的数的十进制形式。
    	// lowbit求法解释：计算机中数值以补码进行存放。
    	// diff就是这个异或值的lowbit，代表着这两个缺失数在diff位上必有一个是0和一个是1
    	int o = 0;
    	for(int i = 1;i <= n;i++) {
    		if ((diff & i) != 0) {
				o ^= i;
			}
    	}
    	for(int i : nums) {
    		if ((diff & i) != 0) {
				o ^= i;
			}
    	}
    	return new int[] {o,o ^ res};
    }
}
