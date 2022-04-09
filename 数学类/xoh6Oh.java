public int divide(int a, int b) {
			if (a == Integer.MIN_VALUE && b == -1){
					return Integer.MAX_VALUE;
			}
			int sign = (a > 0) ^ (b > 0) ? -1 : 1;//若a,b不同时为正数，则sign = -1
			if (a > 0) a = -a;
			if (b > 0) b = -b;
			int res = 0;
			while(a <= b){
					int value = b;
					int k = 1;
					// 0xc0000000 是十进制 -2^30 的十六进制的表示
					// 判断 value >= 0xc0000000 的原因：保证 value + value 不会溢出
					// 可以这样判断的原因是：0xc0000000 是最小值 -2^31 的一半，
					// 而 a 的值不可能比 -2^31 还要小，所以 value 不可能比 0xc0000000 小
					while(value >= 0xc0000000 && a <= value + value){
							value += value;//减数成倍增加
							k += k;
					}
					a -= value;
					res += k;
			}
			return sign == 1 ? res : -res;
	}
