package math;

public class PrimeArrangements {
	// leetcode 1175 simple 2022/6/30
	int mod = (int)(1e9) + 7;
    public int numPrimeArrangements(int n) {
    	int prime = 0;
    	// 获取所有质数的个数
    	for(int i = 2;i <= n;i++) {
    		if (isPrime(i)) {
				prime++;
			}
    	}
    	// 对质数与非质数进行全排列
    	return (int)(f(prime) * f(n - prime) % mod);
    }
    
    private long f(int n) {
		long ans = 1;
		for(int i = 2;i<= n;i++) {
			ans = ans * i;
			ans = ans % mod;
					
		}
		return ans;
	}

	// 判断是否是质数
	private boolean isPrime(int n) {
		if(n == 1) {
			return false;
		}
		for(int i = 2;i * i <= n;i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}
}
