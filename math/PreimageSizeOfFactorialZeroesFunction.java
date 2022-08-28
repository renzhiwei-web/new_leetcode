package math;

public class PreimageSizeOfFactorialZeroesFunction {
    public int preimageSizeFZF(int k) {
    	
    	return (int)(calMinkZero(k + 1) - calMinkZero(k));
    }

    // ���ַ������һ��x,ʹ�� f(x) = k
	private long calMinkZero(int k) {
		long left = 0L;
		long ritht = 5L * k;
		long ans = ritht;
		while(left <= ritht) {
			long mid = left + (ritht - left) / 2;
			if (calZero(mid) >= k) {
				ritht = mid - 1;
				ans = mid;
			}else {
				left = mid + 1;
			}
		}
		return ans;
	}

	// �������Ƶ���֪���׳���0�ĸ����ɿɷֽ�����ٸ�10������10 = 5 * 2��
	// ����5�ĸ�����2�٣������жϿɷֽ�����ٸ�5����
	private int calZero(long n) {
		int ans = 0;
		while(n != 0) {
			n = n / 5;
			ans += n;
		}
		return ans;
	}
}
