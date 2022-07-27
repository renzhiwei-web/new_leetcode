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
			// false��ʾ-��true��ʾ+
			boolean sign = true;
			if (expression.charAt(i) == '+' || expression.charAt(i) == '-') {
				sign = expression.charAt(i) == '+';
				i++;
			}
			// ��ȡ����
			while (i < len && Character.isDigit(expression.charAt(i))) {
				n2 = n2 * 10 + expression.charAt(i) - '0';
				i++;
			}
			if (!sign) {
				n2 = -n2;
			}
			// �ƶ� ����/
			i++;
			while (i < len && Character.isDigit(expression.charAt(i))) {
				d2 = d2 * 10 + expression.charAt(i) - '0';
				i++;
			}
			// ���
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
	 * շת����� ����m��n�����Լ��
	 *
	 * @param m
	 * @param n
	 * @return
	 */
	public long gcd(long m, long n) {
		return m % n == 0 ? n : gcd(n, m % n);
	}

}
