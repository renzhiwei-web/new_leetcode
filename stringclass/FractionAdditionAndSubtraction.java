package stringclass;

public class FractionAdditionAndSubtraction {
	public String fractionAddition(String expression) {
		int len = expression.length();
		long n1 = 0;
		long d1 = 1;
		int i = 0;
		while (i < len) {
			long n2 = 0;
			long d2 = 0;
			// false表示-，true表示+
			boolean sign = true;
			if (expression.charAt(i) == '+' || expression.charAt(i) == '-') {
				sign = expression.charAt(i) == '+';
				i++;
			}
			// 获取分子
			while (i < len && Character.isDigit(expression.charAt(i))) {
				n2 = n2 * 10 + expression.charAt(i) - '0';
				i++;
			}
			if (!sign) {
				n2 = -n2;
			}
			// 移动 除号/
			i++;
			while (i < len && Character.isDigit(expression.charAt(i))) {
				d2 = d2 * 10 + expression.charAt(i) - '0';
				i++;
			}
			// 相加
			n1 = n1 * d2 + n2 * d1;
			d1 = d1 * d2;
		}
		if (n1 != 0) {
			long gcd = Math.abs(gcd(d1, n1));
			d1 = d1 / gcd;
			n1 = n1 / gcd;
		} else {
			d1 = 1;
		}
		return n1 + "/" + d1;
	}

	/**
	 * 辗转相除法 计算m和n的最大公约数
	 *
	 * @param m
	 * @param n
	 * @return
	 */
	public long gcd(long m, long n) {
		return m % n == 0 ? n : gcd(n, m % n);
	}

}
