package bitCompute;

public class BinaryGap {
	// leetcode 868 simple 2022/4/24
	// 首先使用暴力法
    public int binaryGap1(int n) {
    	char[] nToBin = toBin(n);
    	int i = 0,j = 0;
    	int ans = 0;
    	while(i < nToBin.length && j < nToBin.length) {
    		if(nToBin[i] == '1') {
    			j = i + 1;
    			while(j < nToBin.length && nToBin[j] == '0') {
    				j++;
    			}
    			if (j != nToBin.length) {
    				ans = Math.max(ans, j - i);
				}
    		}
    		i++;
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
 	
 	//使用位运算
 	public int binaryGap(int n) {
 		int last = -1,ans = 0;
 		for(int i = 0;n != 0;i++) {
 			if((n & 1) == 1) {
 				if(last != -1) {
 					ans = Math.max(ans, i - last);
 				}
 				last = i;
 			}
 			n >>= 1;
 		}
 		return ans;
 	}
}
