package math;

public class PrimeArrangements {
	// leetcode 1175 simple 2022/6/30
	int mod = (int)(1e9) + 7;
    public int numPrimeArrangements(int n) {
    	int prime = 0;
    	// ��ȡ���������ĸ���
    	for(int i = 2;i <= n;i++) {
    		if (isPrime(i)) {
				prime++;
			}
    	}
    	// �����������������ȫ����
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

	// �ж��Ƿ�������
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
