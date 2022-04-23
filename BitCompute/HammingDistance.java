package bitCompute;

public class HammingDistance {
	// leetcode 461 simple 2022/4/23
	// 首先容易想到暴力法，通过将两数的二进制表示出来，进行逐个比较
	public int hammingDistance1(int x, int y) {
		char[] xBin = toBin(x);
		char[] yBin = toBin(y);
		int xLen = xBin.length;
		int yLen = yBin.length;
		int xindex = 0,yindex = 0;
		int ans = 0;
		while(xindex < xLen && yindex < yLen) {
			if(xBin[xindex] != yBin[yindex]) {
				ans++;
			}
			xindex++;
			yindex++;
		}
		
		while(xindex < xLen) {
			if(xBin[xindex] == '1') {
				ans++;
			}
			xindex++;
		}
		while(yindex < yLen) {
			if(yBin[yindex] == '1') {
				ans++;
			}
			yindex++;
		}
		return ans;
	}
	
	// 由于此题x，y都是正数，则无需判断
	// 结果是低位在前，高位在后
	private char[] toBin(int num) {
		if(num == 0) {
			return new char[] {'0'};
		}
		StringBuilder sb = new StringBuilder();
		while(num != 0) {
			int u = num % 2;
			char c = (char)(u + '0');
			sb.append(c);
			num /= 2;
		}
		return sb.toString().toCharArray();
	}
	
	public static void main(String[] args) {
		new HammingDistance().hammingDistance(1, 4);
	}
	
	//对暴力法进行优化，每次比较两个数的低位二进制数即可，但是这样同样需要先将十进制转换二进制
	// 可以使用中间变量来进行比较，这样可以使用移位操作进行比较，无需转化为二进制
	public int hammingDistance(int x, int y) {
		int ans = 0;
		for(int i = 0;i < 32;i++) {
			int a = (x >> i) & 1;
			int b = (y >> i) & 1;
			ans += a ^ b;
		}
		return ans;
	}
}
