package math;

public class PreimageSizeOfFactorialZeroesFunction {
    public int preimageSizeFZF(int k) {
    	
    	return (int)(calMinkZero(k + 1) - calMinkZero(k));
    }

    // 二分法计算第一个x,使得 f(x) = k
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

	// 由数算推导可知，阶乘中0的个数由可分解出多少个10决定，10 = 5 * 2，
	// 由于5的个数比2少，所以判断可分解出多少个5即可
	private int calZero(long n) {
		int ans = 0;
		while(n != 0) {
			n = n / 5;
			ans += n;
		}
		return ans;
	}
}
