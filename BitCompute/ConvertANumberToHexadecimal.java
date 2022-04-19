package bitCompute;

public class ConvertANumberToHexadecimal {
	// leetcode 405 simple 2022/4/19
	// 容易想到效仿2进制的变换，使用短除法将十进制转换成二进制
	// 难点是负数的处理
	public String toHex(int num) {
		if(num == 0) {
			return "0";
		}
		long tempNum = num;
		StringBuilder sb = new StringBuilder();
		if(tempNum < 0) {
			tempNum = (long)(Math.pow(2, 32) + tempNum);
		}
		while(tempNum != 0) {
			long u = tempNum % 16;
			char c = (char)(u + '0');
			if (u >= 10) {
				c = (char)(u - 10 + 'a');
			}
			sb.append(c);
			tempNum /= 16;
		}
		return sb.reverse().toString();
    }
}
